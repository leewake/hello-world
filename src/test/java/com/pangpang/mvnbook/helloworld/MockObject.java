package com.pangpang.mvnbook.helloworld;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mockito;
import java.util.LinkedList;
import java.util.List;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;


/**
 * Created by leewake on 2017/7/10
 */

public class MockObject {
    @Test
    public void MockTest(){
        List list = mock(List.class);

        when(list.get(0)).thenReturn("hello World");

        System.out.println(list.get(0));

        System.out.println(list.size());

    }

    @Test
    public void spyTest(){
        List list = new LinkedList();
        List spy = Mockito.spy(list);
        when(spy.size()).thenReturn(100);
        spy.add("one");
        spy.add("two");
        System.out.println(spy.get(0));
        System.out.println(spy.size());
        verify(spy).add("one");
        verify(spy).add("two");
    }

    @Test
    public void behaviorCheck() {
        List mock1 = mock(List.class);
        List mock2 = mock(List.class);

        /* 设置预期 */
        when(mock1.get(0)).thenReturn("hello world");
        when(mock1.get(1)).thenReturn("hello world");
        when(mock2.get(0)).thenReturn("hello world");
        mock1.get(0);

        /* 验证方法调用一次 */
        verify(mock1).get(0);
        mock1.get(0);
        /* 验证方法调用两次 */
        verify(mock1, times(2)).get(0);
        mock2.get(0);
        /* 验证方法从未被调用过 */
        verify(mock2, times(1)).get(0);
        /* 验证方法 100 毫秒内调用两次 */
        verify(mock1, timeout(100).times(2)).get(anyInt());

        /* 设置方法调用顺序 */
        InOrder inOrder = inOrder(mock1, mock2);
        inOrder.verify(mock1, times(2)).get(0);
        inOrder.verify(mock2, never()).get(1);

        /*  查询是否存在被调用，但未被 verify 验证的方法 */
        verifyNoMoreInteractions(mock1, mock2);
        /* 验证 Mock 对象是否没有交发生 */
        verifyZeroInteractions(mock1, mock2);

        /* 参数捕获器 */
        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(mock1, times(2)).get(argumentCaptor.capture());
        System.out.println("argument:" + argumentCaptor.getValue());
    }
}
