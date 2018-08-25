package cn.hn.basic;

/**
 * Created by huangning on 2018/8/25.
 * 给定一个数组,按一个aim,判断使用数组中的数字能否累加出aim
 */
public class IsSum {
    public boolean isSum(int[] arr, int aim, int index, int sum) {
        if (index == arr.length) {
            return aim == sum;
        }
        //选择加上当前值或者不加
        return isSum(arr, aim, index + 1, sum + 0) || isSum(arr, aim, index + 1, sum + arr[index]);
    }
}
