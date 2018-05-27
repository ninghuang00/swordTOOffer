package cn.hn.algoriththm;

import cn.hn.utils.ArrayUtils;
import cn.hn.utils.PrintUtil;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by huangning on 2018/5/27.
 */
public class HollandNationFlagTest {
    private HollandNationFlag hollandNationFlag = new HollandNationFlag();
    @Test
    public void hollandFlag() throws Exception {
        int size = 16;
        int value = 20;
        int[] arr = ArrayUtils.generateRandomArray(size, value);
        PrintUtil.printIntArray(arr);
        int pivot = (int) (Math.random()*20);
        System.out.println(pivot);
        hollandNationFlag.hollandFlag(arr, pivot);
        PrintUtil.printIntArray(arr);
    }

}