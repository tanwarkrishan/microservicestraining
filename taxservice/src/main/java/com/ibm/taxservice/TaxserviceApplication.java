package com.ibm.taxservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TaxserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxserviceApplication.class, args);
	}

}
