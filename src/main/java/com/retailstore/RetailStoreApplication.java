package com.retailstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

/**
 * @author mohammadnaushad
 *
 */
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class RetailStoreApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RetailStoreApplication.class, args);
	}
}
