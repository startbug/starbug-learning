package com.ggs.springboot3;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.mockito.Mockito.*;

public class MyMocktioTest {

    @Test
    public void test() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt()).thenReturn(100);

        Assert.assertEquals(100, mockRandom.nextInt());
        Assert.assertEquals(100, mockRandom.nextInt());
    }


    @Test
    public void test2() {
        Random mockRandom = mock(Random.class);
        System.out.println(mockRandom.nextBoolean());
        System.out.println(mockRandom.nextInt());
        System.out.println(mockRandom.nextFloat());
    }

    @Test
    public void test3() {
        List mockList = mock(List.class);

        Assert.assertEquals(0, mockList.size());
        Assert.assertEquals(null, mockList.get(0));

        mockList.add("a");  // 调用 mock 对象的写方法，是没有效果的

        Assert.assertEquals(0, mockList.size());      // 没有指定 size() 方法返回值，这里结果是默认值
        Assert.assertEquals(null, mockList.get(0));   // 没有指定 get(0) 返回值，这里结果是默认值

        when(mockList.get(0)).thenReturn("a");          // 指定 get(0)时返回 a

        Assert.assertEquals(0, mockList.size());        // 没有指定 size() 方法返回值，这里结果是默认值
        Assert.assertEquals("a", mockList.get(0));      // 因为上面指定了 get(0) 返回 a，所以这里会返回 a

        Assert.assertEquals(null, mockList.get(1));     // 没有指定 get(1) 返回值，这里结果是默认值
    }

}
