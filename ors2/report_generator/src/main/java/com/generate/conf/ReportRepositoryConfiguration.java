package com.generate.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan(basePackages = {"com.generate.repo"},
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(value = {Repository.class}, type = FilterType.ANNOTATION),
        }
)
public class ReportRepositoryConfiguration {

}
