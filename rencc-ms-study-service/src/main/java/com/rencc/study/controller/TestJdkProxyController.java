package com.rencc.study.controller;

import com.rencc.common.response.Response;
import com.rencc.study.design.proxy.jdk.JdkProxyFactory;
import com.rencc.study.design.proxy.jdk.SmsServiceProxy;
import com.rencc.study.design.proxy.jdk.sercvice.SmsService;
import com.rencc.study.design.proxy.jdk.sercvice.impl.ASmsServiceImpl;
import com.rencc.study.design.proxy.jdk.sercvice.impl.BSmsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: renchaochao
 * @Date: 2020/12/21 14:12
 **/
@Slf4j
@RestController
@RequestMapping("/testProxy")
public class TestJdkProxyController {

    @Autowired
    private ASmsServiceImpl aSmsServiceImpl;
    @Autowired
    private BSmsServiceImpl bSmsServiceImpl;

    @GetMapping("test")
    public Response<String> test(@RequestParam(name = "message", defaultValue = "测试JDK动态代理") String message) {
        SmsServiceProxy<SmsService> proxy = new SmsServiceProxy<>(aSmsServiceImpl);
        SmsService smsService1 = proxy.getProxy();
        smsService1.send(message);
        SmsService smsService2 = (SmsService) JdkProxyFactory.getProxy(bSmsServiceImpl, new SmsServiceProxy<SmsService>(bSmsServiceImpl));
        smsService2.send(message);
        return new Response<String>().success(message);
    }
}
