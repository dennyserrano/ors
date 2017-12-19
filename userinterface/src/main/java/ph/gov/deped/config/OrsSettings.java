package ph.gov.deped.config;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.common.DbSettings;

/**
 * Created by ej on 8/18/14.
 */
@ConfigurationProperties(prefix = AppMetadata.ors)
@PropertySource({"classpath:" + AppMetadata.PROPS})
public class OrsSettings implements DbSettings, Serializable {

    private static final long serialVersionUID = 8275166402731880290L;

    private String workingDir;

    private String dbHost;

    private int dbPort;

    private String dbUrl;

    private String dbName;

    private String dbUser;

    private String dbPass;

    private String emfPackages;

    private String repoPackages;

    private String persistenceUnitName;

    private boolean inApplicationServer;

    private String internalUsername;
    
    private String tmpDir;

    private int chunkSize;
    
    private String downloadBaseUrl;
    
    
    
    
    public String getDownloadBaseUrl() {
		return downloadBaseUrl;
	}

	public void setDownloadBaseUrl(String downloadBaseUrl) {
		this.downloadBaseUrl = downloadBaseUrl;
	}

	public int getChunkSize() {
		return chunkSize;
	}

	public void setChunkSize(int chunkSize) {
		this.chunkSize = chunkSize;
	}

	public String getWorkingDir() {
        return workingDir;
    }

    public String getDbHost() {
        return dbHost;
    }

    public int getDbPort() {
        return dbPort;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPass() {
        return dbPass;
    }

    public String getEmfPackages() {
        return emfPackages;
    }

    public String getRepoPackages() {
        return repoPackages;
    }

    public String getPersistenceUnitName() {
        return persistenceUnitName;
    }

    public boolean isInApplicationServer() {
        return inApplicationServer;
    }

    public String getInternalUsername() {
        return internalUsername;
    }

    public String getTmpDir() {
        return tmpDir;
    }

    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }

    public void setDbHost(String dbHost) {
    	System.out.println(dbHost);
        this.dbHost = dbHost;
    }

    public void setDbPort(int dbPort) {
        this.dbPort = dbPort;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public void setDbPass(String dbPass) {
        this.dbPass = dbPass;
    }

    public void setEmfPackages(String emfPackages) {
        this.emfPackages = emfPackages;
    }

    public void setRepoPackages(String repoPackages) {
        this.repoPackages = repoPackages;
    }

    public void setPersistenceUnitName(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }

    public void setInApplicationServer(boolean inApplicationServer) {
        this.inApplicationServer = inApplicationServer;
    }

    public void setInternalUsername(String internalUsername) {
        this.internalUsername = internalUsername;
    }

    public void setTmpDir(String tmpDir) {
        this.tmpDir = tmpDir;
    }
}
