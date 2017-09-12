package com.pangpang.mvnbook.helloworld.powermock;

/**
 * Created by leewake on 2017/8/22 0022.
 */
public class ClassUnderTest {

    public long methodToTest() {
        final long id = IdGenerator.generate();
        IdGenerator.generate();
        return id;
    }

}
