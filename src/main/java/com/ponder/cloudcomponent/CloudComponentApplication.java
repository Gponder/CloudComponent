package com.ponder.cloudcomponent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
@MapperScan("com.ponder.cloudcomponent.dao")
public class CloudComponentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudComponentApplication.class, args);
    }

}
