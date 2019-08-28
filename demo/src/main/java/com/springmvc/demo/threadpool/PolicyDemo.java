package com.springmvc.demo.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Kaixiang Tao
 * @date 2019/8/27
 */
public class PolicyDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5,
            1L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(5));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        boolean doLoop = true;
        int j = 0;
        while (j < 2) {
            for (int i = 0; i < 10; i++) {
                executor.execute(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName() + " is running");
                        Thread.sleep(500);
                    } catch (InterruptedException ignored) {
                    }
                });
            }
            j++;
            Thread.sleep(1000000L);
        }

        executor.shutdown();
    }
}
