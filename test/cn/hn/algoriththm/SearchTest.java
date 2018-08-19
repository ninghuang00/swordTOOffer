package cn.hn.algoriththm;

import cn.hn.CallbackMethodImpl;
import cn.hn.utils.TestYourCode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by huangning on 2018/7/15.
 */
public class SearchTest {
    @Test
    public void bSearch() throws Exception {
        TestYourCode testYourCode = new TestYourCode(new TestCode());
        testYourCode.testReturn(new int[0], 0);

    }


    class TestCode extends CallbackMethodImpl {
        @Override
        public int yourMethodWithReturn(int[] arr, int aim) {
            return Search.bSearch(arr, aim);
        }

        @Override
        public int rightMethodWithReturn(int[] arr, int aim) {
            Arrays.sort(arr);
            for (int i = 0 ; i < arr.length;i++) {
                if (arr[i] == aim) {
                    return i;
                }
            }
            return -1;
        }
    }

}
