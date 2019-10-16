package com.trilogyed.uspsshipmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class UspsShipmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UspsShipmentServiceApplication.class, args);
	}

}
