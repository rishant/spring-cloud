package com.spring.cloud;

import com.spring.cloud.client.EmployeeConsumerControllerClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@SpringBootApplication
public class EmployeeConsumerRibbonEurekaRegistryApplication {

	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx = SpringApplication.run(
				EmployeeConsumerRibbonEurekaRegistryApplication.class, args);
		EmployeeConsumerControllerClient consumerControllerClient=ctx.getBean(EmployeeConsumerControllerClient.class);
		System.out.println(consumerControllerClient);
		consumerControllerClient.getEmployee();

	}

	@Bean
	public  EmployeeConsumerControllerClient  consumerControllerClient()
	{
		return  new EmployeeConsumerControllerClient();
	}
}
