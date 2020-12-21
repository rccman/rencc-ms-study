package com.rencc.study.design.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: renchaochao
 * @Date: 2020/12/21 21:12
 **/
@Slf4j
@Service
public class AliSmsService {
    public String send(String message) {
        log.info("send message:" + message);
        return message;
    }
}
