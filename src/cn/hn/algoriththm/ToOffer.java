package cn.hn.algoriththm;

import cn.hn.utils.Log;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by huangning on 2017/9/8.
 */
public class ToOffer {

    /*
    合并数组
    将排序数组a1和a2合并,要求合并之后还是有序的
     */
    public int[] mergeNums(int[] a1, int[] a2) {
        int[] ret = new int[a1.length + a2.length];
        int indexOfRet = ret.length;
        int indexOfa1 = a1.length - 1;
        int indexOfa2 = a2.length - 1;
        while (indexOfa1 >= 0 && indexOfa2 >= 0) {
            if (a1[indexOfa1] <= a2[indexOfa2]) {
                ret[--indexOfRet] = a2[indexOfa2--];
            } else {
                ret[--indexOfRet] = a1[indexOfa1--];
            }
        }
        while (indexOfa1 >= 0) {
            ret[--indexOfRet] = a1[indexOfa1--];
        }
        while (indexOfa2 >= 0) {
            ret[--indexOfRet] = a2[indexOfa1--];
        }

        return ret;
    }

    /*
    替换字符串中的空格
     */
    public String replaceBlank(String string, String replacement) {
        char[] origin = string.toCharArray();
        char[] rep = replacement.toCharArray();
        int length = replacement.length();
        int count = 0;
        for (char c : origin) {
            if (c == ' ') {
                count++;
            }
        }
        char[] result = new char[origin.length + count * (length - 1)];
        int indexOfResult = result.length - 1;
        int indexOfOrigin = origin.length - 1;
        while (indexOfOrigin >= 0 && indexOfResult >= 0) { //&& indexOfResult > indexOfOrigin) {
            if (origin[indexOfOrigin] == ' ') {
                for (int i = rep.length - 1; i >= 0; i--) {
                    result[indexOfResult--] = rep[i];
                }


            } else {
                result[indexOfResult--] = origin[indexOfOrigin];
            }
            --indexOfOrigin;
        }

        return new String(result);
    }

    /*
    在二维数组中查找数字是否存在，二维数组横向纵向递增。
    时间复杂度O(n)
     */
    public boolean findNum(int[][] nums, int num) {
        if (nums == null) {
            return false;
        }
        //坐标从右上角开始
        int rows = 0;
        int cols = nums[0].length - 1;
        //当横坐标大于等于0，纵坐标小于总的行数
        while (rows < nums.length && cols >= 0) {
            if (nums[rows][cols] == num) {    //若果找到数字则返回
                return true;
            }
            if (nums[rows][cols] > num) { //如果右上角的数字大于要找的数字，说明该列的数字都大于要找的数，可以直接剔除该列
                --cols;
            } else {  //否则说明这一行的数字都小于要找的数字，剔除该行
                ++rows;
            }
        }
        return false;

    }


    /*
    查找字符串中第一个只出现一次的字符
    时间复杂度O(n)
     */
    public Character firstNotRepeatingChar(String string) {
        if (string == null) {
            return null;
        }

        char[] chars = string.toCharArray();    //先将字符串转成字符数组
        Map<Character, Integer> map = new HashMap<>();   //key为字符，value是字符出现的次数
        for (char c : chars) {
            if (map.containsKey(c)) { //如果map中已经存在字符
                int i = map.get(c) + 1; //取出字符对应的value并加1
                map.replace(c, i); //替换原来的value
            } else {
                map.put(c, 1);   //map中没有则将value置为1
            }
        }
        for (char c : chars) {
            if (map.get(c) == 1) //遍历字符数组，在map中对应的value值大于1的就是重复的字符
                return c;
        }

        return null;
    }

    /*
    查找字符串中第一个只出现一次的字符，
    使用自制hash表,意思就是将每个字符映射成一个数字，字符作为下标，值作为出现的次数
    空间复杂度:O(1)
    时间复杂度:O(n)
     */
    public Character firstNotRepeatingChar2(String string) {
        if (string == null) return null;
        char[] chars = string.toCharArray();
        int[] hashtable = new int[256]; //因char是8位，最多有256种可能
        for (char c : chars) {  //
            hashtable[c]++;
        }
        for (char c : chars) {
            if (hashtable[c] == 1) return c;
        }

        return null;
    }

    /*
    数组中重复的数字,数组长度为n，数字范围是0~n-1
    使用额外的空间版
     */
    public Integer duplicateNUm(int[] nums) {
        if (nums == null) return null;
        int[] hashtable = new int[nums.length];
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = 0;
        }

        for (int i : nums) {
            hashtable[i]++;
        }

        for (int i : nums) {
            if (hashtable[i] > 1) return i;
        }

        return null;
    }

    /*
    数组中重复的数字,数组长度为n，数字范围是0~n-1
    不适用额外的空间
     */
    public Integer duplicateNUm2(int[] nums) {
        if (nums == null) return null;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums.length - 1 || nums[i] < 0) {
                Log.loggerInfo("数组中有数字超过给定范围");
                return null;
            }
        }
        for (int i = 0; i < nums.length; i++) {  //从第一位开始遍历数组
            while (i != nums[i]) {    //当下标i不等于该位置上的数字nums[i]
                if (nums[i] == nums[nums[i]]) {   //如果下标i上的数字nums[i]，和以下标上的数字nums[i]为下标的数字nums[nums[i]]相等，说明nums[i]重复
                    return nums[i];
                }
                //否则交换下标i和下标nums[i]上的数字
                int temp = nums[nums[i]];  //先把下标nums[i]上的数字给temp比较直观
                nums[nums[i]] = nums[i];
                nums[i] = temp;

            }
        }
        return null;
    }

    /*
    查找数组中任意一个重复的数字，数组长度为n+1，数组元素范围1~n,可见至少有一个数字重复
    要求不修改原来的数组
     */
    public Integer duplicateNUm3(int[] nums) {
        if (nums == null) {
            Log.loggerInfo("the array is null");
            return null;
        }
        for (int n : nums) {
            if (n < 1 || n > nums.length) {
                Log.loggerInfo("there is a number out of range in the array");
                return null;
            }
        }
        int start = 1;  //数组中数字的最小范围
        int end = nums.length - 1;  //数组中数字的最大范围
        while (end >= start) {  //当取值范围没有相遇时
            int mid = ((end - start) >> 1) + start; //取数字范围中间的数作为分界线
            int count = countRange(nums, start, mid);   //遍历数组，得到前半部分范围的数字在数组中出现的次数
            if (end == start) { //当最后范围只有两个数的时候
                if (count > 1) {    //如果统计次数大于1，
                    return start;   //返回
                } else {
                    Log.loggerInfo("not found duplicate number");
                    break;
                }
            }
            if (count > mid - start + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return null;
    }

    /*
    统计某个范围的数字在数组中一共出现几次
     */
    public int countRange(int[] nums, int start, int end) {
        if (nums == null) {
            return 0;
        }
        int count = 0;
        for (int n : nums) {
            if (n >= start && n <= end) {
                ++count;
            }
        }
        return count;
    }


}
