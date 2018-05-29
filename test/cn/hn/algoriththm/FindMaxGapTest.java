package cn.hn.algoriththm;

import cn.hn.utils.TestYourCode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by huangning on 2018/5/29.
 */
public class FindMaxGapTest {
    private TestYourCode testYourCode = new TestYourCode(new FindMaxGap());
    @Test
    public void findMaxGap() throws Exception {
        testYourCode.testReturn();
    }

    @Test
    public void find() throws Exception {
        FindMaxGap findMaxGap = new FindMaxGap();
        int[] arr = {4, 10, 3};
        int ret = findMaxGap.findMaxGap(arr);
        System.out.println(ret);
    }

}