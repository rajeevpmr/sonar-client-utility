package com.rr.sonar.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SonarClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SonarClientApplication.class, args);
	}
}
