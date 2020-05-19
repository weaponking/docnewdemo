package com.mine.docdemo.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author weapon
 * @date 2020/5/6 18:13
 */
public class PrintA {

    private final Object object = new Object();
    private final int limit;
    private volatile int index;

    public PrintA(int limit, int index) {
        this.limit = limit;
        this.index = index;
    }

    public void print() {
        synchronized (object) {
            while (index<limit) {
                System.out.println(String.format("thread : %s index : %s", Thread.currentThread().getName(), ++index));
                object.notifyAll();
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintA printA = new PrintA(10, 0);
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                 printA.print();
            }
        }, "thread1");
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                printA.print();
            }
        }, "thread2");
        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                printA.print();
            }
        }, "thread3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
