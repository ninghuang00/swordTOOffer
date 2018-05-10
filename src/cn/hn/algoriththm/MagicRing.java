package cn.hn.algoriththm;

import java.util.Scanner;

/**
 * Created by huangning on 2018/3/27.
 * 魔力手环
 */
public class MagicRing {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();

        }

        for (int i = 0; i < k; i++) {
            int temp = arr[0];
            for (int j = 0; j < n - 1; j++) {
                arr[j] += arr[j + 1];
                if (arr[j] >= 100) {
                    arr[j] = arr[j] % 100;
                }
            }
            int end = n - 1;
            arr[end] += temp;
            if (arr[end] >= 100) {
                arr[end] = arr[end] % 100;
            }
        }


        for (int i = 0; i < n - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[n - 1]);

    }
}
