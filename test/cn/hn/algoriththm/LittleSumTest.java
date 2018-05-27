package cn.hn.algoriththm;

import cn.hn.utils.TestYourCode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by huangning on 2018/5/24.
 */
public class LittleSumTest {
    private LittleSum littleSum = new LittleSum();
    private TestYourCode testYourCode = new TestYourCode(littleSum);
    @Test
    public void littleSum() throws Exception {
        testYourCode.testReturn();
    }

}