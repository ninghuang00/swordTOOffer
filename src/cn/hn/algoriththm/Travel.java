package cn.hn.algoriththm;

import java.util.Scanner;

/**
 * Created by huangning on 2018/3/19.
 */
public class Travel {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), L = scan.nextInt();
        int parent[] = new int[n];
        int depth[] = new int[n];
        int maxDepth = 0;
        for (int i = 1; i < n; i++) {
            parent[i] = scan.nextInt();
            depth[i] = depth[parent[i]] + 1;
            if (depth[i] > maxDepth)
                maxDepth = depth[i];
        }
        scan.close();
        int count = 0;
        if (maxDepth >= L)
            count = L;
        else
            count = (L - maxDepth) / 2 + maxDepth;
        if (count >= n - 1)
            count = n - 1;
        System.out.println(count + 1);
    }
}
