package ph.gov.deped.service.config;

import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.support.DatabaseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import ph.gov.deped.common.dw.JobRestartEventListener;
import ph.gov.deped.common.dw.JobStatusChecker;
import ph.gov.deped.service.etl.ds.DefaultDatasetsBatchSpringConfig;
import ph.gov.deped.service.etl.meta.MetadataSyncBatchSpringConfig;

import javax.sql.DataSource;

/**
 * Created by ej on 8/14/14.
 */
@Configuration
@EnableBatchProcessing
@Import({
        MetadataSyncBatchSpringConfig.class,
        DefaultDatasetsBatchSpringConfig.class
})
public class BatchSpringConfig {

    public static final String BATCH_DB_PREFIX = "BATCH_";

    private @Autowired DataSource dataSource;

    private @Autowired PlatformTransactionManager transactionManager;

    private @Autowired TaskExecutor taskExecutor;

    public @Primary @Bean JobLauncher jobLauncher() {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setTaskExecutor(taskExecutor);
        try {
            jobLauncher.setJobRepository(jobRepository());
        }
        catch (Exception ex) {
            throw new RuntimeException("Unable to configure Spring Batch Job.", ex);
        }
        return jobLauncher;
    }

    public @Primary @Bean JobRepository jobRepository() throws Exception {
        JobRepositoryFactoryBean r = new JobRepositoryFactoryBean();
        r.setDataSource(dataSource);
        r.setDatabaseType(DatabaseType.MYSQL.getProductName());
        r.setJdbcOperations(new JdbcTemplate(dataSource));
        r.setTransactionManager(transactionManager);
        r.setValidateTransactionState(false);
        r.setIsolationLevelForCreate("ISOLATION_" + Isolation.READ_UNCOMMITTED.name());
        r.setTablePrefix(BATCH_DB_PREFIX);
        return r.getObject();
    }

    public @Bean JobExplorerFactoryBean jobExplorer() {
        JobExplorerFactoryBean e = new JobExplorerFactoryBean();
        e.setDataSource(dataSource);
        e.setLobHandler(new DefaultLobHandler());
        e.setTablePrefix(BATCH_DB_PREFIX);
        return e;
    }

    public @Bean JobRegistry jobRegistry() {
        return new MapJobRegistry();
    }

    public @Bean JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor() {
        JobRegistryBeanPostProcessor p = new JobRegistryBeanPostProcessor();
        p.setJobRegistry(jobRegistry());
        return p;
    }

    public @Bean JobBuilderFactory jobBuilders() throws Exception {
        return new JobBuilderFactory(jobRepository());
    }

    public @Bean StepBuilderFactory stepBuilders() throws Exception {
        return new StepBuilderFactory(jobRepository(), transactionManager);
    }

    public @Bean JobStatusChecker jobStatusChecker() {
        return new JobStatusChecker();
    }

    public @Bean JobRestartEventListener jobRestartEventListener() {
        return new JobRestartEventListener();
    }
}
