package cn.hn.algoriththm;

import java.util.Arrays;

/**
 * Created by huangning on 2018/3/13.
 */
public class Demo {
    public void quickSort(int[] arr, int start, int end) {

        if(arr.length == 0 || start < 0 || end > arr.length - 1 )
            return;

        if (start == end) {
            return;
        }

        int mid = partition(arr, start, end);
        if (mid > start)
            quickSort(arr, start, mid - 1);
        if (mid < end)
            quickSort(arr, mid+1, end);

    }

    public int partition(int[] arr, int start, int end) {
        int index = start;
        int smaller = start - 1;
        for (; index < end; index++) {
            if (arr[index] < arr[end]) {
                smaller++;
                if (smaller != index) {
                    swap(arr, smaller, index);

                }

            }

        }

        smaller++;
        swap(arr, smaller, end);
        return smaller;
    }

    public void swap(int[] arr, int smaller, int index) {
        int temp = arr[smaller];
        arr[smaller] = arr[index];
        arr[index] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {};
//        int[] arr = {2, 1, 3, 4, 5, 9, 8, 6};
        int start = 0;
        int end = arr.length - 1;
        Demo demo = new Demo();
        demo.quickSort(arr, start, end);

        System.out.println(Arrays.toString(arr));

    }
}
