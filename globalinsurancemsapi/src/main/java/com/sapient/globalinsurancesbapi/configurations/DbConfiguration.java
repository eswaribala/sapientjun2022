package com.sapient.globalinsurancesbapi.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
@Data
@Configuration
@EnableConfigurationProperties(VaultConfiguration.class)
@Slf4j
public class DbConfiguration {
    @Value("${db_url}")
	private String dbUrl;
    @Value("${db_driver}")
	private String driver;
	private final VaultConfiguration vaultConfiguration;
	private DataSourceBuilder dataSourceBuilder;

	public DbConfiguration(VaultConfiguration vaultConfiguration) {
		this.vaultConfiguration=vaultConfiguration;
	}
	//creating db connection
	@Bean
	public DataSource createDataSource() {
		dataSourceBuilder=DataSourceBuilder.create();
	
    	dataSourceBuilder.url(dbUrl);
    	log.info("UserName"+vaultConfiguration.getUsername());
    	log.info("Password"+vaultConfiguration.getPassword());
    	dataSourceBuilder.username(vaultConfiguration.getUsername());
    	dataSourceBuilder.password(vaultConfiguration.getPassword());
    	dataSourceBuilder.driverClassName(driver);
    	return dataSourceBuilder.build();
	}
}
