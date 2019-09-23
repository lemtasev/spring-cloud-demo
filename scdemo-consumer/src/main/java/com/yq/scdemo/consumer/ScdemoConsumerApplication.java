package com.yq.scdemo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;

@SpringBootApplication
// @EnableDiscoveryClient // 可省略
@EnableFeignClients(basePackages = "com.yq.scdemo.api.*")
public class ScdemoConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScdemoConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced // 开启负载均衡
    public RestOperations restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
