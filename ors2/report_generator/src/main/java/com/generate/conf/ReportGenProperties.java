package com.generate.conf;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "generator")
public class ReportGenProperties {

	private int chunkSize;
	private String tmpDir;
	private String donePath;
	
	public ReportGenProperties() {
		System.out.println();
	}
	
	public int getChunkSize() {
		return chunkSize;
	}
	public String getTmpDir() {
		return tmpDir;
	}

	public String getDonePath() {
		return donePath;
	}

	public void setDonePath(String donePath) {
		this.donePath = donePath;
	}

	public void setChunkSize(int chunkSize) {
		this.chunkSize = chunkSize;
	}

	public void setTmpDir(String tmpDir) {
		this.tmpDir = tmpDir;
	}
	
	
	
	
}
