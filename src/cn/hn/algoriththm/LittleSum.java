package cn.hn.algoriththm;

import cn.hn.CallbackMethod;
import cn.hn.CallbackMethodImpl;

/**
 * Created by huangning on 2018/5/22.
 */
public class LittleSum extends CallbackMethodImpl{
    private static int sum;
    public int littleSum(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        sum = 0;
        mergeProcessor(arr, start, end);
        return sum;
    }

    public void mergeProcessor(int[] arr, int start, int end) {
        if (end == start) {
            return;
        }
        int mid = (start + end) / 2;
        mergeProcessor(arr, start, mid);
        mergeProcessor(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public void merge(int[] arr, int start, int mid, int end) {
        int[] helper = new int[end - start + 1];
        int index = 0;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                sum += arr[left] * (end - right + 1);
                helper[index++] = arr[left++];
            } else {
                helper[index++] = arr[right++];
            }
        }
        if (left > mid) {
            while (right <= end) {
                helper[index++] = arr[right++];
            }
        } else {
            while (left <= mid) {
                helper[index++] = arr[left++];
            }
        }
        for (int i = 0; i < helper.length; i++) {
            arr[start + i] = helper[i];
        }

    }

    public int stupidMethod(int[] arr) {
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j ++) {
                if (arr[j] < arr[i]) {
                    sum += arr[j];
                }
            }
        }
        return sum;
    }

    @Override
    public int yourMethodWithReturn(int[] arr) {
        return littleSum(arr);
    }

    @Override
    public int rightMethodWithReturn(int[] arr) {
        return stupidMethod(arr);
    }
}
