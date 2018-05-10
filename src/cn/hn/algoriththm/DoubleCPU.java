package cn.hn.algoriththm;

/**
 * Created by huangning on 2018/3/27.
 * 50%
 */
public class DoubleCPU {

    public static void main(String[] args) {

        int n = 10;
        int arr[] = {1411072, 2110464, 1388544, 2362368, 1103872, 59392, 133120, 1184768, 1500160, 1332224};
        quickSortInt(arr,0,n-1);
        int cpu1 = arr[0];
        int cpu2 = arr[1];
        for (int i = 2;i < n; i++) {
            if (abs(cpu1 + arr[i] - cpu2) >= abs(cpu2 + arr[i] - cpu1)) {
                cpu2 += arr[i];
            } else {
                cpu1 += arr[i];
            }
        }

        System.out.println(maxInt(cpu1,cpu2));


    }

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

    public static void swapInt(int[] arr, int j, int i) {

        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static int maxInt(int a, int b) {
        return a > b ? a : b;
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

