package com.reportconfig.conf;

import javax.persistence.Entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;




@Configuration
@ComponentScan(
        basePackages = {"com.repo.meta"},
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(value = {Repository.class}, type = FilterType.ANNOTATION),
         
        }
)
@EnableJpaRepositories(
        basePackages = {"com.repo.meta"},
        includeFilters = {
                @ComponentScan.Filter(value = Repository.class, type = FilterType.ANNOTATION)
        },
        repositoryFactoryBeanClass = Class.class//BaseJpaRepositoryFactoryBean.class
)
public class SpringRepositoriesConfig {
	public SpringRepositoriesConfig()
	{
		
	}
}
