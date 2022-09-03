package com.ggs.springboot3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoDemo4 {

    @Test
    public void test() {
        List mockList = mock(List.class);

        Assertions.assertEquals(0, mockList.size());
        Assertions.assertEquals(null, mockList.get(0));

        mockList.add("a");  // 调用 mock 对象的写方法，是没有效果的

        Assertions.assertEquals(0, mockList.size());      // 没有指定 size() 方法返回值，这里结果是默认值
        Assertions.assertEquals(null, mockList.get(0));   // 没有指定 get(0) 返回值，这里结果是默认值

        when(mockList.get(0)).thenReturn("a");          // 指定 get(0)时返回 a

        Assertions.assertEquals(0, mockList.size());        // 没有指定 size() 方法返回值，这里结果是默认值
        Assertions.assertEquals("a", mockList.get(0));      // 因为上面指定了 get(0) 返回 a，所以这里会返回 a

        Assertions.assertEquals(null, mockList.get(1));     // 没有指定 get(1) 返回值，这里结果是默认值
    }


    @Mock
    private List<String> mockStringList1;

    @BeforeEach
    public void before1() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test2() {
        mockStringList1.add("a");

//        when(mockStringList1.get(eq(0))).thenReturn("a");
//        when(mockStringList1.get(1)).thenReturn("b");
        when(mockStringList1.get(anyInt())).thenReturn("a");

        Assertions.assertEquals("a", mockStringList1.get(0));
        Assertions.assertEquals("b", mockStringList1.get(1));
    }

}
