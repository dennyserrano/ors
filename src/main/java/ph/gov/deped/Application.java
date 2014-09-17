package ph.gov.deped;

import java.util.Locale;

import org.springframework.boot.SpringApplication;

import ph.gov.deped.config.ApplicationSpringConfig;

/**
 * Created by ej on 8/7/14.
 */
public class Application {
    
    public static final String defaultLocale = "en";

    public static void main(String[] args) {
        Locale.setDefault(new Locale(defaultLocale));
        //SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_GLOBAL);
        SpringApplication.run(new Class<?>[] {ApplicationSpringConfig.class}, args).registerShutdownHook();
    }
}
