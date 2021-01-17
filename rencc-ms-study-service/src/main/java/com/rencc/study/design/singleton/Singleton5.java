package com.rencc.study.design.singleton;

/**
 * @Description: 懒汉式 优化Synchronized
 * @Author: renchaochao
 * @Date: 2021/1/17 20:13
 **/
public class Singleton5 {
    private static Singleton5 singleton5 = null;

    private Singleton5(){

    }

    private static Singleton5 getInstance(){
        if(singleton5 == null){
            synchronized (Singleton5.class){
                if(singleton5 == null){
                    return new Singleton5();
                }
            }
        }
        return singleton5;
    }
}
