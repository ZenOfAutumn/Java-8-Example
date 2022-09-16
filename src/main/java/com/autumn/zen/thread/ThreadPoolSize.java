package com.autumn.zen.thread;

import com.google.common.util.concurrent.RateLimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池大小评估
 *
 * @since 2022-09-06
 */
public class ThreadPoolSize {


    public static final int cost = 30;

    public static final int speed = 500;


    static final RateLimiter rateLimiter = RateLimiter.create(200, 0, TimeUnit.SECONDS); // rate is "2 permits per second"


    static void submitTasks(List<Runnable> tasks, ThreadPoolExecutor executor) {
        for (Runnable task : tasks) {
            rateLimiter.acquire(); // may wait
            try {
                executor.execute(task);
            } catch (Throwable e) {
                System.out.println("e = " + e);
            }
        }
    }


    public static class SubTask implements Runnable {

        private int id;

        public SubTask(int id) {
            this.id = id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                Thread.currentThread().sleep(16);
                System.out.println(Thread.currentThread().getName() + "-" + "task" + id);
            } catch (InterruptedException e) {

            }
        }
    }


    public static void size() throws Exception {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(400, 400, 3, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1000), new ThreadPoolExecutor.AbortPolicy());
        executor.setCorePoolSize(10);
        executor.prestartAllCoreThreads();

        List<Runnable> tasks = new ArrayList<>(20000);
        for (int i = 0; i < 10000; i++) {
            tasks.add(new SubTask(i));
        }
        submitTasks(tasks, executor);
        TimeUnit.MINUTES.sleep(1);

        System.out.println(executor);

    }

    public static void main(String[] args) throws Exception {
        size();

    }
}
