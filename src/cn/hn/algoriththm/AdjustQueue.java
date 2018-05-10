package cn.hn.algoriththm;

/**
 * Created by huangning on 2018/3/27.
 */

import java.util.*;

public class AdjustQueue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] arr1 = s.toCharArray();
        char[] arr2 = s.toCharArray();
        int count1 = 0;
        int count2 = 0;
        //升序
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j + 1 < arr1.length - i; j++) {
                if (arr1[j] > arr1[j + 1]) {
                    swapChar(arr1, j, j + 1);
                    count1++;
                }
            }

        }
        //降序
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j + 1 < arr2.length - i; j++) {
                if (arr2[j] < arr2[j + 1]) {
                    swapChar(arr2, j, j + 1);
                    count2++;
                }
            }

        }

        System.out.println(minInt(count1, count2));

    }


    public static void swapChar(char[] arr, int j, int i) {

        char temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }



    public static int minInt(int a, int b) {
        return a < b ? a : b;
    }


}

