package ph.gov.deped.repo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ph.gov.deped.repo.config.ebeis.EBEISRepositorySpringConfig;
import ph.gov.deped.repo.config.lis.LISRepositorySpringConfig;
import ph.gov.deped.repo.config.ors.ApplicationRepositorySpringConfig;

/**
 * User: elbertlayco
 * Date: 2013/16/10
 * Time: 19:06
 */
@Configuration
@Import({
        CommonRepositorySpringConfig.class,
//        LISRepositorySpringConfig.class,
//        EBEISRepositorySpringConfig.class,
        ApplicationRepositorySpringConfig.class
})
public class RepositorySpringConfig {

}
