package com.generate.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(basePackages = {"com.generate.api","com.generate.core","com.generate.styles"},
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(value = {Service.class}, type = FilterType.ANNOTATION),
        }
)
public class ReportServicesConfiguration {

}
