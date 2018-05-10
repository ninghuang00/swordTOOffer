package cn.hn.algoriththm;

/**
 * Created by huangning on 2018/4/7.
 */
/*
 * title:最大差值
 * explanation:	给定一个数组,求排序之后的相邻两个数字之间的差值的最大值,要求时间复杂度O(N):
	思路:由于时间复杂度要求,所以不能用普通的排序,可以使用桶排序
		1. 按照数组中最大值和最小值的差值确定每个桶的存放数字范围,`index = (int)((num - min) * len / (max - min))`确定一个数应该放在哪里
		2. 每个同种只存放这个桶的最大值最小值以及同种是否有数
		3. 遍历桶,求当前桶的最小值和上一个非空桶的最大值的差值,(前提是有非空桶,不然每个桶中最大最小的差值也要加入比较)

 * tip:
 * example:
 * param:
 * return:
 */
public class MaxGap {
    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len;i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }

        if (max == min) {
            return 0;
        }
        //数组长度设置为len+1的目的就是为了保证出现空桶
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        boolean[] hasNum = new boolean[len + 1];
        for (int i = 0; i < len; i++) {
            //判断当前的数字应该放到哪个桶
            int index = getIndex(len,max,min,nums[i]);
            maxs[index] = hasNum[index] ? Math.max(maxs[index], nums[i]) : nums[i];
            mins[index] = hasNum[index] ? Math.min(mins[index], nums[i]) : nums[i];
            hasNum[index] = true;
        }

        int res = 0;
        int lastMax = maxs[0];
        for(int i = 1; i < len + 1; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }

        return res;
    }

    private static int getIndex(int len, int max, int min, int num) {
        return (int) ((num - min) * len / (max - min));
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 9, 5, 6};
        System.out.println(maxGap(nums));
    }
}
