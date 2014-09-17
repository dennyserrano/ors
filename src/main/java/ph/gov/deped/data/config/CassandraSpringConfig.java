package ph.gov.deped.data.config;

import static java.util.Arrays.asList;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.config.CompressionType;
import org.springframework.cassandra.config.SocketOptionsFactoryBean;
import org.springframework.cassandra.core.keyspace.CreateKeyspaceSpecification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.convert.CassandraConverter;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;

import ph.gov.deped.config.CassandraSettings;

import com.datastax.driver.core.policies.ExponentialReconnectionPolicy;
import com.datastax.driver.core.policies.FallthroughRetryPolicy;

/**
 * Created by ej on 8/27/14.
 */
@Configuration
public class CassandraSpringConfig {

    private @Autowired CassandraSettings cassandraSettings;

    public @Bean CassandraClusterFactoryBean cluster() throws Exception {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(cassandraSettings.getContactPoints());
        cluster.setPort(cassandraSettings.getPort());
        cluster.setReconnectionPolicy(new ExponentialReconnectionPolicy(1000, 100000));
        cluster.setRetryPolicy(FallthroughRetryPolicy.INSTANCE);
        cluster.setMetricsEnabled(true);
        cluster.setCompressionType(CompressionType.SNAPPY);
        SocketOptionsFactoryBean socketOptions = new SocketOptionsFactoryBean();
        socketOptions.setConnectTimeoutMillis(60000);
        socketOptions.setReadTimeoutMillis(30000);
        socketOptions.setKeepAlive(Boolean.TRUE);
        socketOptions.setTcpNoDelay(Boolean.TRUE);
        cluster.setSocketOptions(socketOptions.getObject());
        cluster.setKeyspaceCreations(new ArrayList<>(asList(
                CreateKeyspaceSpecification.createKeyspace().name(cassandraSettings.getKeyspace()).ifNotExists()
        )));
        return cluster;
    }

    public @Bean CassandraMappingContext mappingContext() {
        return new BasicCassandraMappingContext();
    }

    public @Bean CassandraConverter converter() {
        return new MappingCassandraConverter(mappingContext());
    }

    public @Bean CassandraSessionFactoryBean session() throws Exception {
        CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
        session.setCluster(cluster().getObject());
        session.setKeyspaceName(cassandraSettings.getKeyspace());
        session.setConverter(converter());
        session.setSchemaAction(SchemaAction.CREATE);
        return session;
    }

    public @Bean CassandraOperations cassandraTemplate() throws Exception {
        return new CassandraTemplate(session().getObject());
    }

    public @Bean CassandraAdminTemplate cassandraAdminTemplate() throws Exception {
        return new CassandraAdminTemplate(session().getObject(), converter());
    }
}
