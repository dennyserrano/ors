package ph.gov.deped.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.common.EbeisMetadata;
import ph.gov.deped.common.LisMetadata;
import ph.gov.deped.repo.config.HibernateExtendedJpaDialect;

import javax.persistence.EntityManagerFactory;

/**
 * Created by ej on 8/20/14.
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class JpaTransactionManagerSpringConfig {

    private @Autowired HibernateExtendedJpaDialect jpaDialect;

    private @Autowired EntityManagerFactory entityManagerFactory;

    private @Autowired @Qualifier(EbeisMetadata.EMF) EntityManagerFactory ebeisEntityManagerFactory;

    private @Autowired @Qualifier(LisMetadata.EMF) EntityManagerFactory lisEntityManagerFactory;

    @Bean
    @Qualifier(EbeisMetadata.TXM)
    public JpaTransactionManager ebeisTransactionManager() {
        JpaTransactionManager txm = new JpaTransactionManager(ebeisEntityManagerFactory);
        txm.setJpaDialect(jpaDialect);
        return txm;
    }

    @Bean
    @Qualifier(LisMetadata.TXM)
    public JpaTransactionManager lisTransactionManager() {
        JpaTransactionManager txm = new JpaTransactionManager(lisEntityManagerFactory);
        txm.setJpaDialect(jpaDialect);
        return txm;
    }

    @Primary @Qualifier(AppMetadata.TXM) @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager txm = new JpaTransactionManager(entityManagerFactory);
        txm.setRollbackOnCommitFailure(true);
        txm.setJpaDialect(jpaDialect);
        return txm;
    }
}
