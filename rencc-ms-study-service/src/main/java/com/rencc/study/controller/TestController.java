package com.rencc.study.controller;

import com.rencc.common.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试控制器
 * @Author: renchaochao
 * @Date: 2020/12/18 16:05
 **/
@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("/test")
    public Response<String> test() {
        return new Response<String>().success("测试接口返回");
    }
}
