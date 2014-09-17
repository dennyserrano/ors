package ph.gov.deped.data.config;

import bitronix.tm.resource.jdbc.PoolingDataSource;
import bitronix.tm.resource.jdbc.proxy.JdbcProxyFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.XAConnection;
import javax.sql.XADataSource;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * User: EJ
 * Date: 2014/27/05
 * Time: 14:23
 */
@Configuration
public class BitronixPoolingDataSourceSpringConfig {

    public static final String DEFAULT_TEST_SQL = "SELECT 1";

    public @Bean @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) PoolingXADataSource poolingXaDataSource() {
        PoolingXADataSource ds = new PoolingXADataSource();
        ds.setMinPoolSize(20);
        ds.setMaxPoolSize(100);
        ds.setMaxIdleTime(60);
        ds.setMaxLifeTime(90);
        ds.setAllowLocalTransactions(true);
        ds.setEnableJdbc4ConnectionTest(true);
        ds.setTestQuery(DEFAULT_TEST_SQL);
        ds.setDeferConnectionRelease(true);
        ds.setUseTmJoin(true);
        ds.setApplyTransactionTimeout(true);
        ds.setAutomaticEnlistingEnabled(true);
        ds.setShareTransactionConnections(true);

        return ds;
    }

    public static class PoolingXADataSource extends PoolingDataSource implements XADataSource {

        /**
         * 
         */
        private static final long serialVersionUID = -7650412080253758632L;

        public XAConnection getXAConnection() throws SQLException {
            return JdbcProxyFactory.INSTANCE.getProxyXaConnection(super.getConnection());
        }

        public XAConnection getXAConnection(String user, String password) throws SQLException {
            return JdbcProxyFactory.INSTANCE.getProxyXaConnection(super.getConnection(user, password));
        }

        public Logger getParentLogger() throws SQLFeatureNotSupportedException {
            throw new SQLFeatureNotSupportedException("Unknown Parent Logger.");
        }
    }
}
