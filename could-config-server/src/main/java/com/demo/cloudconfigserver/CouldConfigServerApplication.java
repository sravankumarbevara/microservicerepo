package com.demo.cloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class CouldConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouldConfigServerApplication.class, args);
	}

}
