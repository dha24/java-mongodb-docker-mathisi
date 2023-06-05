package com.automorfosi.mathisi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;


/**
 * Spring Boot tries to automatically configure a MongoDB connection if it detects the presence of the MongoDB driver on the classpath
 *  To disable the automatic MongoDB configuration in your Spring Boot application, you can use the @EnableAutoConfiguration annotation with the exclude attribute
 */

@SpringBootApplication
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class MathisiApplication {
	public static void main(String[] args) {
		SpringApplication.run(MathisiApplication.class, args);
	}

}
