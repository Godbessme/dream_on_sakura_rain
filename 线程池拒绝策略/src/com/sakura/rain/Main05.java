package com.sakura.rain;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Main04
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/21 21:17
 */
public class Main05 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 2, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(2), new ThreadPoolExecutor.DiscardOldestPolicy());


        for (int index = 0; index < 15; index++) {
            int finalIndex = index;
            threadPool.submit(() -> {
                Thread.currentThread().setName("线程编码为： " + finalIndex);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        threadPool.shutdown();

        /*

        拒绝策略： DiscardOldestPolicy()
        超出能力范围内的加入失败不抛出异常，但是后续线程池中不会执行这些方法
        重写方法中的处理逻辑为:
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            if (!e.isShutdown()) {
                e.getQueue().poll();
                e.execute(r);
            }
        }
        * */

    }
}
