package com.rencc.study.design.proxy.cglib;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class AliSmsServiceProxy<T> implements MethodInterceptor {

    private T target;

    /**
     * @param o           被代理的对象（需要增强的对象）
     * @param method      被拦截的方法（需要增强的方法）
     * @param args        方法入参
     * @param methodProxy 用于调用原始方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //调用方法之前，我们可以添加自己的操作
        log.info("before method " + method.getName());
        Object object = methodProxy.invoke(target, args);
        //调用方法之后，我们同样可以添加自己的操作
        log.info("after method " + method.getName());
        return object;
    }


    public T getProxy() {
        return (T) Enhancer.create(target.getClass(), this);
    }

}