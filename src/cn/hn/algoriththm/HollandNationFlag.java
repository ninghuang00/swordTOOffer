package cn.hn.algoriththm;

import cn.hn.utils.SwapUtil;

/**
 * Created by huangning on 2018/5/27.
 */
public class HollandNationFlag {
    public void hollandFlag(int[] arr, int pivot) {
        if (arr == null) {
            return;
        }
        partition(arr, pivot);

    }

    private void partition(int[] arr, int pivot) {
        int start = 0;
        int end = arr.length - 1;
        int smaller = start - 1;
        int bigger = end + 1;
        while (start < bigger) {
            if (arr[start] < pivot) {
                SwapUtil.swapInt(arr, ++smaller, start++);
            } else if (arr[start] > pivot) {
                SwapUtil.swapInt(arr, --bigger, start);
            } else {
                start++;
            }
        }


    }
}
