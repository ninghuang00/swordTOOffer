package cn.hn.pinduoduo;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        String[] strings = new String[M];
        for(int i = 0; i < M; i++) {
            strings[i] = in.next();
        }

        if (M == 1) {
            System.out.println(-1);
            return;
        }

        int index = 0;
        for (int i = 1; i < strings.length;i++) {
            if (helper(strings[index], strings[i]) > 0) {
                index = i;
            }/*else if (helper(strings[index], strings[i]) == 0) {
                index = -1;
            }*/
        }

        for (int i = 0; i < N; i++) {
            if (index != i && (helper(strings[i], strings[index]) == 0 || helper(strings[i], strings[index]) == -1)) {
                index = -1;
                break;
            }
        }

        System.out.println(index);
    }

    public static int helper(String a, String b) {
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        int suma = 0;
        int sumb = 0;
        for (int i = 0; i < aa.length;i++) {
            if (aa[i] < bb[i]) {
                sumb++;
            } else if (aa[i] > bb[i]) {
                suma++;
            }
        }

        return suma - sumb;
    }
}

