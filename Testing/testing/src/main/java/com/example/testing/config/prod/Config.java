package com.example.testing.config.prod;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.testing.dao.ILibroDao;
import com.example.testing.dao.LibroDao;

@Configuration
public class Config {
	@Bean
	public ILibroDao libroDao() {
		return new LibroDao();
	}
}
