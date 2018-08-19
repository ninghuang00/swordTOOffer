package cn.hn.pinduoduo;

/**
 * Created by huangning on 2018/7/20.
 * 拼多多 复制可乐
 */
public class Cola {
    public static void main(String[] args) {
        for (int i = 1; i <= 16; i++) {
            printName(i);
        }



       // System.out.println(count);


    }

    public static void printName(int num) {

        int count = 0;
        while (Math.pow(2, count + 2) - 4 < num) {
            count++;

        }

        int delta = num - (int)Math.pow(2,count + 1) + 4;
        //  System.out.println(delta);
        if (delta <= (int) Math.pow(2, count - 1)) {
            System.out.println("Alice");
        }else if (delta <= (int) Math.pow(2, count)) {
            System.out.println("Bob");
        }else if (delta <= (int) Math.pow(2, count - 1) * 3) {
            System.out.println("Cathy");
        }else {
            System.out.println("Dave");
        }
    }

}


/*import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}*/