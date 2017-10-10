package com.huangning.demo;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by huangning on 2017/5/6.
 */
public class HelloWorld {
    public static void main(String[] args) {
        test(8, 6);

    }

    public static void test(int upDepth, int downDepth) {

        int mid = 0;
        for(int i = upDepth; i > 0 ; i --){
            int width = i*2-1;
            int j ;
            for( j = 0; j < upDepth - i; j ++){
                System.out.print(" ");
            }
            mid = j;
            for( j = 0; j < width; j ++){
                System.out.print("M");
            }
            if(i != 0)
            System.out.println();
        }

        for(int i = 0; i < downDepth; i ++){
            for(int j = 0; j < mid - i; j ++){
                System.out.print(" ");
            }
            char c = 'A';
            for(int j = 0; j < 2*i+1; j ++){
                System.out.print(c++);
            }
            System.out.println();
        }
        System.out.print("hahah");

        /*if (width % 2 == 0) {
            width++;
        }
        for (int i = width; i > 0; i--) {
            int blank = width - i;
            for (int b = 0; b < blank; b++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i - blank; j++) {
                System.out.print('M');
            }
            System.out.println();
        }*/
    }


}

class MonthPrinter {

    public static void print() {
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();//今天的月份
        int day = today.getDayOfMonth();//今天几号

        System.out.println(month + "月" + day + "日");

        today = today.minusDays(day - 1);
        int val = today.getDayOfWeek().getValue() % 7;

        //System.out.println("val" + val );

        System.out.println("Sun Mon Tue Wed Thu Fri Sar");
        for (int i = 0; i < val; i++) {
            System.out.print("    ");
        }
        while (today.getMonthValue() == month) {
            System.out.printf("%3d", today.getDayOfMonth());
            if (day == today.getDayOfMonth())
                System.out.print("*");
            else
                System.out.print(" ");
            //每当遇到
            if (today.getDayOfWeek().getValue() == 6)
                System.out.println();
            today = today.plusDays(1);
        }


    }
}
