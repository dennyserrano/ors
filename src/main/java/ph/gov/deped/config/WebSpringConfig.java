package ph.gov.deped.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ej on 8/22/14.
 */
@Configuration
@ComponentScan(
        basePackages = { "ph.gov.deped.web" },
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(value = { Controller.class, RestController.class})
        }
)
public class WebSpringConfig {
   
    public @Bean NumberFormatAnnotationFormatterFactory numberFormatter() {
        return new NumberFormatAnnotationFormatterFactory();
    }
    
    public @Bean DateTimeFormatAnnotationFormatterFactory dateTimeFormat() {
        return new DateTimeFormatAnnotationFormatterFactory();
    }
}
