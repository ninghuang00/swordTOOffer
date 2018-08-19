package cn.hn.utils;

import cn.hn.CallbackMethod;

import java.util.Arrays;

/**
 * Created by huangning on 2018/3/28.
 */
/*
 * title:比较器
 * explanation:用来产生随机数组作为测试用例,来比较确定正确的方法和自己写的方法,找出错误的用例
 * tip:
 * example:
 * param:
 * return:
 */
public class TestYourCode implements CallbackMethod {
    CallbackMethod callbackMethod;
    private int size = 10;
    private int value = 100;
    private int testTimes = 500;
    private long count = 0;

    public TestYourCode(CallbackMethod callbackMethod) {
        this.callbackMethod = callbackMethod;
    }

    public void setRandomArrayConfig(int arraySize, int maxValue, int testTimes) {
        this.testTimes = testTimes;
        this.value = maxValue;
        this.size = arraySize;
    }

    public void testArr(int[] nothing) {
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            count ++;
            int[] originArr = ArrayUtils.generateRandomArray(size, value);
            if (originArr.length == 0) {
                continue;
            }
            int[] arrForYourMethod = copyArray(originArr);
            int[] arrForRightMethod = copyArray(originArr);


            yourMethod(arrForYourMethod);
            rightMethod(arrForRightMethod);
            if (!Arrays.equals(arrForRightMethod, arrForYourMethod)) {
                succeed = false;
                PrintUtil.printIntArray(originArr);
                break;
            }
        }
        printRes(succeed);

    }

    private void printRes(boolean succeed) {
        System.out.println(succeed ? "Nice! " + testTimes + " testcase passed" : "What's the fuck, testcase " + count + " failed!");
    }

    public void testReturn(int[] nothing) {
        boolean succeed = true;
        int yourReturn;
        int rightReturn;
        for (int i = 0; i < testTimes; i++) {
            int[] originArr = ArrayUtils.generateRandomArray(size, value);
            if (originArr.length == 0) {
                continue;
            }
            count++;
            int[] arrForYourMethod = copyArray(originArr);
            int[] arrForRightMethod = copyArray(originArr);


            yourReturn = yourMethodWithReturn(arrForYourMethod);
            rightReturn = rightMethodWithReturn(arrForRightMethod);
            if (yourReturn != rightReturn) {
                succeed = false;
                printWrongMsg(yourReturn,rightReturn,originArr);
                break;
            }
        }
        printRes(succeed);
    }

    public void testReturn(int[] nothing,int no) {
        boolean succeed = true;
        int yourReturn;
        int rightReturn;
        for (int i = 0; i < testTimes; i++) {
            int[] originArr = ArrayUtils.generateRandomArray(size, value);
            if (originArr.length == 0) {
                continue;
            }
            count++;
            int aim = ArrayUtils.getRandomInt(value);

            int[] arrForYourMethod = copyArray(originArr);
            int[] arrForRightMethod = copyArray(originArr);

            yourReturn = yourMethodWithReturn(arrForYourMethod,aim);
            rightReturn = rightMethodWithReturn(arrForRightMethod,aim);
            if (yourReturn != rightReturn) {
                succeed = false;
                printWrongMsg(yourReturn,rightReturn,originArr);
                System.out.println("aim is " + aim);
                break;
            }
        }
        printRes(succeed);
    }

    private void printWrongMsg(int yourReturn,int rightReturn, int[] originArr) {
        System.out.println("your return is " + yourReturn);
        System.out.println("right return is " + rightReturn);
        PrintUtil.printIntArray(originArr);
    }


    public void testNodeReturn(int[] nothing, int no) {

    }

    public void yourMethod(int[] arr) {
//        sortInt(arr);
        callbackMethod.yourMethod(arr);
    }
    //准备一个绝对正确但是实现简单的方法
    public void rightMethod(int[] arr) {
//        Arrays.sort(arr);
        callbackMethod.rightMethod(arr);
    }

    @Override
    public int yourMethodWithReturn(int[] arr) {
        return callbackMethod.yourMethodWithReturn(arr);
    }

    @Override
    public int rightMethodWithReturn(int[] arr) {
        return callbackMethod.rightMethodWithReturn(arr);
    }

    @Override
    public int yourMethodWithReturn(int[] arr, int aim) {
        return callbackMethod.yourMethodWithReturn(arr, aim);
    }

    @Override
    public int rightMethodWithReturn(int[] arr, int aim) {
        return callbackMethod.rightMethodWithReturn(arr, aim);
    }

    //返回数组拷贝
    public int[] copyArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

}
