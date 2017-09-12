package com.pangpang.mvnbook.test;

/**
 * Created by leewake on 2017/8/1 0001.
 */
public class Son extends Father {

    public Son() {
        System.out.println("子类构造器");
    }

    /*static {
        System.out.println("子类静态代码块");
    }*/

    private String string;
    public Son(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "Son{" +
                "string='" + string + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Son son = new Son("pang");
        System.out.println(son.toString());
    }
}
