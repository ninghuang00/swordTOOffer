package cn.hn.algoriththm;

import cn.hn.utils.ArrayUtils;
import cn.hn.utils.SwapUtil;

import java.util.Arrays;

/**
 * Created by huangning on 2018/6/23.
 */
public class PrintSequence {
    //打印所有的子序列
    public static void printAllSubSeq(char[] arr, int index, String res) {
        //终止条件:下标到头,打印
        if (index == arr.length) {
            System.out.println(res);
            return;
        }
        //两种选择,加上当前字符,往下走
        printAllSubSeq(arr, index + 1, res + arr[index]);
        //不加当字符
        printAllSubSeq(arr, index + 1, res);

    }

    //打印数组的全排列
    //尝试start位置开始的子数组的全排列
    public static void printAllFullSeq(char[] arr, int start) {
        //终止条件
        if (arr.length == start) {
            System.out.println(arr);
            return;
        }
        //需要闯进去原数组的拷贝,不然交换之后,原数组无法遍历到
        char[] arr2 = Arrays.copyOf(arr, arr.length);
        //将start之后每一个位置的数,放到start位置上,然后尝试start位置之后的数组的全排列
        for (int i = start; i < arr.length; i++) {
            swap(arr2, i, start);
            printAllFullSeq(arr2, start + 1);
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
