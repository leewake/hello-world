package com.pangpang.mvnbook.helloworld.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * Created by leewake on 2017/8/23 0023.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(PrivatePartialMockingExample.class)
public class PrivatePartialMockingExampleTest {

    @Test
    public void demoPrivateMethodMocking() throws Exception {

        final String expected = "TEST VALUE";
        //final String unexpected = "UNEXPECTED VALUE";
        final String nameOfMethodToMock = "methodToMock";
        final String input = "input";

        PrivatePartialMockingExample underTest = spy(new PrivatePartialMockingExample());

        when(underTest, nameOfMethodToMock, input).thenReturn(expected);

        assertEquals(expected, underTest.methodToTest());

        //assertEquals(unexpected, underTest.methodToTest());

        verifyPrivate(underTest).invoke(nameOfMethodToMock, input);

        verify(underTest, times(1)).methodToTest();

        //验证private方法被调用次数
        verifyPrivate(underTest, times(1));
        underTest.methodToTest();

    }

}
