package ph.gov.deped.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix="ejb")
@PropertySource({"classpath:ejb.properties"})
public class EJBProperties {

	private String queueServiceUrl;
	private String fileServiceUrl;
	public String getQueueServiceUrl() {
		return queueServiceUrl;
	}
	public void setQueueServiceUrl(String queueServiceUrl) {
		this.queueServiceUrl = queueServiceUrl;
	}
	public String getFileServiceUrl() {
		return fileServiceUrl;
	}
	public void setFileServiceUrl(String fileServiceUrl) {
		this.fileServiceUrl = fileServiceUrl;
	}
	
	
	
	
	
	
}
