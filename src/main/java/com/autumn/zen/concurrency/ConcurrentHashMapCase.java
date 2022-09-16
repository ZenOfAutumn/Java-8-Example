package com.autumn.zen.concurrency;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Assert;
import org.junit.Test;

public class ConcurrentHashMapCase {

    private static final ConcurrentHashMap<String, Long> WORD_COUNT = new ConcurrentHashMap<String, Long>();

    private static final ConcurrentHashMap<String, String> WORD_CONCAT = new ConcurrentHashMap<String, String>();

    // 1.atomic update

    public static long add(String word) {
        return WORD_COUNT.compute(word, (k, v) -> v == null ? 1 : v + 1);
    }

    public static long get(String word) {
        return WORD_COUNT.get(word);
    }

    @Test
    public void testAtomicUpdate() {
        String quote = "to be or not to be that is the question";
        String[] words = quote.split(" ");
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            pool.submit(() -> {
                for (String word : words) {
                    add(word);
                }
            });
        }

        pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertEquals(2 * 100, get("to"));
        Assert.assertEquals(100, get("or"));
    }

    // 2.merge

    public static String merge(String word) {
        return WORD_CONCAT.merge(word, word, (oldStr, newStr) -> oldStr + newStr);
    }

    @Test
    public void testMerge() {
        merge("1");
        merge("1");
        Assert.assertEquals("11", WORD_CONCAT.get("1"));
    }

    // 3.search

    static String firstExceed(int limit) {
        return WORD_COUNT.search(limit, (k, v) -> v > limit ? k : null);
    }


    // 4.for each

    static void forEachProcess() {
        WORD_COUNT.forEach(4, (k, v) -> System.out.println(k + "->" + v));
        WORD_COUNT.forEach(4, (k, v) -> k + "->" + v, System.out::println);
    }


    // 5.reduce

    static Integer reduce() {
        return WORD_COUNT.reduceKeys(4, String::length, Integer::max);
    }


    // 6.set
    static Set<String> words = ConcurrentHashMap.<String>newKeySet();


    public void testCas() {

        Set<String> x = ConcurrentHashMap.newKeySet();

    }


}
