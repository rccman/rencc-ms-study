package com.rencc.study.design.singleton;

import java.io.Serializable;

/**
 * @Description: 静态内部类
 * @Author: renchaochao
 * @Date: 2021/1/17 20:17
 **/
public class Singleton6 implements Serializable {

    private static Singleton6 getInstance(){
        return Singleton6Inner.singleton6;
    }

    private static class Singleton6Inner{
        private static final Singleton6 singleton6 = new Singleton6();
    }
}
