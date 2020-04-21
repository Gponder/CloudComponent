package com.ponder.sessiondata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SessionDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SessionDataApplication.class, args);
    }

}
