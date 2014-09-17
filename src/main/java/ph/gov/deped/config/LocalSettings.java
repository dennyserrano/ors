package ph.gov.deped.config;

import java.io.Serializable;
import java.util.Locale;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by ej on 8/18/14.
 */
@ConfigurationProperties(prefix = "local", locations = {"classpath:" + LocalSettings.LOCAL_PROPERTIES})
public class LocalSettings implements Serializable {

    private static final long serialVersionUID = 1799863768452262293L;

    public static final String LOCAL_PROPERTIES = "local.properties";

    private String username;

    private Integer userId;

    private String tmpfs;
    
    private Locale locale;
    
    private String dateFormat;

    public String getUsername() {
        return username;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getTmpfs() {
        return tmpfs;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setTmpfs(String tmpfs) {
        this.tmpfs = tmpfs;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}
