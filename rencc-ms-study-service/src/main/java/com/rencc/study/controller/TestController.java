package com.rencc.study.controller;

import com.rencc.common.cache.redis.RedisService;
import com.rencc.common.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试控制器
 * @Author: renchaochao
 * @Date: 2020/12/18 16:05
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/")
    public Response<String> test() {
        return new Response<String>().success("测试接口返回");
    }

    /**
     * 测试Redis 写入
     * @param key redis key
     * @param value redis value
     * @return
     * @author renchaochao
     * @date 2020/12/30 16:56
     */
    @GetMapping("/redisSet")
    public Response<String> redisSet(@RequestParam("key") String key,@RequestParam("value") String value) {
        redisService.set(key,value);
        return new Response<String>().success("测试接口返回");
    }

    /**
     * 测试Redis 获取
     * @param key redis key
     * @return
     * @author renchaochao
     * @date 2020/12/30 16:57
     */
    @GetMapping("/redisGet")
    public Response<String> redisGet(@RequestParam("key") String key) {
        Object value = redisService.get(key);
        return new Response<String>().success(String.valueOf(value));
    }
}
