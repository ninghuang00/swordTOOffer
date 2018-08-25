package cn.hn.algoriththm;

/**
 * Created by huangning on 2018/6/24.
 *
 * 奶牛问题
 */
public class NewCows {
    //返回year年之后的牛
    public static int howManyCows(int num, int years) {
        if (years <= 4) {
            return years * num;
        }
        //第n年的牛等于去年的牛,加上三年前的牛
        return howManyCows(num, years - 1) + howManyCows(num, years - 3);

    }

    public static void main(String[] args) {
        System.out.println(howManyCows(1, 4));
    }
}
