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
        int[] next = getNext(str2);//获取next数组
        while (i1 < chars1.length && i2 < chars2.length) {
            if (chars1[i1] == chars2[i2]) {//字符匹配,指针一起右移
                i1++;
                i2++;
            } else if (next[i2] == -1) {//字符没配上,并且str2中的指针已经来到0位置,还是配不上,str1指针右移,从新开始尝试匹配
                i1++;
            } else {//根据前缀长度,左移str2的指针,继续尝试
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
        int pCur = 2;//指向要求最长前后缀匹配长度的字符
        int pn = 0;//当字符不匹配是用来左移的指针
        while (pCur < next.length) {
            //当前字符的前一个字符是否和之前最长前缀的后一个字符相等
            if (chars[pCur - 1] == chars[pn]) {
                next[pCur++] = ++pn;
            } else if (pn > 0) {    //将pn移到之前一个最长前缀
                pn = next[pn];
            } else {    //pn已经指向第一个字符了还是不匹配
                next[pCur++] = 0;
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
