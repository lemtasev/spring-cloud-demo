package com.yq.scdemo.api.fallback;

import com.yq.scdemo.api.service.ITestCloudService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yang qi
 * @create: 2019-09-26 11:40
 * @description:
 **/
@Component
public class TestCloudServiceFallback implements ITestCloudService {

    @Override
    public Map<String, Object> testFnFeign() {
        return defaultFallback();
    }

    @Override
    public Map<String, Object> testHystrix() {
        return defaultFallback();
    }

    private Map<String, Object> defaultFallback() {
        System.out.println("服务已熔断，可发送邮件通知开发人员及时排查BUG。");
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "服务暂时不可用，请稍后重试！");
        return map;
    }
}
