package ph.gov.deped.service.config;

import org.hibernate.engine.transaction.jta.platform.internal.AbstractJtaPlatform;
import org.hibernate.engine.transaction.jta.platform.spi.JtaPlatform;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

/**
 * Created by ej on 8/20/14.
 */
@AutoConfigureBefore({LocalContainerEntityManagerFactoryBean.class})
public class HibernateJtaPlatform extends AbstractJtaPlatform implements JtaPlatform {

    /**
     * 
     */
    private static final long serialVersionUID = 6804581296263385165L;

    private static TransactionManager transactionManager;

    private static UserTransaction userTransaction;

    public HibernateJtaPlatform() {}

    public HibernateJtaPlatform(TransactionManager transactionManager, UserTransaction userTransaction) {
        HibernateJtaPlatform.transactionManager = transactionManager;
        HibernateJtaPlatform.userTransaction = userTransaction;
    }

    protected TransactionManager locateTransactionManager() {
        return transactionManager;
    }

    protected UserTransaction locateUserTransaction() {
        return userTransaction;
    }
}
