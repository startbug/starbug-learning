package com.ggs.springboot3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class MocktioTest3 {

    @Test
    public void test() {
        ArrayList<String> mockList = mock(ArrayList.class);

        when(mockList.get(0)).thenReturn("starbug");

        Assertions.assertEquals(7, mockList.get(0).length());
    }

    @Mock
    private ArrayList<String> mockList;

    @Test
    public void test2() {
        MockitoAnnotations.openMocks(this);

        when(mockList.get(0)).thenReturn("abc");

        Assertions.assertEquals(4, mockList.get(0).length());
    }

}
