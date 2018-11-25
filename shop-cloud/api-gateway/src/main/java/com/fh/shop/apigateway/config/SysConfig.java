package com.fh.shop.apigateway.config;

import com.fh.shop.apigateway.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SysConfig {

    @Bean
    public TokenFilter tokenFilter(){
        return  new TokenFilter();
    }
}
