package com.ibm.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Orderservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Orderservice1Application.class, args);
	}

}
