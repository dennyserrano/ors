package com.util.builders.local;

import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import com.util.builders.config.Configuration;
import com.util.builders.config.DBProperties;

public class Application {
	
	
	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] {Configuration.class}, args).registerShutdownHook();
		
	}
}
