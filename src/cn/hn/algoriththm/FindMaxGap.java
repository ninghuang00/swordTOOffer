package cn.hn.algoriththm;

import cn.hn.CallbackMethodImpl;

import java.util.Arrays;

/**
 * Created by huangning on 2018/5/29.
 */
public class FindMaxGap extends CallbackMethodImpl{

    @Override
    public int yourMethodWithReturn(int[] arr) {
        return findMaxGap(arr);
    }

    @Override
    public int rightMethodWithReturn(int[] arr) {
        return findMaxGapByBadWay(arr);
    }

    public int findMaxGap(int[] arr) {
        int ret = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = max > arr[i] ? max : arr[i];
            min = min < arr[i] ? min : arr[i];
        }
        if (max == min) {
            return 0;
        }

        //创建数组长度+1个桶,这样可以保证至少有一个空桶,每个桶中的信息包括这个桶是否有数字,这个桶中的最大最小值
        int len = arr.length + 1;
        int[] minArr = new int[len + 1];
        int[] maxArr = new int[len + 1];
        boolean[] hasNum = new boolean[len + 1];
        int index;
        double factor = (double)len/(max - min);

        for (int i = 0;i < arr.length; i++) {
            index = getIndex(arr[i], min, factor);
            maxArr[index] = hasNum[index] ? Math.max(arr[i], maxArr[index]) : arr[i];
            minArr[index] = hasNum[index] ? Math.min(arr[i], minArr[index]) : arr[i];
            hasNum[index] = true;

        }

        int lastMax = maxArr[0];
        //从最小号桶开始遍历桶,寻找每个桶中的最大值和下一个非空桶中的最小值的差值,其中最大的差值返回
        for (int i = 1; i < hasNum.length; i++) {
            if (hasNum[i]) {
                ret = Math.max(ret, minArr[i] - lastMax);
                lastMax = maxArr[i];
            }
        }

        return ret;
    }

    //计算一个数字num应该放在哪个桶中的公式:(int)((num - min) * len / (max - min))
    private int getIndex(int i, int min, double factor) {
        return (int)((i - min)*factor);
    }


    public int findMaxGapByBadWay(int[] arr) {
        Arrays.sort(arr);
        int maxGap = 0;
        int delta;
        for (int i = 0; i + 1 < arr.length;i++) {
            delta = arr[i + 1] - arr[i];
            maxGap = maxGap > delta ? maxGap : delta;
        }

        return maxGap;
    }
}
