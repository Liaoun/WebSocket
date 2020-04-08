package com.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WebsocketeurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsocketeurekaApplication.class, args);
	}

}
