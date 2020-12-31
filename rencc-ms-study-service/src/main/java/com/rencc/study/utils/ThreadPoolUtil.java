package com.rencc.study.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * 线程池工具类
 * @author renchaochao
 * @date 2020/12/31 15:49
 */
public class ThreadPoolUtil {

    public volatile static ExecutorService threadPool = null;


    static {
        if (threadPool == null) {
            ThreadFactory threadFactory = new ThreadFactoryBuilder()
                    .setNameFormat("rencc-ms-study-service" + "-%d")
                    .setDaemon(true).build();
            BlockingQueue<Runnable> blockingQueue = new LinkedBlockingDeque<>(70);
            threadPool = new ThreadPoolExecutor(5, 80, 60L, TimeUnit.SECONDS, blockingQueue, threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());
        }
    }
    
    
    
    
    private static int universalSyncPoolSize=50;
    private static int universalSyncQueueSize=100;

    public static final Logger logger = LoggerFactory.getLogger(ThreadPoolUtil.class);
    private volatile static ExecutorService universalSyncPool = null;//公用同步线程池
    public volatile static BlockingQueue<Runnable> universalSyncPoolQueue = null;//公用缓冲队列


    public static ExecutorService getUniversalSyncPoolInstance() {
        if (universalSyncPool == null) {
            synchronized (ThreadPoolUtil.class) {
                if (universalSyncPool == null) {
                    universalSyncPoolQueue = new ArrayBlockingQueue<>(universalSyncQueueSize);
                    universalSyncPool = new ThreadPoolExecutor(universalSyncPoolSize, universalSyncPoolSize, 30L, TimeUnit.MINUTES, universalSyncPoolQueue);
                    logger.info("msg1={},,线程池大小={},,缓冲队列大小={}", "实例化一个[公用同步线程池]", universalSyncPoolSize, universalSyncQueueSize);
                }
            }
        }
        return universalSyncPool;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            ThreadPoolUtil.threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep((long) Math.random());
//                        TimeUnit.SECONDS.sleep(finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    logger.info(Thread.currentThread().getName()+"--"+ finalI);
                }
            });
        }
    }

    

}
