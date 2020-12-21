package com.rencc.study.design.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Description: 获取代理对象的工厂类
 * @Author: renchaochao
 * @Date: 2020/12/21 12:05
 **/
public class JdkProxyFactory {


    public static Object getProxy(Object target, InvocationHandler handler) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                handler   // 代理对象对应的自定义 InvocationHandler
        );
    }
}
