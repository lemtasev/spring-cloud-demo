package com.yq.scdemo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableDiscoveryClient // 可省略
public class ScdemoProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScdemoProviderApplication.class, args);
    }

}
