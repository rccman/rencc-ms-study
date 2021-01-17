package com.rencc.study.design.singleton;

/**
 * @Description: 饿汉式1
 * @Author: renchaochao
 * @Date: 2021/1/17 20:06
 **/
public class Singleton1 {
    private static final Singleton1 singleton = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance(){
        return singleton;
    }
}
