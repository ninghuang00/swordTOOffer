package cn.hn.algoriththm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by huangning on 2018/5/28.
 */
public class StackByQueueTest {
    private StackByQueue stackByQueue = new StackByQueue();
    @Test
    public void pop() throws Exception {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i : arr) {
            stackByQueue.push(i);
        }

        while (stackByQueue.size() > 0) {
            System.out.println(stackByQueue.pop());

        }
    }

    @Test
    public void push() throws Exception {
    }

}