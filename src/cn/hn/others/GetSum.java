package cn.hn.others;

import java.util.Scanner;

/**
 * Created by huangning on 2018/4/10.
 */
public class GetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();

        if (s.equals("")) {
            return;
        }


        String[] ss = s.split(" ");

        int ans = 0;
        for (String sin : ss) {
            int i = Integer.parseInt(sin);
            ans += i;
        }



        System.out.println(ans);
    }
}
