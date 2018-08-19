package cn.hn.pinduoduo;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by huangning on 2018/7/20.
 */
public class Tree {
    public static void main(String[] args) {
        int[] trees = {4, 2, 1};


    }

    public boolean isOk(int[] trees) {
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//        for (int i = 0; i < trees.length; i++) {
//            treeMap.put(trees[i], i + 1);
//        }
        Arrays.sort(trees);
        int sum = 0;
        for (int i = 0; i < trees.length; i++) {
            sum += trees[i];
        }
        int curSum = 0;
        for (int i = 0; i < trees.length; i++) {
            curSum += trees[i];
            if (2*curSum == sum  || 2*curSum + 1 == sum || 2*curSum == sum + 1) {
                return true;
            }
        }
        return false;
    }
}
