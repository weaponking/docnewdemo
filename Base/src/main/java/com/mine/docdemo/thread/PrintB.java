package com.mine.docdemo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weapon
 * @date 2020/5/6 18:36
 */
public class PrintB {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private final int limit;
    private volatile int index;

    public PrintB(int limit, int index) {
        this.limit = limit;
        this.index = index;
    }

    public void print() {
        lock.lock();
        while (index<limit) {
            System.out.println(String.format("thread : %s index : %s", Thread.currentThread().getName(), ++index));
            condition.signalAll();
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        PrintB printB = new PrintB(10, 0);
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                printB.print();
            }
        }, "thread1");
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                printB.print();
            }
        }, "thread2");
        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                printB.print();
            }
        }, "thread3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
