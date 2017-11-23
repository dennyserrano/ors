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
//@ComponentScan(
//        basePackages = {"com.model"},
//        useDefaultFilters = false,
//        includeFilters = {
//                @ComponentScan.Filter(value = {Entity.class}, type = FilterType.ANNOTATION),
//         
//        }
//)
@EntityScan("com.model")
@EnableJpaRepositories(
        basePackages = {"com.repo.meta"},
        includeFilters = {
                @ComponentScan.Filter(value = Repository.class, type = FilterType.ANNOTATION)
        }
//        ,entityManagerFactoryRef="reportconfig_entityManagerFactory"
)

public class CentralizedRepositoriesConfiguration {
	
	
}
