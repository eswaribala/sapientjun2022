package com.ps.psconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class PsconfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(PsconfigserverApplication.class, args);
	}

}
