package cn.hn.others;

import cn.hn.utils.TestYourCode;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int JumpB(int[] nums) {

//        while (times-- > 0) {
//        int[] nums = {3, 6, 5, 5, 6};
//            int[] nums = TestYourCode.generateRandomArray(size, value);
//        System.out.println(Arrays.toString(nums));
        int all = nums.length;
        if (all == 1 || nums[0] > all - 1) {
//            System.out.println(1);
            return 1;
        }
        int count = 0;
        int index = 0;
        while (index < all - 1) {
            boolean breakWhile = false;
            count++;
            int max = 0;
            int iOfMax = 0;

            for (int i = index + 1; i <= (index + nums[index] < all - 1 ? index + nums[index] : all - 1); i++) {
                if (index + nums[i] >= all - 1) {
                    breakWhile = true;
                    break;
                }
                if (nums[i] >= max) {
                    max = nums[i];
                    iOfMax = i;
                }
            }
            if (breakWhile) {
                break;
            }
            index = iOfMax;
        }
        return count;
    }


    public static int JumpA(int[] nums) {

//        while (times-- > 0) {
//        int[] nums = {3, 6, 5, 5, 6};
//            int[] nums = TestYourCode.generateRandomArray(size, value);
        System.out.println(Arrays.toString(nums));
        int all = nums.length;
        if (all == 1 || nums[0] > all - 1) {
//            System.out.println(1);

            return 1;
        }
        int count = 0;
        int index = 0;
        while (index < all - 1) {
            boolean breakWhile = false;
            count++;
            int max = 0;
            int iOfMax = 0;

            for (int i = index + 1; i <= (index + nums[index] < all - 1 ? index + nums[index] : all - 1); i++) {

//                    if (index + nums[i] >= all - 1) {
//                        breakWhile = true;
//                        break;
//                    }
                if (nums[i] >= max) {
                    max = nums[i];
                    iOfMax = i;
                }
            }
            if (breakWhile) {
                break;
            }
            index = iOfMax;
        }
        return count;
    }


    public static void main(String[] args) {

        int times = 100;
        int size = 10;
        int value = 10;
        while (true) {
//        while (times-- > 0) {
            int[] nums = {3, 5, 4, 6, 7};
//            int[] nums = TestYourCode.generateRandomArray(size, value);
            System.out.println(Arrays.toString(nums));
            int all = nums.length;
            if (all == 1 || nums[0] > all - 1) {
                System.out.println(1);
                return;
            }
            int count = 1;
            int index = 0;
            while (index < all - 1) {
                boolean breakWhile = false;

                int max = 0;
                int iOfMax = 0;

                for (int i = index + 1; i <= (index + nums[index] < all - 1 ? index + nums[index] : all - 1); i++) {
                    if (index + nums[i] > all - 1) {
                        count ++;
                        breakWhile = true;
                        break;
                    }
                    if (index + nums[i] == all - 1) {
                        breakWhile = true;
                        break;
                    }
                    if (nums[i] >= max) {
                        max = nums[i];
                        iOfMax = i;
                    }
                }
                if (breakWhile) {
                    break;
                }
                index = iOfMax;
                count++;
            }

            System.out.println(count);
        }


    }
}




/*
* Scanner in = new Scanner(System.in);
        int all = in.nextInt();
        if (all == 1 || all == 0) {

            return;
        }
        int[] nums = new int[all];
        for (int i = 0; i < all; i++) {
            nums[i] = in.nextInt();
        }

        int count = 0;
        int index = 0;
        while (index < all-1) {
            boolean breakWhile = false;
            count++;
            int max = 0;
            int iOfMax = 0;
            for (int i = index + 1; i <= index + nums[index];i ++) {
                if (index + nums[i] > all - 1) {
                    breakWhile = true;
                    break;
                }
                if (nums[i] >= max) {
                    max = nums[i];
                    iOfMax = i;
                }
            }
            if (breakWhile) {
                break;
            }
            index = iOfMax;
        }

        System.out.println(count);
        */


/*
* public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        char[] arr = string.toCharArray();
        int[] nums = new int[200];
        for(int i = 0; i < nums.length; i ++) {
            nums[i] = 0;
        }
        for (char c : arr) {
            nums[c] ++;
        }
        int count = arr.length;
        while (count-- > 0) {
            for (int i = 0; i < nums.length;i ++) {
                if (nums[i] != 0) {
                    System.out.print((char)i);
                    nums[i] --;
                }
            }
        }

    }
}*/
