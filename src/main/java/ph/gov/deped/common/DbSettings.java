package ph.gov.deped.common;

import com.mysql.jdbc.Driver;

import java.io.Serializable;

/**
 * Created by ej on 8/27/14.
 */
public interface DbSettings extends Serializable {

    public static final String JDBC_PREFIX = "jdbc:";

    default String getDbDriver() {
        return Driver.class.getName();
    }

    default String getProtocol() {
        return "mysql";
    }

    default String getJdbcUrl() {
        return new StringBuilder(JDBC_PREFIX)
                .append(getProtocol()).append("://")
                .append(getDbHost()).append(getDbPort()).append("/")
                .append(getDbName()).toString();
    }

    String getDbHost();

    int getDbPort();

    String getDbName();

    String getDbUser();

    String getDbPass();
}
