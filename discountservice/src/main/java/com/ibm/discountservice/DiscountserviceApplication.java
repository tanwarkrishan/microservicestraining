package com.ibm.discountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DiscountserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscountserviceApplication.class, args);
	}

}
