package ph.gov.deped;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

import ph.gov.deped.config.ApplicationSpringConfig;

/**
 * Created by ej on 8/19/14.
 */
public class ApplicationWebInitializer extends SpringBootServletInitializer implements WebApplicationInitializer {

    protected @Override SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application
                .sources(ApplicationSpringConfig.class)
                .web(true)
                .logStartupInfo(true)
                .registerShutdownHook(true);
    }
}
