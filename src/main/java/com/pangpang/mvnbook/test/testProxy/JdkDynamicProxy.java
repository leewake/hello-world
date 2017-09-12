package com.pangpang.mvnbook.test.testProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by leewake on 2017/8/18 0018.
 */
public class JdkDynamicProxy {

    public static void main(String[] args) {

//        System.out.println(JdkDynamicProxy.class.getClassLoader());
//        System.out.println(JdkDynamicProxy.class.getClassLoader().getParent());
//        System.out.println(JdkDynamicProxy.class.getClassLoader().getParent().getParent());
//        System.out.println(System.getProperty("sun.boot.class.path"));

        Coder coder = new Icoder();

        InvocationHandler handler = new CoderDynamicProxy(coder);

        Coder coderProxy = (Coder) Proxy.newProxyInstance(coder.getClass().getClassLoader(), coder.getClass().getInterfaces(), handler);

        coderProxy.code();

    }
}
