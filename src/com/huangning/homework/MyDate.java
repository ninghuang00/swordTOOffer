package com.huangning.homework;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by huangning on 2017/11/4.
 */
public class MyDate {
    int year;
    int month;
    int day;

    public MyDate() {

    }

    public MyDate(Date date) {

        if (date != null) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);

            this.year = calendar.get(Calendar.YEAR);
            this.month = calendar.get(Calendar.MONTH) + 1;
            this.day = calendar.get(Calendar.DAY_OF_MONTH);
        }
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "年" + month + "月" + day + "日";
    }
}