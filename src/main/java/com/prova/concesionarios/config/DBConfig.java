package com.prova.concesionarios.config;

import javax.activation.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DBConfig {
	/*
	@Bean("myDB")
	public DataSource dataSource() {
		System.out.println("h4444444olaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
        var builder = new EmbeddedDatabaseBuilder();
        var db = builder
                .setType(EmbeddedDatabaseType.H2) 
                .addScript("classpath:testdb/data.sql")
                .build();
        
        return (DataSource) db;
        
	}
	*/
}
