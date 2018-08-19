package cn.hn.netease;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by huangning on 2018/8/11.
 */
public class FindApple {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, AppleHeap> map = new HashMap<>();

        int numOfHeap = in.nextInt();
        int sum = 0;
        int numOfThisHeap;
        for(int i = 1 ; i <= numOfHeap; i++) {
            numOfThisHeap = in.nextInt();
            map.put(i, new AppleHeap(sum + 1, sum + numOfThisHeap));
            sum += numOfThisHeap;
        }

        int numOfAsk = in.nextInt();
        int appleNum ;
        for (int i = 0; i< numOfAsk; i++) {
            appleNum = in.nextInt();
            System.out.println(find(appleNum, map));

        }
    }


    public static int find(int aim, Map<Integer, AppleHeap> map) {
        int left = 1;
        int right = map.size();
        int mid = (left + right) / 2;
        while (left <= right) {
            if (map.get(mid).isIn(aim) == 1) {
                left = mid + 1;
            } else if (map.get(mid).isIn(aim) == -1) {
                right = mid - 1;
            } else {
                return mid;
            }
            mid = (left + right) / 2;
        }
        return -1;

    }

}

class AppleHeap{
    int min;
    int max;

    public AppleHeap(int l, int r) {
        this.max = r;
        this.min = l;
    }

    public int isIn(int num) {
        if (num > max) {
            return 1;
        } else if (num < min) {
            return -1;
        }
        return 0;
    }
}
