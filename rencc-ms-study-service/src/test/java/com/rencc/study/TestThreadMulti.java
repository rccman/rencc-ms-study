package com.rencc.study;

import com.alibaba.fastjson.JSON;
import com.rencc.study.model.User;
import com.rencc.study.utils.ThreadPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Description: 测试多线程
 * @Author: renchaochao
 * @Date: 2021/1/2 15:51
 **/
@Slf4j
@SpringBootTest
public class TestThreadMulti {
    @Test
    void testRunnable() throws ExecutionException, InterruptedException {

        Future<?> submit = ThreadPoolUtil.threadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                //抛异常
//                int[] aa = new int[2];
//                System.out.println(aa[3]);
                return Thread.currentThread().getName();
            }
        });

        Object o = submit.get();
        System.out.println(o.toString());

        User user = new User();

        Future<User> userFuture = ThreadPoolUtil.threadPool.submit(new Runnable() {
            @Override
            public void run() {
                //不抛异常
//                int[] aa = new int[2];
//                System.out.println(aa[3]);ThreadLocalMap
                user.setName(String.valueOf(Thread.currentThread().getId()));
            }
        }, user);
        userFuture.get();
        System.out.println(user.getName());
        System.out.println(JSON.toJSONString(user));

    }
}
