package cn.hn.others;

/**
 * Created by huangning on 2018/4/9.
 */
public class Apple extends Fruit {

    private static Fruit fruit = new Fruit();
    String a = color();

    public Apple() {
        System.out.println("apple constructor");
    }

    String color(){
        System.out.println("color");
        return "";
    }


    public static void main(String[] args) {

        new Apple();
    }
}
