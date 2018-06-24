package cn.hn.algoriththm;

import cn.hn.utils.ArrayUtils;
import cn.hn.utils.SwapUtil;

import java.util.Arrays;

/**
 * Created by huangning on 2018/6/23.
 */
public class PrintSequence {
    public static void printAllSubSeq(char[] arr, int index, String res) {
        if (index == arr.length) {
            System.out.println(res);
            return;
        }
        printAllSubSeq(arr, index + 1, res + arr[index]);
        printAllSubSeq(arr, index + 1, res);

    }

    //打印所有的子序列,还没有想通
    public static void printAllFullSeq(char[] arr, int start) {
        if (start == arr.length) {
            System.out.println(arr);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, i, start);
            printAllFullSeq(arr, start + 1);

        }

    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        printAllFullSeq("abc".toCharArray(), 0);
//        printAllSubSeq("abc".toCharArray(), 0, "");
    }
}
