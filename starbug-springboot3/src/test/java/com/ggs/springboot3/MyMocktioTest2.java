package com.ggs.springboot3;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Random;

import static org.mockito.Mockito.*;

public class MyMocktioTest2 {

    @Mock
    private Random random;

    @Test
    public void test() {
        // 让注解生效
//        MockitoAnnotations.initMocks(this);
        MockitoAnnotations.openMocks(this);

        when(random.nextInt()).thenReturn(100);

        Assertions.assertEquals(100, random.nextInt());
    }

    @BeforeEach
    public void before() {
        // 让注解生效
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test2() {
        when(random.nextInt()).thenReturn(100);

        Assertions.assertEquals(100, random.nextInt());
    }

}
