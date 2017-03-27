package ph.gov.deped.repo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ph.gov.deped.repo.config.ebeis.EBEISEntityManagerSpringConfig;
import ph.gov.deped.repo.config.lis.LISEntityManagerSpringConfig;
import ph.gov.deped.repo.config.ors.ApplicationEntityManagerSpringConfig;

/**
 * Created by ej on 8/15/14.
 */
@Configuration
@Import({
//        EBEISEntityManagerSpringConfig.class,
//        LISEntityManagerSpringConfig.class,
        ApplicationEntityManagerSpringConfig.class
})
public class EntityManagerSpringConfig {
}
