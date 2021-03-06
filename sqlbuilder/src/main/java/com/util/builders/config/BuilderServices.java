package com.util.builders.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;


@Configuration
@ComponentScan(basePackages = {"com.util.builders.api"},
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(value = {Service.class}, type = FilterType.ANNOTATION),
        }
)
public class BuilderServices {
	
	
	
}
