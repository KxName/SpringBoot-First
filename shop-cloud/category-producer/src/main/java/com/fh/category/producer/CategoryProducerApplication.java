package com.fh.category.producer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.fh.category.producer.mapper")
@EnableEurekaClient
public class CategoryProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CategoryProducerApplication.class, args);
    }
}
