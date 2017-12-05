package com.generate.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(basePackages = {"com.generate.core"},
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(value = {Component.class}, type = FilterType.ANNOTATION),
        }
)
public class ReportComponentConfiguration {

}
