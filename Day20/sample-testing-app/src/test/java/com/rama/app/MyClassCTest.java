package com.rama.app;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MyClassCTest {

    @InjectMocks
    MyClassC myClassC;

    @Test
    public void getAgeTest(){
        //when(myClassC.getMyAge(anyInt())).thenReturn(34);
        int age = myClassC.getMyAge(43);
        assertEquals(43,age);
    }
}
