package com.spring.cloud.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * Created by rgupta on 11/28/2017.
 */
public class EmployeeConsumerControllerClient {

    @Autowired
    private LoadBalancerClient loadBalancer;

    public void getEmployee() throws RestClientException, IOException {
        ServiceInstance serviceInstance = loadBalancer.choose("employee-producer-ribbon-eureka-registry");

        String baseUrl=serviceInstance.getUri().toString();
        baseUrl=baseUrl+"/employee";
        System.out.println("Api Path : " + baseUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response=null;
        try{
            response=restTemplate.exchange(baseUrl,
                    HttpMethod.GET, getHeaders(),String.class);
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
        System.out.println(response.getBody());
    }

    private static HttpEntity<?> getHeaders() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }
}
