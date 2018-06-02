package cn.hn.utils;


/**
 * Created by huangning on 2018/5/27.
 */
public class SwapUtil {
    public static void swapInt(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }

    public static <T> void swap(T[] arr, int index1, int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
