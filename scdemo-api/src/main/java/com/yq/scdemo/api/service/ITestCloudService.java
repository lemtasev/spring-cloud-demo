package com.yq.scdemo.api.service;

import com.yq.scdemo.api.fallback.TestCloudServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @author: yang qi
 * @create: 2019-09-16 16:30
 * @description:
 **/
@FeignClient(name = "spring-cloud-provider", path = "/api/v1/test", fallback = TestCloudServiceFallback.class)
public interface ITestCloudService {

    @GetMapping("/t")
    Map<String, Object> testFnFeign();

    @GetMapping("/t_hystrix")
    Map<String, Object> testHystrix();

}
