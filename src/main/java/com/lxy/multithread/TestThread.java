package com.lxy.multithread;

import org.junit.Test;

public class TestThread {

    @Test
    public void test() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++){
                System.out.println("t1 thread "+ i);
            }
        });


        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);

            if(i == 5){
                t1.start();
                //如果没有join的话，那么就是main执行完再执行。如果join的话，就是join的先执行，接着再执行main
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
