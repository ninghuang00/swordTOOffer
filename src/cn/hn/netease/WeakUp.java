package cn.hn.netease;

import java.util.*;

/**
 * Created by huangning on 2018/8/11.
 *
 * 网易 听课 知识点 最大化
 * 其实就是以w为窗口,求窗口中的睡觉时对应的知识点数的最大值
 */
public class WeakUp {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt();
//        int k = in.nextInt();
//
//        int[] point = new int[n];
//        int[] isWeak = new int[n];
//
//        for(int i = 0 ; i < n; i++) {
//            point[i] = in.nextInt();
//        }
//
//        for(int i = 0 ; i < n; i++) {
//            isWeak[i] = in.nextInt();
//        }

        int n = 7;
        int k = 3;
        int[] point = {1, 3, 2, 3, 1, 4, 7};
        int[] isWeak = {1, 0, 1, 0, 0, 1, 0};

        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (isWeak[i] == 1) {
                sum += point[i];
            }
        }

        System.out.println("result is " + (sum + getMax(point, k, isWeak)));

    }

    public static int getMax(int[] arr, int w,int[] isw) {

        int max = 0;
        for (int i = 0; i < w;i++) {
            //如果在睡觉则加上
            if (isw[i] == 0) {
                max += arr[i];
            }
        }

        //更新窗口中的睡觉时的知识点最大和
        System.out.println(max);

        int lastCur = max;
        
        for (int i = 0 ; i < arr.length - w ;i++) {
            int cur = lastCur;
            cur = cur - (isw[i] == 0 ? arr[i] : 0) + (isw[w + i] == 0 ? arr[w + i] : 0);
            max = max > cur ? max : cur;
            lastCur = cur;
            System.out.println(max);
        }

        return max;


    }


}
