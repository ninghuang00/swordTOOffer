package cn.hn.others;

import cn.hn.CallbackMethodImpl;
import cn.hn.utils.TestYourCode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by huangning on 2018/7/15.
 */
public class HeapSortTest {
    class TestSort extends CallbackMethodImpl {

        @Override
        public void yourMethod(int[] arr) {
            Arrays.sort(arr);
        }

        @Override
        public void rightMethod(int[] arr) {
            HeapSort.heapSort(arr);
        }
    }

    @Test
    public void heapSort() throws Exception {

        TestYourCode testYourCode = new TestYourCode(new TestSort());
        testYourCode.testArr(new int[0]);
    }

}