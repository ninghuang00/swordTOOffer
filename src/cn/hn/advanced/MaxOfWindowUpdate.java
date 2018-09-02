package cn.hn.advanced;

import java.util.LinkedList;

/**
 * Created by huangning on 2018/9/2.
 * 窗口的最大值更新结构
 */
public class MaxOfWindowUpdate {
    //存放当前窗口中可能成为最大值的值的下标
    private LinkedList<Integer> list = new LinkedList<>();
    //需要使用窗口滑过的数组
    private int[] arr;

    public MaxOfWindowUpdate(int[] arr) {
        this.arr = arr;
    }

    //窗口右边界移动时,往队列中添加下标
    public void add(int index) {
        while (!list.isEmpty() && arr[list.peekLast()] <= arr[index]) {
            list.removeLast();
        }
        list.addLast(index);
    }

    //窗口左边界移动时,从队列里移除下标
    public void remove(int index) {
        if (!list.isEmpty() && list.peekFirst() == index) {
            list.removeFirst();
        }
    }

    //获取窗口中的最大值
    public Integer getMax() {
        if (!list.isEmpty()) {
            return list.peekFirst();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 3, 5, 6, 1, 2, 9};
        MinOfWindowUpdate maxWin = new MinOfWindowUpdate(arr);
        for (int i = 0 ; i < 4; i++) {
            maxWin.add(i);
            System.out.print(arr[maxWin.getMin()] + " ");

        }

        System.out.println();

        for (int i = 0 ; i < 3; i++) {
            maxWin.remove(i);
            System.out.print(arr[maxWin.getMin()] + " ");

        }
    }


}
