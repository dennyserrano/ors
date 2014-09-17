package ph.gov.deped.service.etl.ds;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ph.gov.deped.service.etl.meta.MetadataHolder;

@Configuration
public class DefaultDatasetsBatchSpringConfig {
    
    public static final String DEFAULT_DATASETS_JOB = "defaultDatasetsEtlJob";

    private @Autowired JobBuilderFactory jobs;

    private @Autowired StepBuilderFactory steps;

    public @Bean Job defaultDatasetsEtlJob() {
        return jobs.get(DEFAULT_DATASETS_JOB)
                .incrementer(new RunIdIncrementer())
                .flow(physicalTablesEtlStep())
                .end()
                .build();
    }

    // RAW Tables dataset and count.
    public @Bean Step physicalTablesEtlStep() {
        return steps.get("physicalTablesEtlStep")
                .<MetadataHolder, DbTypeSqlMapping>chunk(4)
                .reader(physicalTableItemReader())
                .processor(physicalMetadataToSQLProcessor())
                .writer(physicalTableToWarehouseItemWriter())
                .build();
    }

    public @Bean ItemReader<MetadataHolder> physicalTableItemReader() {
        return new PhysicalTableItemReader();
    }

    public @Bean ItemProcessor<MetadataHolder, DbTypeSqlMapping> physicalMetadataToSQLProcessor() {
        return new PhysicalTableToSqlItemProcessor();
    }

    public @Bean ItemWriter<DbTypeSqlMapping> physicalTableToWarehouseItemWriter() {
        return new PhysicalDataToWarehouseItemWriter();
    }

    // TODO School dataset and count.
    
    // TODO Enrollment dataset and count.
    
    // TODO Personnel dataset and count.
    
    // TODO Facilities dataset and count.
}
