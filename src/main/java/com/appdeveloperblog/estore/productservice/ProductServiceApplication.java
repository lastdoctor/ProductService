package com.appdeveloperblog.estore.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductServiceApplication {
    public static void main(String[] args) {
        System.out.println("hello");
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}
