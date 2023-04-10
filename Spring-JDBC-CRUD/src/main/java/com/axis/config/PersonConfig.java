package com.axis.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.axis")
@PropertySource("classpath:database.properties")
public class PersonConfig {

		@Autowired
		
		Environment environment;
		
		private final String URL ="url";
		private final String USER ="dbUser";
		private final String DRIVER ="driver";
		private final String PASSWORD ="dbPassword";
		
		
		
		@Bean
		public DataSource dataSource() {
			
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(environment.getProperty(DRIVER));
			dataSource.setUrl(environment.getProperty(URL));
			dataSource.setUsername(environment.getProperty(USER));
			dataSource.setPassword(environment.getProperty(PASSWORD));
			
			return dataSource;
		}
		
}
