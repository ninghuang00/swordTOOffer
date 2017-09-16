package com.huangning.demo;

/**
 * Created by huangning on 2017/7/5.
 */
public class RegularExpressionTest {
    public static void main(String[] args){
        System.out.println("a\\\\b".replace("\\","||"));
        System.out.println("hhhh");
        System.out.println("a\\b");
        System.out.println("\\||\\|");
        String t = "a||b||c||d";
        //'\'放在正则表达式和Java的System.out,println里看是不一样的
        String[] temp = t.split("\\|\\|");

        System.out.println(temp.length);
        for(String s:temp){
            System.out.println(s);
        }
    }
}
