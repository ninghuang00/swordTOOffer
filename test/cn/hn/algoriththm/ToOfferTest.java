package cn.hn.algoriththm;

import cn.hn.utils.Log;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by huangning on 2017/9/8.
 */
public class ToOfferTest {
    ToOffer to = new ToOffer();

    @Test
    public void mergeNums() throws Exception {
        int[] a1 = {1,3,4,5,7,8};
        int[] a2 = {1,2,2,3,5,5,9,11};
        int ret[] = to.mergeNums(a1,a2);
        System.out.println(Arrays.toString(ret));
    }

    @Test
    public void replaceBlank() throws Exception {
        String string = "hello world.";
        String newstring = to.replaceBlank(string,"$$");
        Log.loggerInfo("new string is " + newstring);

    }

    @Test
    public void findNum() throws Exception {
        int nums[][] = {
            {1,2,8,9},
            {2,4,9,12},
            {4,7,10,13},
            {6,8,11,15}
        };
        int num[] = {7,1,15,14};
        for(int i:num){
            Log.loggerInfo("result is " + to.findNum(nums,i));
        }
    }
    @Test
    public void modifyString(){

    }


    @Test
    public void duplicateNUm3() throws Exception {
        int nums[] = {2,3,5, 4, 3, 2, 6, 7};
        String result = to.duplicateNUm3(nums).toString();
        Log.loggerInfo(result);
    }

    @Test
    public void firstNotRepeatingChar() throws Exception {
        String s = "zabnmjshadzb";
        Log.loggerInfo(to.firstNotRepeatingChar(s).toString());


    }

    @Test
    public void firstNoRepeatingChar2() throws Exception {
        String s = "a=hfalhf;afd220-";
        System.out.println(to.firstNotRepeatingChar(s));
    }

    @Test
    public void duplicateNUm2() throws Exception {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(to.duplicateNUm2(nums));

    }

    @Test
    public void duplicateNUm() throws Exception {
        int[] nums = {0, 3, 1, 2, 2, 5, 4};
        System.out.println(to.duplicateNUm(nums));
    }
}