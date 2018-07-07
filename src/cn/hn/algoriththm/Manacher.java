package cn.hn.algoriththm;

/**
 * Created by huangning on 2018/7/2.
 */
public class Manacher {
    private static char[] getManacherStr(String string) {
        char[] chars = string.toCharArray();
        char[] newChars = new char[chars.length * 2 + 1];
        for (int i = 0;i < newChars.length;i++) {
            newChars[i] = (i & 1) == 0 ? '#' : chars[i / 2];
        }
        return newChars;
    }

    public static int manacher(String str) {
        char[] chars = getManacherStr(str);
        int[] pRs = new int[chars.length];//最大回文半径数组
        int pR = -1;//当前字符的最大回文半径
        int max = 1;
        int center = -1;//当前最大回文右边界的中心
        for(int i = 0;i < chars.length; i++) {
            //当前字符下标不在最大回文右边界里头,回文半径从1开始计算
            //在里头,回文半径从(当前字符关于center对称的字符的回文半径,当前字符距离最大回文右边界的距离)中选小的开始计算
            pRs[i] = i >= pR ? 1 : Math.min(pRs[center*2-i],pR - i);
            //只要没有越界,暴力比较
            while (i + pRs[i] < chars.length && i - pRs[i] > -1) {
                if (chars[i + pRs[i]] == chars[i - pRs[i]]) {
                    pRs[i]++;
                } else {
                    break;
                }
            }
            //当前字符的最大回文右边界是否超过之前的
            if (i + pRs[i] > pR) {
                pR = i + pRs[i];
                center = i;
            }
            max = Math.max(max, pRs[i]);
        }


        return max-1;

    }


    public static String toBeHuiwen(String string) {
        char[] chars = getManacherStr(string);
        int[] pRs = new int[chars.length];
        int pR = -1;
        int center = -1;
        int max = 0;
        for (int i = 0; i< chars.length;i++) {
            pRs[i] = i >= pR ? 1 : Math.min(pRs[center * 2 - i], pR - i);
            while (i + pRs[i] < chars.length && i - pRs[i] > -1) {
                if (chars[i + pRs[i]] == chars[i - pRs[i]]) {
                    pRs[i]++;
                } else {
                    break;
                }
            }

            if (i + pRs[i] > pR) {
                pR = i + pRs[i];
                center = i;
            }

            max = Math.max(pRs[i], max);

        }

        char[] ret = new char[string.length() - max + 1];
        for (int i = ret.length - 1, j = 0; i >= 0; i--, j++) {
            ret[i] = chars[j * 2 + 1];
        }
        return new String(ret);
    }


    public static void main(String[] args) {
        String str = "abcde";
//        String str = "abcde";
//        String str = "abcde";


//        System.out.println(manacher(str));
        System.out.println(toBeHuiwen(str));

    }
}
