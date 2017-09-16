package com.huangning.demo;

/**
 * Created by huangning on 2017/9/14.
 */
public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args){
        Person p1 = new Person();
        p1.setName("ninghuang");
        changeName(p1);
        System.out.println(p1.getName());
    }

    private static void changeName(Person person) {
        person.setName("huangning");
    }
}
