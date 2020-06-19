package com.autumn.zen.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * CompletionService
 *
 * @author wuliang
 * @version 2020-06-19
 */
public class CompletionServiceCase {


    public static final ExecutorService executors = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {

        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executors);

        int timeCost = 20;
        for (int i = 0; i < timeCost; i++) {
            final int x = i;
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(x * 2);
                    return x * 2;
                }
            });
        }

        long allStart = System.nanoTime();
        long timeRemain = TimeUnit.MILLISECONDS.toNanos(15);
        List<Integer> results = new ArrayList<>();

        while (timeRemain > 0) {
            long start = System.nanoTime();
            Future<Integer> future = completionService.poll(timeRemain, TimeUnit.MILLISECONDS);
            if (future == null) {
                break;
            }
            results.add(future.get());
            timeRemain -= System.nanoTime() - start;
            System.out.println("timeRemain = " + timeRemain);
        }
        System.out.println(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - allStart));
        System.out.println("results = " + results);
    }


}

