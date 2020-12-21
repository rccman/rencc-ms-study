package com.rencc.study.design.proxy.jdk;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: renchaochao
 * @Date: 2020/12/21 12:03
 **/
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class SmsServiceProxy<T> implements InvocationHandler {

    private T target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用方法之前，我们可以添加自己的操作
        log.info("before method " + method.getName());
        Object result = method.invoke(target, args);
        //调用方法之后，我们同样可以添加自己的操作
        log.info("after method " + method.getName());
        return result;
    }

    public T getProxy() {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                this   // 代理对象对应的自定义 InvocationHandler
        );
    }
}
