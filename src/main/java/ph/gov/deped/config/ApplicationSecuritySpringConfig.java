package ph.gov.deped.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SimpleRedirectInvalidSessionStrategy;

/**
 * @author ej
 * @since Nov 03, 2014 13:28
 */
public class ApplicationSecuritySpringConfig extends WebSecurityConfigurerAdapter {
    
    public @Bean InvalidSessionStrategy invalidSessionStrategy() {
        SimpleRedirectInvalidSessionStrategy invalidSessionStrategy = new SimpleRedirectInvalidSessionStrategy("/");
        invalidSessionStrategy.setCreateNewSession(false);
        return invalidSessionStrategy;
    }

    protected @Override void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement()
                    .sessionFixation().none()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .httpBasic()
                    .authenticationEntryPoint(entryPoint())
                    .and()
                .requestMatchers()
                    .antMatchers("/**")
                    .and()
                .authorizeRequests()
                    .anyRequest()
                    .hasAnyRole("USER");
    }

    private AuthenticationEntryPoint entryPoint() {
        BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
        entryPoint.setRealmName("Spring");
        return entryPoint;
    }
}
