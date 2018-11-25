package com.fh.shop.producer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.fh.shop.producer.mapper")
@EnableEurekaClient
@EnableFeignClients("com.fh.brand")
public class ShopProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopProducerApplication.class, args);
    }
}
