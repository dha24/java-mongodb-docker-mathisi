package com.automorfosi.mathisi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
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
@OpenAPIDefinition(info = @Info(title = "Mathisi : Authentication and Authorization Project",
		version = "1.0",
		description = "AN API to manage JWT token and Refresh token lifecycle"))
public class MathisiApplication {
	public static void main(String[] args) {
		SpringApplication.run(MathisiApplication.class, args);
	}


}
