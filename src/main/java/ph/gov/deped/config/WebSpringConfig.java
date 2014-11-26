package ph.gov.deped.config;

import org.springframework.context.annotation.*;
import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import ph.gov.deped.data.dto.DatasetStore;

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

    @Scope(proxyMode= ScopedProxyMode.TARGET_CLASS, value = WebApplicationContext.SCOPE_SESSION)
    public @Bean DatasetStore datasetStore() {
        return new DatasetStore();
    }
}
