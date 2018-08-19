package cn.hn.algoriththm;

import cn.hn.CallbackMethod;
import cn.hn.CallbackMethodImpl;
import cn.hn.utils.PrintUtil;
import cn.hn.utils.TestYourCode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by huangning on 2017/9/26.
 */
public class SortTest {
    class HeapSort extends CallbackMethodImpl{
        @Override
        public void yourMethod(int[] arr) {
            Sort.heapSort(arr);
        }

        @Override
        public void rightMethod(int[] arr) {
            Arrays.sort(arr);
        }
    }

    @Test
    public void heapSort() throws Exception {
//        int[] arr = {6, 19, 22, 26, 68, 25, 13, 28, 12};
        int[] arr = {6, 27, 78, 13, 70, 23, 86};

        Sort.heapSort(arr);


    }

    @Test
    public void testYourCode() throws Exception {
        TestYourCode test = new TestYourCode(new HeapSort());
        test.testArr(new int[0]);
    }

    @Test
    public void mergeSort() throws Exception {
        int[] nums = {4,2,5,3,8,9,6,7,6,5,4,1,0,2};
        int start = 0;
        int end = nums.length - 1;
        Sort.mergeSort(nums, start, end);
        PrintUtil.printIntArray(nums);

    }

    @Test
    public void insertionSort() throws Exception {
        int[] nums = {4,2,5,3,8,9,6,7,6,5,4,1,0,2};
        int start = 0;
        int end = nums.length - 1;
        Sort.insertionSort(nums, start, end);
        PrintUtil.printIntArray(nums);

    }

    @Test
    public void selectionSort() throws Exception {
        int[] nums = {4,2,5,3,8,9,6,7,6,5,4,1,0,2};
        int start = 0;
        int end = nums.length - 1;
        Sort.selectionSort(nums, start, end);
        PrintUtil.printIntArray(nums);


    }

    @Test
    public void bubbleSort() throws Exception {

        int[] nums = {4, 2, 5, 3, 8, 9, 6, 7, 6, 5, 4, 1, 0, 2};
        int start = 3;
        int end = nums.length - 3;
        Sort.bubbleSort(nums, start, end);
        PrintUtil.printIntArray(nums);


    }



    @Test
    public void quickSort() throws Exception {
        int[] nums = {2,4,7,1,2,3,4,9,0,7,8,6,4,11,14,19,34,54,32,65,9,7,8,65,9,88,56,98,1,5,3,2,7,4};
        int start = 0;
        int end = nums.length ;
        Sort.quickSort(nums,start,end);
        PrintUtil.printIntArray(nums);

    }

    @Test
    public void quickSort2() {
        int[] nums = {2,4,7,1,2,3,4,9,0,7,8,6,4,11,14,19,34,54,32,65,9,7,8,65,9,88,56,98,1,5,3,2,7,4};
        int start = 0;
        int end = nums.length - 1;
        Sort.quickSort2(nums,start,end);
        PrintUtil.printIntArray(nums);

    }
}