package cn.hn.algoriththm;


import java.util.*;
//网易笔试 疯狂队列 90%
public class CrazyQueue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        sort(arr);

        int sum = 0;
        if (n % 2 == 1) {
            int start = 1;
            int end = arr.length-1;
            sum = abs(arr[0]*2 -(arr[end] + arr[end -1]));
            int count = 0;
            while(start < end - 2){
                if (count % 2 == 0) {
                    count ++;
                    sum += abs(arr[end ] + arr[end - 1] - arr[start] - arr[start + 1]);
                    end -= 2;
                }else{
                    count ++;
                    sum += abs(arr[start] + arr[start +1]- arr[end]-arr[end -1]);
                    start += 2;
                }
            }


        }else{
            int start = 1;
            int end = arr.length-1;
            sum = abs(arr[0]*2 -(arr[end] + arr[end -1]));
            int count = 0;
            while(start < end - 2){
                if (count % 2 == 0) {
                    count ++;
                    sum += abs(arr[end ] + arr[end - 1] - arr[start] - arr[start + 1]);
                    end -= 2;
                }else{
                    count ++;
                    sum += abs(arr[start] + arr[start +1]- arr[end]-arr[end -1]);
                    start += 2;
                }
            }
            int a = arr[start]-arr[start+2];
            int b = arr[start]-arr[start+1];
            sum += (a > b ? a : b);

        }

        System.out.println(sum);


    }

    public static int abs(int a) {
        return a >= 0 ? a : -a;
    }


    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j + 1 < arr.length - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }

        }
    }

    private static void swap(int[] arr, int j, int i) {

        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


}