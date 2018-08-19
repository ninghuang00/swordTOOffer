package com.huangning.demo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by huangning on 2018/7/22.
 */
public class Demo {

    private static byte[] lock = new byte[0];


    public static void main(String[] args) throws InterruptedException {

    }

    Demo() {
        Mine mine = new Mine();
        mine.sayBye("","");
    }

    class Mine implements Hello, SayHi {

        @Override
        public void sayHi(String name) {
            System.out.println("hi " + name);

        }

        @Override
        public void sayBye(String name, String word) {
            System.out.println(name + word);

        }
    }

    interface SayBye{
        void sayBye(String name, String word);
    }

    interface Hello extends SayBye{
        void sayHi(String name);


    }

    interface SayHi extends SayBye{
        void sayHi(String name);

    }


}
