package ph.gov.deped.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.token.SecureRandomFactoryBean;

/**
 * Created by ej on 8/20/14.
 */
@Configuration
public class SecuritySpringConfig {

    public @Bean SecurityContextUtil securityContextUtil() {
        return new SecurityContextUtil();
    }

    public @Bean SecureRandomFactoryBean secureRandomFactoryBean() {
        return new SecureRandomFactoryBean();
    }

    public @Bean SecurityUtil securityUtil() {
        return new SecurityUtil();
    }
}
