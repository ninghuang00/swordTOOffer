package cn.hn.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by huangning on 2018/9/2.
 */
public class LongestSubstring {
    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        int l = 0;//窗口左端
        int r = 0;//窗口右端
        int maxLength = 0;//最长子串长度
        int lastMax = 0;
        Map<Character, Integer> map = new HashMap<>();//存放出现过的字符,和位置
        Integer index;//出现过的字符的位置
        char[] chars = s.toCharArray();
        while (r < chars.length) {
            index = map.put(chars[r], r);
            if (index == null) {//not contains
                maxLength = r - l + 1;
                r++;
            } else {
                lastMax = maxLength > lastMax ? maxLength : lastMax;//store the max length
                for (int i = l;i < index; i++) {
                    map.remove(chars[i]);//remove the repeat character outside of window
                }
                l = index + 1;
                r++;
            }

        }

        return maxLength > lastMax ? maxLength : lastMax;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeatingCharacters("abba"));
    }


}
