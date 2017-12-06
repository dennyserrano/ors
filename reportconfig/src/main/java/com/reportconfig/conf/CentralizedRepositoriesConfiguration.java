package com.reportconfig.conf;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.repo.meta.DatasetRepository;




@Configuration
@EntityScan("com.model")
@EnableJpaRepositories(
        basePackages = {"com.repo"},
        includeFilters = {
                @ComponentScan.Filter(value = Repository.class, type = FilterType.ANNOTATION)
        }
)

public class CentralizedRepositoriesConfiguration {
	
	
}
