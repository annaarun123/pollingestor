package com.ca.prism.pollingestor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
public class PollingestorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollingestorApplication.class, args);
	}
}
