package cn.hn.algoriththm;

import java.util.Scanner;

/**
 * Created by huangning on 2018/3/27.
 * 90%
 */
public class Rush2Company {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfTaxi = in.nextInt();
        int[] taxiX = new int[numOfTaxi];
        int[] taxiY = new int[numOfTaxi];
        for (int i = 0; i < numOfTaxi; i++) {
            taxiX[i] = in.nextInt();
        }
        for (int i = 0; i < numOfTaxi; i++) {
            taxiY[i] = in.nextInt();
        }
        int gx = in.nextInt();
        int gy = in.nextInt();
        int walkTime = in.nextInt();
        int taxiTime = in.nextInt();

        int minWalk2Taxi = Integer.MAX_VALUE;
        int taxi2Comp = 0;
        //得到最近taxi距离,以及taxi2comp距离
        for (int i = 0; i < numOfTaxi; i++) {
            if (abs(taxiX[i]) + abs(taxiY[i]) < minWalk2Taxi) {
                minWalk2Taxi = abs(taxiX[i]) + abs(taxiY[i]);
                taxi2Comp = abs(taxiX[i] - gx) + abs(taxiY[i] - gy);
            }
        }
        //原点到comp距离
        int o2comp = abs(gx) + abs(gy);

        int minTime = (o2comp * walkTime) < (taxi2Comp * taxiTime + minWalk2Taxi * walkTime) ? (o2comp * walkTime) : (taxi2Comp * taxiTime + minWalk2Taxi * walkTime);
        System.out.println(minTime);


    }

    public static int abs(int a) {
        return a >= 0 ? a : -a;
    }


}
/*测试用例:
33
-763 -6423 -5487 -5313 -5216 1864 4812 -4330 5868 -2723 -5855 -5759 -1377 8513 -4543 4654 -186 -3348 -1995 220 2912 -5831 -6101 -779 -1238 -4502 9727 1026 -1880 2693 3055 8418 -1690
-1937 6168 3081 -548 3498 3864 1165 -4579 8284 -1344 -2357 -7476 -7711 -8973 -3893 380 782 7629 1771 1828 -3867 8165 -1527 7910 -2270 2606 7208 -398 -7037 7872 1561 -2023 7215
-5313 -1880
928 523

对应输出应该为:

4915061

你的输出为:

4971951
*/

