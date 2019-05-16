package com.itcpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    @Autowired
    public OrderController(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping
    public String query() {
        final List<String> services = discoveryClient.getServices();
        for (String service:services) {
            List<ServiceInstance> list = discoveryClient.getInstances(service);
            for (ServiceInstance instance:list) {
                System.out.println(instance.getUri() + "/" + service + " - " + instance.getServiceId());
            }
        }
        return restTemplate.getForObject("http://PRODUCT-SERVER/products", String.class);
    }

}
