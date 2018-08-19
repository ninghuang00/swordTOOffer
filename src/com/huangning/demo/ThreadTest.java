package com.huangning.demo;

/**
 * Created by huangning on 2018/7/22.
 */
public class ThreadTest extends Thread {
    private byte[] lock;

    ThreadTest(byte[] lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < 100; i++) {
                if (i % 10 == 0 && i != 0) {
                    try {
                        lock.wait();
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}
