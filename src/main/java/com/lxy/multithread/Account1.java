package com.lxy.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account1 {

    private final Lock lock = new ReentrantLock();
    private String accountNo;
    private double balance;
    //是否有人在存钱的标识
    boolean flag = false;

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

    public Account1(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public Account1() {
    }

   //取钱
    public synchronized  void draw(double money) {
        try {
            if (!flag) {
                wait();
            } else {
                //执行取钱操作
                System.out.println(Thread.currentThread().getName() + "取钱：" + money);
                balance = balance - money;
                System.out.println("账户余额:" + balance);

                flag = false;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //存钱
    public synchronized  void desposite(double money) {
        try {
            if (flag) {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName() + "存钱：" + money);
                balance = balance + money;
                System.out.println("账户余额:" + balance);
                flag = true;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
