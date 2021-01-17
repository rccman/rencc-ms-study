package com.rencc.study.design.singleton;

/**
 * @Description: 饿汉式2
 * @Author: renchaochao
 * @Date: 2021/1/17 20:08
 **/
public class Singleton2 {
    private static final Singleton2 singleton;
    static {
        singleton = new Singleton2();
    }

    private Singleton2(){

    }

    public static Singleton2 getInstance(){
        return singleton;
    }
}
