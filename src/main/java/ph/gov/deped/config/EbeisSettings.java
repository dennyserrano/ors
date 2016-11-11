package ph.gov.deped.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import ph.gov.deped.common.DbSettings;
import ph.gov.deped.common.EbeisMetadata;

import java.io.Serializable;

/**
 * Created by ej on 8/18/14.
 */
@ConfigurationProperties(prefix = EbeisMetadata.ebeis, locations = {"classpath:" + EbeisMetadata.EBEIS_PROPS})
public class EbeisSettings implements DbSettings, Serializable {

    private static final long serialVersionUID = 527707610160924819L;

    private String persistenceScanPackages;

    private String persistenceUnitName;

    private String dbHost;

    private int dbPort;

    private String dbName;

    private String dbUrl;

    private String dbUser;

    private String dbPass;

    public String getPersistenceScanPackages() {
        return persistenceScanPackages;
    }

    public String getPersistenceUnitName() {
        return persistenceUnitName;
    }

    public String getDbHost() {
        return dbHost;
    }

    public int getDbPort() {
        return dbPort;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPass() {
        return dbPass;
    }

    public void setPersistenceScanPackages(String persistenceScanPackages) {
        this.persistenceScanPackages = persistenceScanPackages;
    }

    public void setPersistenceUnitName(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }

    public void setDbHost(String dbHost) {
    	System.out.println("EBEIS:"+dbHost);
        this.dbHost = dbHost;
    }

    public void setDbPort(int dbPort) {
        this.dbPort = dbPort;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public void setDbPass(String dbPass) {
        this.dbPass = dbPass;
    }
}
