package cn.hn.pinduoduo;

/**
 * Created by huangning on 2018/7/20.
 */
public class WorldCup {
    public static void main(String[] args) {

        String[] strings = {
                "acbd",
                "bacd",
                "bdca"
        };
        int index = 0;
        for (int i = 1; i < strings.length;i++) {
            if (helper(strings[index], strings[i]) > 0) {
                index = i;
            }else if (helper(strings[index], strings[i]) == 0) {
                index = -1;
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
