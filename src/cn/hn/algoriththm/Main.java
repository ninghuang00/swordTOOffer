package cn.hn.algoriththm;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] leftDownX = new int[n];
        int[] leftDownY = new int[n];
        int[] rightUpX = new int[n];
        int[] rightUpY = new int[n];
        for (int i = 0; i < n;i++) {
            leftDownX[i] = in.nextInt();
        }
        for (int i = 0; i < n;i++) {
            leftDownY[i] = in.nextInt();
        }
        for (int i = 0; i < n;i++) {
            rightUpX[i] = in.nextInt();
        }
        for (int i = 0; i < n;i++) {
            rightUpY[i] = in.nextInt();
        }

        //List<Point> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0;i < n;i++) {
            int ldx = leftDownX[i];
            int ldy = leftDownY[i];
            int rux = rightUpX[i];
            int ruy = rightUpY[i];

            for (int j = ldx + 1;j <rux;j++) {
                for (int k = ldy + 1;k<ruy;k++) {
                    String key = "" + j + k;
                    if (map.containsKey(key)) {
                        int count = map.get(key);
                        map.put(key, count + 1);
                    } else {
                        map.put(key, 1);
                    }
                }

            }

        }


        int max = 0;
        for (String s :
                map.keySet()) {
            if (map.get(s) > max) {
                max = map.get(s);
            }
        }

        System.out.println(max);

    }


}
