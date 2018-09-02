package cn.hn.pinduoduo;

import java.util.Scanner;

/**
 * Created by huangning on 2018/8/30.
 */
public class GoDown {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int y = in.nextInt();
        int x = in.nextInt();

        int[][] upStones = new int[2][x];
        char[][] ma =new char[y][x];

//        String temp = in.nextLine();
        for (int i = 0; i < y; i++) {
//        while(in.hasNextLine()){
            String line = in.next();
            char[] chars = line.toCharArray();
            ma[i] = chars;
            System.out.println(ma[i]);

            for (int j = 0; j < x;j++) {
                char now = ma[i][j];
                if (now == 'o') {
                    upStones[1][j]++;
                } else if (now == 'x') {
                    clean(ma, i, j,upStones);
                }
            }
        }
        System.out.println();

        for (int i = 0; i < y;i++) {
            System.out.println(ma[i]);
        }

    }

    private static void clean(char[][] ma, int y, int x, int[][] up) {

        int i;
        for (i = y - 1; i >= y - up[1][x]; i--) {
            ma[x][i] = 'o';
        }

        for (;i >= up[0][x];i--) {
            ma[x][i] = '.';
        }

        up[0][x] = y + 1;


    }


}
//测试用例
/*

3 4
.ooo
o.ox
.xx.


输出
..oo
.oox
.xx.



*/