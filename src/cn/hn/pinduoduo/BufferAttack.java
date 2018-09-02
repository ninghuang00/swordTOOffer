package cn.hn.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huangning on 2018/8/30.
 */
public class BufferAttack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int hp = in.nextInt();
        int normalAttack = in.nextInt();
        int bufferAttack = in.nextInt();

        int normalTimes = useNormal(hp, normalAttack);
        int bufferTimes = useBuffer(hp, bufferAttack);
        int both1 = hp / normalAttack + useBuffer(hp % normalAttack, bufferAttack);
        int both2 = hp / bufferAttack * 2 + useNormal(hp % bufferAttack, normalAttack);

        int[] arr = {normalTimes, bufferTimes, both1, both2};

        Arrays.sort(arr);

        System.out.println(arr[0]);


    }

    public static int useNormal(int hp, int normalAttack) {
        return hp%normalAttack == 0 ? hp / normalAttack : hp /normalAttack + 1;
    }

    public static int useBuffer(int hp, int bufferAttack) {
        return hp % bufferAttack == 0 ? hp / bufferAttack * 2 : (hp / bufferAttack + 1)*2;
    }
}
