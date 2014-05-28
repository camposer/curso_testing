package com.example.testing.config.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.testing.dao.ILibroDao;
import com.example.testing.dao.LibroDummyDao;

@Configuration
public class Config {
	@Bean
	public ILibroDao libroDao() {
		return new LibroDummyDao();
	}
}
