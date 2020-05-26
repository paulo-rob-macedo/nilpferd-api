package com.denkenvoncode.nilpferdapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.denkenvoncode.nilpferdapi.services.DBService;

@Configuration
@Profile("staging")
public class StagingConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean DBInitialize() {
		dbService.StagingInitialize();
		return true;
	}

}
