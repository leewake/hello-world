package com.pangpang.mvnbook.test.testProxy;

/**
 * Created by leewake on 2017/8/18 0018.
 */
public class CoderProxy implements Coder {

    private Coder coder;

    public CoderProxy(Coder coder) {
        this.coder = coder;
    }

    @Override
    public void code() {
        coder.code();
    }
}
