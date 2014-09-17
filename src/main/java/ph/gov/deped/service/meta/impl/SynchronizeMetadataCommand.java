package ph.gov.deped.service.meta.impl;

import static java.util.Arrays.asList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import ph.gov.deped.common.EbeisMetadata;
import ph.gov.deped.common.LisMetadata;
import ph.gov.deped.common.command.Command;
import ph.gov.deped.common.command.ICommand;
import ph.gov.deped.common.dw.DbType;
import ph.gov.deped.data.config.DbMappings;
import ph.gov.deped.data.ors.meta.ColumnMetadata;
import ph.gov.deped.data.ors.meta.TableMetadata;
import ph.gov.deped.repo.jpa.ebeis.MetaRepository;
import ph.gov.deped.service.etl.meta.MetadataHolder;
import ph.gov.deped.service.etl.meta.MetadataRegistry;
import ph.gov.deped.service.meta.api.MetadataSynchronizationException;
import ph.gov.deped.service.meta.api.SynchronizeMetadataContext;

/**
 * Created by ej on 8/20/14.
 */
public @Command class SynchronizeMetadataCommand implements ICommand<SynchronizeMetadataContext>, ApplicationContextAware {

    private static final Logger log = LogManager.getLogger(SynchronizeMetadataCommand.class);

    private MetadataRegistry metadataRegistry;
    
    private ApplicationContext applicationContext;
    
    private Set<String> dataSourceNames = new HashSet<>(asList(
           EbeisMetadata.DS,
           LisMetadata.DS
    ));

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public @Autowired void setMetadataRegistry(MetadataRegistry metadataRegistry) {
        this.metadataRegistry = metadataRegistry;
    }

    public void execute(SynchronizeMetadataContext context) {
        log.entry(context);
        log.debug("Synchronizing Metadata...");
        final AtomicInteger tableId = new AtomicInteger(0);
        final AtomicInteger columnId = new AtomicInteger(0);
        try {
            dataSourceNames.parallelStream()
                .map(DbContext::new)
                .map(ctx -> ctx.setDbType(DbMappings.getDbType(ctx.getDataSourceName())))
                .map(ctx -> ctx.setDataSource(applicationContext.getBean(ctx.getDataSourceName(), DataSource.class)))
                .map(DbContext::initMetaRepository)
                .map(ctx -> {
                    List<TableMetadata> tables = ctx.metaRepository().findTables();
                    List<MetadataHolder> holders = tables.parallelStream()
                            .map(table -> {
                                table.setTableId(tableId.incrementAndGet());
                                return new MetadataHolder(table);
                            })
                            .collect(Collectors.toList());
                    ctx.setMetadataHolders(holders);
                    return ctx;
                })
                .map(ctx -> {
                    ctx.getMetadataHolders().parallelStream()
                            .forEach(h -> {
                                List<ColumnMetadata> columns = ctx.metaRepository().findColumns(h.getTableMetadata());
                                columns.parallelStream().forEach(c -> c.setColumnId(columnId.incrementAndGet()));
                                h.setColumnMetadatas(columns);
                            });
                    return ctx;
                })
                .forEach(ctx -> {
                    ctx.getMetadataHolders().parallelStream()
                            .forEach(h -> {
                                String key = ctx.getDbType().getDbName().toUpperCase() + "." + h.getTableMetadata().getTableName();
                                metadataRegistry.register(key, h);
                            });
                });
        }
        catch (Exception ex) {
            log.error(new ParameterizedMessage("Error while reading meta dataSources [{}].", new Object[] { dataSourceNames }, ex), ex);
            log.catching(ex);
            throw new MetadataSynchronizationException(ex);
        }
        context.success().createResponse();
        log.info("Total metadata in registry [{}].", metadataRegistry.getMetadataKeys().size());
        log.debug("Done Synchronizing Metadata.");
        log.exit();
    }
    
    private static class DbContext {
        protected final String dataSourceName;
        protected DbType dbType;
        protected DataSource dataSource;
        protected MetaRepository metaRepository;
        protected List<MetadataHolder> metadataHolders;
        public DbContext(String dataSourceName) {
            this.dataSourceName = dataSourceName;
        }
        public String getDataSourceName() {
            return dataSourceName;
        }
        public DbType getDbType() {
            return dbType;
        }
        public DbContext setDbType(DbType dbType) {
            this.dbType = dbType;
            return this;
        }
        public DbContext setDataSource(DataSource dataSource) {
            this.dataSource = dataSource;
            return this;
        }
        public DbContext initMetaRepository() {
            metaRepository = new MetaRepository(dataSource, dbType);
            return this;
        }
        public MetaRepository metaRepository() {
            return metaRepository;
        }
        public List<MetadataHolder> getMetadataHolders() {
            return metadataHolders;
        }
        public void setMetadataHolders(List<MetadataHolder> metadataHolders) {
            this.metadataHolders = metadataHolders;
        }
    }
}
