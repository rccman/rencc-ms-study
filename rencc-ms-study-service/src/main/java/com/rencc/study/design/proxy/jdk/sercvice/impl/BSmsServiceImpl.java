package com.rencc.study.design.proxy.jdk.sercvice.impl;

import com.rencc.study.design.proxy.jdk.sercvice.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: renchaochao
 * @Date: 2020/12/21 11:59
 **/
@Slf4j
@Service
public class BSmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        log.info("B send message:" + message);
        return message;
    }
}
