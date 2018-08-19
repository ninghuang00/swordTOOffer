package cn.hn.pinduoduo;

import sun.tools.java.ClassType;

import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huangning on 2018/7/20.
 */
public class Demo extends Fa{

    ReentrantLock lock = new ReentrantLock();

    private void say() {
        System.out.println("hello");

    }

    public static void main(String[] args) {

        try {
            Class clazz = Class.forName("cn.hn.pinduoduo.Demo");


            Method method = Demo.class.getDeclaredMethod("say");
            method.invoke(clazz.newInstance());


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    public void inc() throws InterruptedException {
        lock.lockInterruptibly();

    }

}
