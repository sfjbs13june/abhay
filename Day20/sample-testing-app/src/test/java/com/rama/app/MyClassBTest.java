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
public class MyClassBTest {
    @InjectMocks
    MyclassB myclassB;


    @Mock
    MyClassC myClassC;

    @BeforeEach
    void setUp(){
        myClassC = Mockito.mock(MyClassC.class);
    }

    @Test
    public void getResultTest(){
        String result = myclassB.getResult();
        assertEquals("my result",result);
    }

    @Test
    public void getMyStringTest(){
        //when(myclassB.getMyString(anyString())).thenReturn("my result my data");
        String result = myclassB.getMyString("my data");
        assertEquals("my result my data",result);
    }

    @Test
    public void getClassCResultTest(){
        when(myClassC.getMyAge(anyInt())).thenReturn(45);
        int age = myclassB.getClassCRestult(myClassC);
        assertEquals(45,age);
    }


    @Test
    public void noreturnDataTst(){
        myclassB.NoreturnData("my data");
        String result = "my data";
        assertEquals("my data" , result);

    }
}
