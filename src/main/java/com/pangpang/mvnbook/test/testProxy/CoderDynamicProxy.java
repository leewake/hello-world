package com.pangpang.mvnbook.test.testProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by leewake on 2017/8/18 0018.
 */
public class CoderDynamicProxy implements InvocationHandler {

    private Coder coder;

    public CoderDynamicProxy(Coder coder) {
        this.coder = coder;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(System.currentTimeMillis());
        Object result = method.invoke(coder, args);
        System.out.println(System.currentTimeMillis());
        return result;
    }

}
