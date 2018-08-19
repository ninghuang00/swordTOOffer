package cn.hn.netease;

import java.util.Scanner;

/**
 * Created by huangning on 2018/8/4.
 * 网易 数对
 */
public class NumberPair {
    public static long getCount(int n, int k) {
        if (n > 100000 || n < 1 || k >= n || k < 0) {
            return -1;
        }
        long count = 0;
        long times = 0;
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                if (times >= 0) {
                    times++;
                }
                if (count > 0 && times > 0) {
                    System.out.println(times + "times then count > 0 ,count:" + count );
                    times = -1;
                }
                if (x % y >= k) {
                    count++;
                }
            }
        }


        return count;
    }

    public static long getCount2(int n, int k) {
        if (n > 100000 || n < 1 || k >= n || k < 0) {
            return -1;
        }
        long count = 0;

        for (int y = k + 1; y <= n; y++) {
            count += (n / y) * (y - k) + (n % y == 0 ? 0 : (n % y - k + 1));
        }


        return count;
//        return count + (n - k + 1) * (n - k) / 2;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//
//        System.out.println(getCount2(n, k));


        int n = 5000;
        int k = 768;

        long start = System.currentTimeMillis();
        System.out.println(getCount2(n, k));
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(getCount(n, k));
        end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
    }
}
