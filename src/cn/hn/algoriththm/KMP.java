package cn.hn.algoriththm;

import java.util.Arrays;

/**
 * Created by huangning on 2018/6/26.
 * KMP算法
 * 是否包含子字符串
 */
public class KMP {
    public static int isContain(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNext(str2);

        while (i1 < chars1.length && i2 < chars2.length) {
            if (chars1[i1] == chars2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }

        return i2 == next.length ? i1 - i2 : -1;
    }

    public static int[] getNext(String str) {
        char[] chars = str.toCharArray();
        int[] next = new int[chars.length];

        next[0] = -1;
        next[1] = 0;
        int pc = 2;
        int pn = 0;
        //对于字符串数组每一个位置上的字符来说,求它的最长前缀和最长后缀匹配长度
        while (pc < next.length) {
            if (chars[pc - 1] == chars[pn]) {
                next[pc++] = ++pn;
            } else if (pn > 0) {    //除去0和-1的情况
                pn = next[pn];
            } else {
                next[pc++] = 0;
            }
        }

        return next;

    }

    //网易题目,给你ab cabc,输出abc abc abc,
    //给你 abcdeab,输出ab cde ab cde ab
    //输入 abcde, 输出 abcde abcde
    public static String doubleStr(String string) {
        char[] chars = string.toCharArray();
        int length = chars.length;
        int[] next = new int[chars.length + 1];
        next[0] = -1;
        next[1] = 0;
        int pc = 2;//指向每一个字符
        int pn = 0;//指向next数组
        while (pc <= chars.length) {
            if (chars[pc - 1] == chars[pn]) {
                next[pc++] = ++pn;
            } else if (pn > 0) {
                pn = next[pn];
            } else {
                next[pc++] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        char[] ret = new char[length + length - next[length]];
        int i = 0;
        while(i < length){
            ret[i] = chars[i];
            i++;
        }
        int j = next[length];
        while (j < length) {
            ret[i++] = chars[j++];
        }

        return String.copyValueOf(ret);
    }

    public static void main(String[] args) {
//        String str2 = "abcabcde";
//        System.out.println(Arrays.toString(getNext(str2)));
//
//        String str1 = "abcabcabcde";
//
//        System.out.println(isContain(str1, str2));


        System.out.println(doubleStr("aaa"));



    }
}
