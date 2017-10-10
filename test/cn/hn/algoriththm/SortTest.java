package cn.hn.algoriththm;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by huangning on 2017/9/26.
 */
public class SortTest {
    Sort sort = new Sort();
    @Test
    public void quickSort() throws Exception {
        int[] nums = {2,4,7,1,2,3,4,9,0,7,8,6,4,11,14,19,34,54,32,65,9,7,8,65,9,88,56,98,1,5,3,2,7,4};
        int start = 0;
        int end = nums.length - 1;
        sort.quickSort(nums,start,end);
        System.out.println(Arrays.toString(nums));
        System.out.println(nums);
    }
}