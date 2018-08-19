package com.huangning.demo;

/**
 * Created by huangning on 2018/7/24.
 */
public class Client {
    private static Client client = new Client();
    public static int a;
    public static int b = 0;

    private Client() {
        a++;
        b++;
    }

    public static Client getClient() {
        return client;
    }

    public static void main(String[] args) {
//        Client client = new Client();
        System.out.println("a=" + Client.a);
        System.out.println("b=" + Client.b);
    }


}
