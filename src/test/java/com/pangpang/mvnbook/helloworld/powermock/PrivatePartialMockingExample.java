package com.pangpang.mvnbook.helloworld.powermock;

/**
 * Created by leewake on 2017/8/23 0023.
 */
public class PrivatePartialMockingExample {

    public String methodToTest(){
        return methodToMock("input");
    }

    private String methodToMock(String input){
        return "REAL VALUE " + input;
    }

}
