package com.itcpay.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ItcpayCloudDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItcpayCloudDiscoveryApplication.class, args);
    }

}
