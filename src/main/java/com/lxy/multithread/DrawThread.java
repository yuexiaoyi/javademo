package com.lxy.multithread;

import java.util.concurrent.*;

public class DrawThread implements Callable{
    private Account account;
    private double money;

    public DrawThread(Account account, double money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public Object call() throws Exception {
        /*synchronized (account){//代码块
            if(money < account.getBalance()){
                System.out.println("取钱成功！取的钱数为：" + money);
                Thread.sleep(2000);
                account.setBalance(account.getBalance() - money);
                return true;
            }else{
                System.out.println("余额不足");
            }
        }*/

        account.draw(money);
        return false;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //如果不需要获取返回值的话，不建议用callable。
        for (int i = 0; i < 10; i++) {
            Account a1 =  new Account("a1",1000);
            FutureTask<Boolean> task1 = new FutureTask<>(new DrawThread(a1,700));
            FutureTask<Boolean> task2 = new FutureTask<>(new DrawThread(a1,700));

         /*   FutureTask<Boolean> task1 = new FutureTask<>(new DrawThread(new Account("a1" ,1000),700));
            FutureTask<Boolean> task2 = new FutureTask<>(new DrawThread(new Account("a1" ,1000),700));*/

//            Thread t1 = new Thread(task1);
//            Thread t2 = new Thread(task2);
//
//            t1.start();
//            t2.start();

            ExecutorService executor = Executors.newFixedThreadPool(10);
            executor.submit(task1);
            executor.submit(task2);

            System.out.println(task1.get());
            System.out.println(task2.get());

            //需要手动关闭线程池和服务
            if(task1.isDone() && task2.isDone()){
                executor.shutdown();
            }

        }

    }
}
