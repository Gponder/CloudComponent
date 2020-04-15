package com.ponder.cloudcomponent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ponder.cloudcomponent.dao")
public class CloudComponentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudComponentApplication.class, args);
    }

}
