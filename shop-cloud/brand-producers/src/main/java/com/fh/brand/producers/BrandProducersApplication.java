package com.fh.brand.producers;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.fh.brand.producers.mapper")
@EnableEurekaClient
public class BrandProducersApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrandProducersApplication.class, args);
    }
}
