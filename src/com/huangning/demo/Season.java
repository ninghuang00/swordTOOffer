package com.huangning.demo;

/**
 * Created by huangning on 2018/8/4.
 */
public enum Season {
    Spring,Summer,Autumn,Winter;


    public static void main(String[] args) {
        Season season = Season.Autumn;
        System.out.println(season.name());

    }
}
