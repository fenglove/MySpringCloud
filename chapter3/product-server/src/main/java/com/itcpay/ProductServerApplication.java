package com.itcpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServerApplication.class, args);
    }

    @Configuration
    class MyConfiguration {
        @LoadBalanced
        @Bean
        RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }

}
