package com.lxy.multithread;

import java.util.concurrent.RecursiveAction;

public class PrintTask extends RecursiveAction{

    //每次子任务最多打印50个数字
    private static final int THRESHOLD = 50;
    private int start;
    private int end;

    public PrintTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if(end - start < THRESHOLD){
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + "的i值：" +i);
            }
        }else{
            int middle = (start + end) / 2;
            PrintTask left = new PrintTask(start, middle);
            PrintTask right = new PrintTask(middle, end);

            left.fork();
            right.fork();
        }
    }
}
