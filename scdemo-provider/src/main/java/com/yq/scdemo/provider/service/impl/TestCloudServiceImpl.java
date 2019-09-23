package com.yq.scdemo.provider.service.impl;

import com.yq.scdemo.api.service.ITestCloudService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yang qi
 * @create: 2019-09-16 16:35
 * @description:
 **/
@RestController
@RequestMapping("/api/v1/test")
public class TestCloudServiceImpl implements ITestCloudService {

    @Value("${server.port}")
    private String serverPort;

    @Value("${eureka.instance.appname}")
    private String eurekaInstanceAppName;

    @Override
    public Map<String, Object> testFnFeign() {
        Map<String, Object> map = new HashMap<>();
        map.put("serverPort", serverPort);
        map.put("eurekaInstanceAppName", eurekaInstanceAppName);
        map.put("me", "provider");
        return map;
    }
}
