package com.util.builders.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@Import({
	BuilderServices.class
	})
public class SqlBuilderConfiguration
{
	
}
