package cn.hn.algoriththm;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by huangning on 2018/5/28.
 */
public class StackByQueue {
    private Queue<Integer> data = new ArrayDeque<>();
    private Queue<Integer> helper = new ArrayDeque<>();
    public Integer pop() {
        if (data.size() == 0) {
            return null;
        } else {
            while (data.size() > 1) {
                helper.add(data.poll());
            }
            int ret = data.poll();
            Queue<Integer> temp = data;
            data = helper;
            helper = temp;
            return ret;
        }
    }

    public void push(Integer integer) {
        data.add(integer);
    }

    public int size() {
        return data.size();
    }
}
