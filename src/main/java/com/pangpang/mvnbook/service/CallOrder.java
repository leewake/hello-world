package com.pangpang.mvnbook.service;

/**
 * Created by leewake on 2017/7/31 0031.
 */
public class CallOrder {

    static int i = 1;

    int j = 1;

    public CallOrder() {
        System.out.println("constructor out");
    }

    static {
        System.out.println("static out");
    }

    public static void test() {
        System.out.println(i + " test out ");
    }

    public static void main(String[] args) {

        CallOrder.test();

        new CallOrder().test();

        //打印static变量时，会先触发static语句块
        System.out.println(i);
        test();
        //System.out.println(i);
        System.out.println();
        System.out.println();
        new CallOrder().test();
        System.out.println();
        CallOrder.test();
        System.out.println();
        test();
    }
}
