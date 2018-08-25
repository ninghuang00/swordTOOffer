package cn.hn.pinduoduo;

import sun.tools.java.ClassType;

import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huangning on 2018/7/20.
 */
public class Demo extends Fa implements Action {

    private int count;

    public String name;

    @Override
    public void sing() {
        System.out.println("sing song");
    }

    @Override
    public void say() {
        System.out.println(
                "say a word"
        );
    }

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    public void c() {

    }


    public static void main(String[] args) {
        Integer[] arr = {2, 7, 4, 6, 1, 2, 3, 4, 9, 8};

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(Arrays.asList(arr));

        for (int i = 0 ; i < 5; i++) {
            maxHeap.poll();
            printQueue(maxHeap);
        }


    }

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void printQueue(Queue queue) {
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}


class MyThread extends Thread {
    public static int count = 0;

    @Override
    public void run() {
        System.out.println("hi");

        while (!isInterrupted()) {
            for (int i = 0; i < 100000; i++) {
                count++;
            }

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            interrupt();
            for (int i = 0; i < 100000; i++) {
                count++;
            }
        }
    }
}
