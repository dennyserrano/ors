package ph.gov.deped.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * Created by ej on 8/27/14.
 */
@ConfigurationProperties(prefix = "cassandra", locations = {"classpath:cassandra.properties"})
public class CassandraSettings implements Serializable {

    private static final long serialVersionUID = 2384377650788575535L;

    private String contactPoints = "localhost";

    private int port = 9042;

    private String keyspace = "meta";

    public String getContactPoints() {
        return contactPoints;
    }

    public void setContactPoints(String contactPoints) {
        this.contactPoints = contactPoints;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getKeyspace() {
        return keyspace;
    }

    public void setKeyspace(String keyspace) {
        this.keyspace = keyspace;
    }
}
