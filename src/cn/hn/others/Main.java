package cn.hn.others;

import cn.hn.utils.TestYourCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {




    public static void main(String[] args) {

        Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = Arrays.asList(nums);

        System.out.println(list.stream().
                filter(num -> {
                    System.out.println(num);
                    return num > 5;
                }).
                count());



    }
}
