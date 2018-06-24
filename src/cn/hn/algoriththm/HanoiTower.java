package cn.hn.algoriththm;

/**
 * Created by huangning on 2018/6/23.
 */
public class HanoiTower {
    public static void process(int N, String from, String to, String help) {
        if (N == 1) {
            System.out.println("move " + N + " from " + from + " to " + to);
            return;
        }
        process(N - 1, from, help, to);
        System.out.println("move " + N + " from " + from + " to " + to);
        process(N - 1, help, to, from);
    }

    public static void main(String[] args) {
        process(3, "左", "中", "右");
    }
}
