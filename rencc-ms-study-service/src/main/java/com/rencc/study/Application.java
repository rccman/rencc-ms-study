package com.rencc.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description: 项目启动入口
 * @Author: renchaochao
 * @Date: 2020/12/18 15:42
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.rencc"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}