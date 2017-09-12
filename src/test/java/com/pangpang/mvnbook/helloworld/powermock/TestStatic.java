package com.pangpang.mvnbook.helloworld.powermock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by leewake on 2017/8/22 0022.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(IdGenerator.class)
public class TestStatic {

    // 模拟 Static 方法
    @Test
    public void testCallInternalInstance() throws Exception {

        PowerMockito.mockStatic(IdGenerator.class);

        // 在这个测试用例中,当generateNewId()每次被调用时,都会返回15
        PowerMockito.when(IdGenerator.generate()).thenReturn(15L);
        Assert.assertEquals(15L, new ClassUnderTest().methodToTest());

        //验证generateNewId()方法是否被调用
        //之前在methodToTest()方法中只调用了一次generate()
        //所以可以验证一次
        //PowerMockito.verifyStatic();
        //IdGenerator.generate();

        //验证generateNewId()方法被调用两次
        PowerMockito.verifyStatic(Mockito.atLeast(2));
        IdGenerator.generate();

        //验证public方法调用次数，将次数改为2次，此处应该会报错
        ClassUnderTest mock = Mockito.mock(ClassUnderTest.class);
        mock.methodToTest();
        verify(mock, times(1)).methodToTest();

    }

}
