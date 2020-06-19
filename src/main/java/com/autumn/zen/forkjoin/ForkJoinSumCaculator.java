package com.autumn.zen.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author wuliang
 * @create 2019-05-25
 */
public class ForkJoinSumCaculator extends RecursiveTask<Long> {

    private final long[] nums;
    private final int start;
    private final int end;


    public static final int THRESHOLD = 10000;

    public ForkJoinSumCaculator(long[] nums, int start, int end) {
        this.nums = nums;
        this.start = start;
        this.end = end;
    }


    public ForkJoinSumCaculator(long[] nums) {
        this(nums, 0, nums.length - 1);
    }


    protected Long compute() {

        int length = end - start;
        if (length <= THRESHOLD) {
            return sumSub();
        }

        ForkJoinSumCaculator left = new ForkJoinSumCaculator(nums, start, start + length / 2);
        left.fork();
        ForkJoinSumCaculator right = new ForkJoinSumCaculator(nums, start + length / 2, end);
        return right.compute() + left.join();
    }

    private long sumSub() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {

        ForkJoinSumCaculator sum = new ForkJoinSumCaculator(LongStream.range(0, 10000000).toArray());

        System.out.println("sum = " + new ForkJoinPool().invoke(sum));


    }
}
