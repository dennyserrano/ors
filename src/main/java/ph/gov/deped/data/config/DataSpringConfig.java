package ph.gov.deped.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ph.gov.deped.data.source.ApplicationDataSourceSpringConfig;
import ph.gov.deped.data.source.EBEISDataSourceSpringConfig;
import ph.gov.deped.data.source.LISDataSourceSpringConfig;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: elbertlayco
 * Date: 2013/16/10
 * Time: 15:11
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@Import({
        ApplicationDataSourceSpringConfig.class,
        EBEISDataSourceSpringConfig.class,
        LISDataSourceSpringConfig.class
})
public class DataSpringConfig {

    private static final String DEFAULT_LANGUAGE = "en";

    public @Bean Locale defaultLocale() {
        return new Locale(DEFAULT_LANGUAGE);
    }
}
