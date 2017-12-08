package ph.gov.deped.repo.config.ors;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import ph.gov.deped.common.AppMetadata;

/**
 * Created by ej on 8/15/14.
 */
@Configuration
@ComponentScan(
        basePackages = {AppMetadata.REPO_PACKAGE},
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(value = Repository.class, type = FilterType.ANNOTATION)
        }
)


@EnableJpaRepositories(
        basePackages = {AppMetadata.REPO_PACKAGE},
        includeFilters = {
                @ComponentScan.Filter(value = Repository.class, type = FilterType.ANNOTATION)
        }
)
@PropertySource({"classpath:" + AppMetadata.PROPS})
public class ApplicationRepositorySpringConfig implements AppMetadata {
}
