package com.lxy.multithread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class PrintTaskTest {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        PrintTask task = new PrintTask(0, 500);
        pool.submit(task);
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }
}
