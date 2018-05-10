package cn.hn.utils;

import cn.hn.others.Main;

import java.util.Arrays;

/**
 * Created by huangning on 2018/3/28.
 */
/*
 * title:比较器
 * explanation:用来产生随机数组作为测试用例,来比较确定正确的方法和自己写的方法,找出错误的用例
 * tip:
 * example:
 * param:
 * return:
 */
public class TestYourCode {


    public static void main(String[] args) {

        int testTimes = 500;
        int size = 10;
        int value = 10;
        boolean succeed = true;
        for (int i = 0;i < testTimes;i++) {
            int[] arr1 = generateRandomArray(size, value);
            if (arr1.length == 0) {
                continue;
            }
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);

            int res1 = Main.JumpA(arr1);
            int res2 = Main.JumpB(arr2);

            if (res1 != res2) {
                succeed = false;
                System.out.println(res1 + ":" + res2);
                printArray(arr1);
                printArray(arr2);
                break;
            }

//            yourMethod(arr1);
//            rightMethod(arr2);
//            if (!isEqual(arr1, arr2)) {
//                succeed = false;
//                printArray(arr3);
//                break;
//            }
        }
        System.out.println(succeed ? "Nice" : "What's the fuck");
//        printArray(generateRandomArray(size,value));


    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    private static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 != null && arr2 == null) || (arr1 == null && arr2 != null)) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }

        for (int i = 0; i<arr1.length;i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void yourMethod(int[] arr) {
        sortInt(arr);
    }
    //准备一个绝对正确但是实现简单的方法
    public static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }
    /*
     * title:随机数列生成器
     * explanation:生成一个0<=数组长度<=size的数组,数组中的数字是[-value,value]
     * tip:
     * example:
     * param:
     * return:
     */
    public static int[] generateRandomArray(int size, int value) {
        int[] arr = new int[(int) (Math.random() * (size + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs((int) (Math.random() * (value + 1)) - (int) (Math.random() * (value+1))) + 1;
        }
        return arr;
    }
    //返回数组拷贝
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] ret = new int[arr.length];
        for (int i = 0;i < arr.length;i++) {
            ret[i] = arr[i];
        }
        return ret;
    }

    //升序
    public static void sortInt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j + 1 < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapInt(arr, j, j + 1);
                }
            }

        }
    }
    //交换元素
    public static void swapInt(int[] arr, int j, int i) {

        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
