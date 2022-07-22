package com.ps.pseurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PseurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(PseurekaserverApplication.class, args);
	}

}
