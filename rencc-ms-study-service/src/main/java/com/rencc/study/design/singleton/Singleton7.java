package com.rencc.study.design.singleton;

import java.util.HashMap;

/**
 * @Description: 容器
 * @Author: renchaochao
 * @Date: 2021/1/17 20:24
 **/
public class Singleton7 {

    private static HashMap<String, Object> ioc = new HashMap<>();

    private static Object getBean(String className) {
        if (!ioc.containsKey(className)) {
            synchronized (Singleton7.class) {
                if (!ioc.containsKey(className)) {
                    Object bean = null;
                    try {
                        bean = Class.forName(className).newInstance();
//                bean = ClassLoader.getSystemClassLoader().loadClass(className);
                        ioc.put(className, bean);
                        return bean;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return ioc.get(className);
    }
}
