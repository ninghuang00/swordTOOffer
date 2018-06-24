package cn.hn.algoriththm;

/**
 * Created by huangning on 2018/6/24.
 */
public class NewCows {
    public static int howManyCows(int num, int years) {
        if (years <= 4) {
            return years * num;
        }
        return howManyCows(num, years - 1) + howManyCows(num, years - 3);

    }

    public static void main(String[] args) {
        System.out.println(howManyCows(1, 7));
    }
}
