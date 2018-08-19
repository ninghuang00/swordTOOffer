package cn.hn.netease;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by huangning on 2018/7/31.
 * 还是有问题
 * 网易 牛牛找工作
 */
public class FindWork {
    public static void findWork() {
        Scanner in = new Scanner(System.in);
        int workNum = in.nextInt();
        int peopleNum = in.nextInt();

//        System.out.println(workNum);
//        System.out.println(peopleNum);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int level;
        int money;
        Map.Entry<Integer,Integer> entry;
        for (int i = 0; i < workNum; i ++) {
            level = in.nextInt();
            money = in.nextInt();
            //找到距离level最近的两个位置比较一下money
            //1. level存在则判断money大小,不存在直接插入
            map.merge(level, money, (value, newValue) -> value > newValue ? value : newValue);
//            if (map.get(level) != null) {
//                map.put(level, money > map.get(level) ? money : map.get(level));
//            } else {
//                map.put(level, money);
//            }
            if ((entry = map.higherEntry(level)) != null) {
                map.put(entry.getKey(), money > entry.getValue() ? money : entry.getValue());
            }
            if ((entry = map.lowerEntry(level)) != null) {
                map.put(level, money > entry.getValue() ? money : entry.getValue());
            }

        }

        int[] peopleAbility = new int[peopleNum];
        for (int i = 0; i < peopleNum; i++) {
            peopleAbility[i] = in.nextInt();
            peopleAbility[i] = map.floorEntry(peopleAbility[i]).getValue();
        }

        for (int i = 0; i < peopleNum; i++) {
            System.out.println(peopleAbility[i]);
        }

    }


    public static void main(String[] args) {
        findWork();
    }
}
