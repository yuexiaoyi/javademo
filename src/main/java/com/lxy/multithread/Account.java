package com.lxy.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final Lock lock = new ReentrantLock();
    private String accountNo;
    private double balance;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public Account() {
    }

 /*   public synchronized void draw(double money) throws InterruptedException {
        if(money < balance){
            System.out.println("取钱成功！取的钱数为：" + money);
//            Thread.sleep(2000);
            balance = balance - money;
        }else{
            System.out.println("余额不足");
        }
    }*/

    public void draw(double money) throws InterruptedException {

        lock.lock();
        try {
            if(money < balance){
                System.out.println("取钱成功！取的钱数为：" + money);
    //            Thread.sleep(2000);
                balance = balance - money;
            }else{
                System.out.println("余额不足");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }

    }
}
