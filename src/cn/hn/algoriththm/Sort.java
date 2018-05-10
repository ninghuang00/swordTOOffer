package cn.hn.algoriththm;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by huangning on 2017/9/25.
 */
public class Sort {

    /*
     * title:优化后的快排
     * explanation:优化partition函数,找出等于区域
     * tip:
     * example:
     * param:
     * return:
     */
    public static void quickSort2(int[] arr, int start, int end) {
        if (start < end) {
            swap(arr, start + (int) (Math.random() * (end - start + 1)), end);
            int[] pivot = partition2(arr, start, end);
            quickSort2(arr, start, pivot[0] - 1);
            quickSort2(arr, pivot[1] + 1, end);
        }
    }

    private static int[] partition2(int[] arr, int start, int end) {
        //某一状态西,smaller指针代表小于基准的数字的范围,bigger代表大于基准的数字的范围
        int smaller = start - 1;//smaller代表小于的范围
        int bigger = end;//bigger代表大于的范围
        while (start < bigger) {
            if (arr[start] < arr[end]) {//当start指针发现小于基准的数字,交换到smaller指针处,向前移动smaller指针和start指针
                swap(arr, ++smaller, start++);
            } else if (arr[start] > arr[end]) {//当start指针发现大于基准的数字,和bigger交换,往回移动bigger指针,因为不确定bigger指针指向的数字,所以start指针不移动,接着判断
                swap(arr, --bigger, start);
            } else {//当start指针发现相等的数字,直接移动start指针
                start++;
            }
        }
        swap(arr, bigger, end);//因为用最后一个数作比较,所以要和bigger中最小的数字交换
        return new int[]{smaller + 1, bigger};//返回的是最后基准的下标
    }


    /*
    快速排序
    平均时间复杂度:O(nlogn)
    最坏时间复杂度:O(n^2)
    空间复杂度:O(nlogn)
     */
    public static void quickSort(int[] nums, int start, int end) {
        if (nums == null || start < 0 || end >= nums.length) {
            throw new RuntimeException("illegal input");
        }

        if (start == end) return;

        int index = partition(nums, start, end);
        if (index > start) {
            quickSort(nums, start, index - 1);
        }
        if (index < end) {
            quickSort(nums, index + 1, end);
        }
    }

    /*
    在数组中选定一个数,将大于这个数的放右边,小的放左边
     */
    private static int partition(int[] nums, int start, int end) {
        if (nums == null || end >= nums.length || start < 0) {
            throw new RuntimeException("illegal input ");
        }
        int smaller = start - 1;    //用于指向比基数小的数字
        int index = randomInRange(start, end);   //生成给定范围的随机数,确定基数
        swap(nums, index, end);   //将选定的基数换到数组最后

        for (index = start; index < end; ++index) {
            if (nums[index] < nums[end]) {//当index发现小于基数的数字时
                //此时的++smaller要么是大于基数的数,要么就是index发现的数字
                ++smaller;
                //正常情况下smaller==index
                //不相等时smaller和index之间的数是大于基数的,所以就是把smaller后面index发现的小于基数的数字换上来
                if (smaller != index) {
                    swap(nums, smaller, index);
                }
            }
        }

        ++smaller;
        swap(nums, smaller, end);
        return smaller;
    }

    private static int randomInRange(int start, int end) {
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        Random random = new Random();
        return random.nextInt(end - start + 1) + start;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 9, 5, 8, 6, 7};
        Sort.quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

}
