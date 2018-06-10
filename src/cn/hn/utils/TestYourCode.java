package cn.hn.utils;

import cn.hn.CallbackMethod;
import cn.hn.others.Main;

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
    private static final int SIZE = 100;
    private static final int VALUE = 100;
    private static final int TEST_TIMES = 500;
    private long count = 0;

    public TestYourCode(CallbackMethod callbackMethod) {
        this.callbackMethod = callbackMethod;
    }

    public void testArr() {
        boolean succeed = true;
        for (int i = 0;i < TEST_TIMES;i++) {
            count ++;
            int[] originArr = ArrayUtils.generateRandomArray(SIZE, VALUE);
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
        System.out.println(succeed ? "Nice! " + TEST_TIMES + " testcase passed" : "What's the fuck, testcase " + count + " failed!");

    }

    public void testReturn() {
        boolean succeed = true;
        int yourReturn;
        int rightReturn;
        for (int i = 0;i < TEST_TIMES;i++) {
            int[] originArr = ArrayUtils.generateRandomArray(SIZE, VALUE);
            if (originArr.length == 0) {
                continue;
            }
            int[] arrForYourMethod = copyArray(originArr);
            int[] arrForRightMethod = copyArray(originArr);


            yourReturn = yourMethodWithReturn(arrForYourMethod);
            rightReturn = rightMethodWithReturn(arrForRightMethod);
            if (yourReturn != rightReturn) {
                succeed = false;
                System.out.println("your return is " + yourReturn);
                System.out.println("right return is " + rightReturn);
                PrintUtil.printIntArray(originArr);
                break;
            }
        }
        System.out.println(succeed ? "Nice! " + TEST_TIMES + " testcase passed" : "What's the fuck, testcase " + count + " failed!");
    }


    public void testNodeReturn() {

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


    //返回数组拷贝
    public int[] copyArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

}
