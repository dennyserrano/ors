package ph.gov.deped.repo.config.ebeis;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import ph.gov.deped.common.EbeisMetadata;
import ph.gov.deped.repo.jpa.api.BaseJpaRepositoryFactoryBean;

/**
 * Created by ej on 8/5/14.
 */
@Configuration
@ComponentScan(
        basePackages = {EbeisMetadata.REPO_PACKAGE},
        useDefaultFilters = false,
        includeFilters = {
                @Filter(value = {Repository.class})
        }
)
@EnableJpaRepositories(
        basePackages = {EbeisMetadata.REPO_PACKAGE},
        includeFilters = {
                @Filter(value = Repository.class, type = FilterType.ANNOTATION)
        },
        entityManagerFactoryRef = EbeisMetadata.EMF,
        repositoryFactoryBeanClass = BaseJpaRepositoryFactoryBean.class
)
@PropertySource({"classpath:" + EbeisMetadata.EBEIS_PROPS})
public class EBEISRepositorySpringConfig {
}
