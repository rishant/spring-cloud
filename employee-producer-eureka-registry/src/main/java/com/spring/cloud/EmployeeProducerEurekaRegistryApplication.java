package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeProducerEurekaRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeProducerEurekaRegistryApplication.class, args);
	}
}
