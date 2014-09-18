package ph.gov.deped.service.etl.meta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.core.cql.CqlIdentifier;
import org.springframework.cassandra.core.keyspace.CreateKeyspaceSpecification;
import org.springframework.cassandra.core.keyspace.CreateTableSpecification;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.CassandraAdminOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import ph.gov.deped.common.DbSettings;
import ph.gov.deped.common.dw.DbType;
import ph.gov.deped.common.dw.JobRestartEvent;
import ph.gov.deped.common.dw.JobStatusChecker;
import ph.gov.deped.config.EbeisSettings;
import ph.gov.deped.config.LisSettings;
import ph.gov.deped.config.OrsSettings;
import ph.gov.deped.data.ors.meta.DatabaseMetadata;
import ph.gov.deped.repo.jpa.ors.meta.ColumnMetadataRepository;
import ph.gov.deped.repo.jpa.ors.meta.DatabaseMetadataRepository;
import ph.gov.deped.repo.jpa.ors.meta.TableMetadataRepository;
import ph.gov.deped.security.SecurityContextUtil;
import ph.gov.deped.service.meta.api.MetadataService;

/**
 * Created by ej on 8/18/14.
 */
@Configuration
public class MetadataSyncBatchSpringConfig implements ApplicationContextAware {

    public static final String METADATA_SYNC_JOB = "metadataSyncJob";

    private static final Logger log = LogManager.getLogger(MetadataSyncBatchSpringConfig.class);

    private final AtomicBoolean started = new AtomicBoolean(false);

    private @Autowired JobBuilderFactory jobs;

    private @Autowired StepBuilderFactory steps;

    private @Autowired DatabaseMetadataRepository databaseMetadataRepository;

    private @Autowired TableMetadataRepository tableMetadataRepository;

    private @Autowired ColumnMetadataRepository columnMetadataRepository;

    private @Autowired OrsSettings orsSettings;

    private @Autowired EbeisSettings ebeisSettings;

    private @Autowired LisSettings lisSettings;

    private @Autowired SecurityContextUtil securityContextUtil;

    private @Autowired MetadataService metadataService;

    private @Autowired JobStatusChecker jobStatusChecker;

    private @Autowired CassandraAdminOperations cassandraAdminTemplate;

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public @Bean MetadataRegistry metadataRegistry() {
        return new MetadataRegistry();
    }

    public @Bean MetadataParser metadataParser() {
        return new MetadataParser();
    }

    public @Bean Map<DbType, DbSettings> dbTypeMap() {
        Map<DbType, DbSettings> dbMap = new HashMap<>(3);
        dbMap.put(DbType.DWRHS, orsSettings);
        dbMap.put(DbType.LIS, lisSettings);
        dbMap.put(DbType.EBEIS, ebeisSettings);
        return dbMap;
    }

    public @Bean Job metadataSyncJob() {
        return jobs.get(METADATA_SYNC_JOB)
                .listener(new JobExecutionListener() {
                    public void beforeJob(JobExecution jobExecution) {
                        securityContextUtil.createInternalUserAuthentication("SYSTEM");
                        log.info("Job [{}] started.", METADATA_SYNC_JOB);
                    }

                    public void afterJob(JobExecution jobExecution) {
                        securityContextUtil.removeAuthentication();
                        log.info("Job [{}] finished.", METADATA_SYNC_JOB);
                    }
                })
                .start(initializeDatabaseMetadataStep())
                .next(cleanupTableAndColumnMetadataStep())
                .next(metadataSynchronizeStep())
                .next(metadataSyncFlow())
                .next(physicalTableEtlDataWarehouseFlow())
                .next(physicalToDatasetStep())
                .next(publishSuccessfulMetadataSynchronizationStep())
                .build();
    }

    public @Bean Step initializeDatabaseMetadataStep() {
        return steps.get("initializeDatabaseMetadataStep")
                .<DbType, DbType>chunk(DbType.values().length)
                .reader(new IteratorItemReader<>(Arrays.asList(DbType.values()).iterator()))
                .writer(items -> items.forEach(i -> {
                    Integer dbId = i.ordinal();
                    DbSettings v = dbTypeMap().get(i);
                    DatabaseMetadata databaseMetadata = databaseMetadataRepository.findOne(dbId);
                    if (databaseMetadata == null) {
                        databaseMetadata = new DatabaseMetadata(dbId, v.getDbName(), v.getDbHost(), v.getDbPort(),
                                DatabaseMetadata.STEP_DEV, v.getDbUser(), v.getDbPass());
                        databaseMetadataRepository.insert(databaseMetadata);
                    }
                    cassandraAdminTemplate.execute(
                            CreateKeyspaceSpecification.createKeyspace(v.getDbName())
                                    .ifNotExists()
                                    .withSimpleReplication(1)
                            
                    );
                }))
                .build();
    }

    public @Bean Step cleanupTableAndColumnMetadataStep() {
        return steps.get("cleanupTableAndColumnMetadataStep")
                .tasklet((con, ctx) -> {
                    columnMetadataRepository.deleteAllInBatch();
                    tableMetadataRepository.deleteAllInBatch();
                    tableMetadataRepository.flush();
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    public @Bean Step metadataSynchronizeStep() {
        return steps.get("metadataSynchronizeStep")
                .tasklet((con, ctx) -> {
                    try {
                        metadataService.startSynchronizing();
                    }
                    catch (Exception ex) {
                        log.error("Failed to synchronize metadata from classpath.", ex);
                    }
                    return RepeatStatus.FINISHED;
                })
                .transactionAttribute(new DefaultTransactionAttribute())
                .build();
    }

    public @Bean Step metadataSyncFlow() {
        return steps.get("metadataSyncFlow")
                .<String, MetadataHolder>chunk(8)
                .reader(registryItemReader())
                .processor(c -> metadataRegistry().getMetadata(c))
                .writer(metadataHolderItemWriter())
                .build();
    }
    
    public @Bean RegistryItemReader registryItemReader() {
        return new RegistryItemReader();
    }

    public @Bean ItemWriter<MetadataHolder> metadataHolderItemWriter() {
        return items -> items.forEach(h -> {
            securityContextUtil.createInternalUserAuthentication("SYSTEM");
            tableMetadataRepository.save(h.tableMetadata);
            AtomicInteger batch = new AtomicInteger(0);
            h.columnMetadatas.parallelStream().forEach(col -> {
                batch.incrementAndGet();
                securityContextUtil.createInternalUserAuthentication("SYSTEM");
                columnMetadataRepository.save(col);
                if (batch.get() % 10 == 0) {
                    columnMetadataRepository.flush();
                }
                securityContextUtil.removeAuthentication();
            });
            securityContextUtil.removeAuthentication();
        });
    }

    public @Bean Step physicalTableEtlDataWarehouseFlow() {
        return steps.get("physicalTableEtlDataWarehouseFlow")
                .<String, CreateTableSpecification>chunk(8)
                .reader(registryItemReader())
                .processor(metadataHolderCassandraItemProcessor())
                .writer(items -> items.parallelStream().forEach(item -> {
                    String tableName;
                    CqlIdentifier tableCqlId = item.getName();
                    if (tableCqlId.isQuoted()) {
                        tableName = tableCqlId.getUnquoted();
                    }
                    else {
                        tableName = tableCqlId.toCql();
                    }
                    String[] tableSpec = tableName.split("\\.");
                    cassandraAdminTemplate.execute("USE " + tableSpec[0]);
                    item.name(tableSpec[1]);
                    cassandraAdminTemplate.execute(item);
                }))
                .build();
    }

    public @Bean ItemProcessor<String, CreateTableSpecification> metadataHolderCassandraItemProcessor() {
        return new MetadataHolderCassandraItemProcessor();
    }

    public @Bean Step physicalToDatasetStep() {
        return steps.get("physicalToDatasetStep")
                .<String, MetadataHolder>chunk(8)
                .reader(registryItemReader())
                .processor(key -> metadataRegistry().getMetadata(key))
                .writer(physicalDatasetItemWriter())
                .build();
    }
    
    public @Bean PhysicalDatasetItemWriter physicalDatasetItemWriter() {
        return new PhysicalDatasetItemWriter();
    }

    public @Bean Step publishSuccessfulMetadataSynchronizationStep() {
        return steps.get("publishSuccessfulMetadataSynchronizationStep")
                .tasklet(physicalTableDataJobRestartTasklet())
                .build();
    }
    
    public @Bean PhysicalTableDataJobRestartTasklet physicalTableDataJobRestartTasklet() {
        return new PhysicalTableDataJobRestartTasklet();
    }

    public @Scheduled(fixedDelay = 10000) void startMetadataSyncJob() {
        if (started.get()) {
            return;
        }
        started.compareAndSet(false, true);
        JobParameters jobParameters = new JobParameters();
        if (jobStatusChecker.check(METADATA_SYNC_JOB, jobParameters).hasFailed()) {
            Map<String, JobParameter> jobParameterMap = new HashMap<>();
            jobParameterMap.put("ID", new JobParameter(UUID.randomUUID().toString(), true));
            applicationContext.publishEvent(new JobRestartEvent(this, METADATA_SYNC_JOB, jobParameterMap));
        }
    }
}
