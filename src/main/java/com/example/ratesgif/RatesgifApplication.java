package com.example.ratesgif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RatesgifApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatesgifApplication.class, args);
    }

}
