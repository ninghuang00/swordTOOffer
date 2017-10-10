package com.huangning.demo;

import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by huangning on 2017/9/23.
 */
public class JQueueTest {

    @Test
    public void queueTest() throws Exception {
        JQueue queue = new JQueue();

        queue.appendTail(1);
        queue.appendTail(4);
        System.out.print(queue.deleteHead() + " ");
        queue.appendTail(5);
        System.out.print(queue.deleteHead() + " ");
        System.out.print(queue.deleteHead() + " ");
        System.out.print(queue.deleteHead() + " ");

    }

    @Test
    public void demo() throws Exception {
        System.out.print(addToN_recursive(5000));
    }


    public int addToN_recursive(int n){
        return n <= 0 ? 0 : n + addToN_recursive(n - 1);
    }

    public int addToN_iterative(int n){
        int sum = 0;
        for(int i = 1; i <= n ; i ++){
            sum += i;
        }
        return sum;
    }
}