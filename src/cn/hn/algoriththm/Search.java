package cn.hn.algoriththm;

import java.util.Arrays;

/**
 * Created by huangning on 2018/7/15.
 */
public class Search {
    public static int bSearch(int[] arr, int aim) {
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            if (aim > arr[mid]) {
                left = mid + 1;
            } else if (aim < arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }
}
