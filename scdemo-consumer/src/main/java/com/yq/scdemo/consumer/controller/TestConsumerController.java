package com.yq.scdemo.consumer.controller;

import com.yq.scdemo.api.service.ITestCloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

import java.util.Map;

/**
 * @author: yang qi
 * @create: 2019-09-11 17:30
 * @description:
 **/
@RestController
public class TestConsumerController {

    @Autowired
    private RestOperations restTemplate;

    @Autowired
    private ITestCloudService testCloudService;

    @GetMapping("/rest")
    public Map testFnRest() {
        Map map = restTemplate.getForObject("http://spring-cloud-provider/api/v1/test/t", Map.class);
        map.put("me", "consumer");
        return map;
    }

    @GetMapping("/feign")
    public Map testFnFeign() {
        Map<String, Object> map = testCloudService.testFnFeign();
        map.put("me", "consumer");
        return map;
    }

    @GetMapping("/hy")
    public Map testHystrix() {
        Map<String, Object> map = testCloudService.testHystrix();
        return map;
    }

}
