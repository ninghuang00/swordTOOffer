package com.huangning.demo;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by huangning on 2017/5/6.
 */
public class HelloWorld {
    public static void main(String[] args){
        System.out.println("hello world!");

        MonthPrinter.print();

    }


}

class MonthPrinter{

    public static void print(){
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();//今天的月份
        int day = today.getDayOfMonth();//今天几号

        System.out.println(month + "月" + day + "日");

        today = today.minusDays(day - 1);
        int val = today.getDayOfWeek().getValue() % 7;

        //System.out.println("val" + val );

        System.out.println("Sun Mon Tue Wed Thu Fri Sar");
        for(int i = 0; i < val; i ++){
            System.out.print("    ");
        }
        while(today.getMonthValue() == month){
            System.out.printf("%3d",today.getDayOfMonth());
            if(day == today.getDayOfMonth())
                System.out.print("*");
            else
                System.out.print(" ");
            //每当遇到
            if(today.getDayOfWeek().getValue() == 6)
                System.out.println();
            today = today.plusDays(1);
        }


    }
}
