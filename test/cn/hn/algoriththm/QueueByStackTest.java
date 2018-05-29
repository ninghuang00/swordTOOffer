package cn.hn.algoriththm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by huangning on 2018/5/28.
 */
public class QueueByStackTest {
    private QueueByStack queueByStack = new QueueByStack();

    @Test

    public void poll() throws Exception {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i : arr) {
            queueByStack.add(i);
        }

        while (queueByStack.size() > 0) {
            System.out.println(queueByStack.poll());

        }
    }

}