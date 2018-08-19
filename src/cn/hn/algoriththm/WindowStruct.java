package cn.hn.algoriththm;

import java.util.LinkedList;

/**
 * Created by huangning on 2018/8/11.
 * 窗口结构
 */
public class WindowStruct {
    private LinkedList<Integer> max;
    private LinkedList<Integer> min;

    public WindowStruct() {
        max = new LinkedList<>();
        min = new LinkedList<>();
    }

    /*
     * title:窗口最大值更新结构
     * explanation:
     * tip:
     * example:
     * param:
     * return:返回窗口中最大值
     */
    public int maxWindow(int[] arr, int l, int r) {
        if (max.size() == 0) {
            max.add(l);
        }
        while (l <= r) {
            if (arr[max.peekLast()] <= arr[l]) {
                max.removeLast();
            }
            l++;
        }
        max.addLast(l);

        return 0;

    }


}
