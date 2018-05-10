package cn.hn.algoriththm;

import java.util.*;

/**
 * Created by huangning on 2018/3/27.
 * 消除重复元素
 */
public class RemoveDuplicate {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i :
                arr) {
            if (!set.contains(i)) {
                set.add(i);
                list.add(i);
            } else {
                for (int index = 0; index < list.size(); index++) {
                    if (list.get(index) == i) {
                        list.remove(index);
                        break;
                    }
                }
                list.add(i);
            }

        }
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + " ");

        }
        System.out.print(list.get(list.size() - 1));
    }
}


