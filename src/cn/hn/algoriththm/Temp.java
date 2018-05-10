package cn.hn.algoriththm;

import java.util.Arrays;

/**
 * Created by huangning on 2018/3/27.
 */
public class Temp {
    public static void main(String[] args) {
        String s = "1411072 2110464 1388544 2362368 1103872 59392 133120 1184768 1500160 1332224";
        String []strings = s.split(" ");
        int[] arr = new int[strings.length];
        for (int i = 0; i < arr.length;i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(Arrays.toString(arr));

    }

    //返回绝对值
    public static int abs(int a) {
        return a >= 0 ? a : -a;
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
    //返回大的
    public static int maxInt(int a, int b) {
        return a > b ? a : b;
    }
    //返回小的
    public static int minInt(int a, int b) {
        return a < b ? a : b;
    }

    //降序
    public static void quickSortInt(int[] arr, int start, int end) {
        if(arr.length == 0 || start < 0 || end > arr.length - 1 )
            return;
        if (start == end) {
            return;
        }
        int mid = partition(arr, start, end);
        if (mid > start)
            quickSortInt(arr, start, mid - 1);
        if (mid < end)
            quickSortInt(arr, mid+1, end);

    }
    public static int partition(int[] arr, int start, int end) {
        int index = start;
        int smaller = start - 1;
        for (; index < end; index++) {
            if (arr[index] > arr[end]) {
                smaller++;
                if (smaller != index) {
                    swapInt(arr, smaller, index);
                }
            }
        }
        smaller++;
        swapInt(arr, smaller, end);
        return smaller;
    }
}
//从键盘输入接受数据
//    Scanner in = new Scanner(System.in);
//    int n = in.nextInt();
//    int[] arr = new int[n];
//        for(int i = 0; i < n;i++) {
//        arr[i] = in.nextInt();
//    }

//以空格间隔,末尾不带空格
//for (int i = 0; i<n-1;i++) {
//        System.out.print(arr[i]+" ");
//        }
//        System.out.print(arr[n-1]);