package com.rencc.study.design.singleton;

/**
 * @Description: 懒汉式 线程安全
 * @Author: renchaochao
 * @Date: 2021/1/17 20:11
 **/
public class Singleton4 {
    private static Singleton4 singleton4 = null;

    private Singleton4(){

    }

    private synchronized static Singleton4 getInstance(){
        if(singleton4 == null){
            return new Singleton4();
        }
        return singleton4;
    }
}
