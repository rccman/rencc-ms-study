package com.rencc.study.design.singleton;

/**
 * @Description: 懒汉式 线程不安全
 * @Author: renchaochao
 * @Date: 2021/1/17 20:09
 **/
public class Singleton3 {
    private static Singleton3 singleton = null;

    private Singleton3(){

    }

    public static Singleton3 getInstance(){
        if(singleton == null){
            return new Singleton3();
        }
        return singleton;
    }
}
