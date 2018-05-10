package cn.hn.algoriththm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangning on 2018/3/27.
 */
public class Hhhh {
    public static void main(String[] args) {
        int [] arr = {1,10,1000};
        int power = 1000;
        System.out.println(find(arr,power));

        Map<String, String> map = new HashMap<>();
    }

    public static int find(int D[], int power) {
        int mid;
        int start = 0;
        int end = D.length - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (power < D[mid]) {
                end = mid - 1;
            } else if (power > D[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start - 1;
    }
}
