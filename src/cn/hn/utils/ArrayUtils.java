package cn.hn.utils;

/**
 * Created by huangning on 2018/5/27.
 */
public class ArrayUtils {
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
            arr[i] = Math.abs((int) (Math.random() * (value + 1)) - (int) (Math.random() * (value + 1))) + 1;
        }
        return arr;
    }
}
