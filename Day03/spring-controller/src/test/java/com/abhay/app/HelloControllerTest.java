package com.abhay.app;



import junit.framework.Assert;
import org.junit.jupiter.api.Test;


public class HelloControllerTest  {

    HelloController helloController = new HelloController();

    @Test
    public void testSayHello(){
        String expectedResult = "Hello From App";

        String result = helloController.SayHello();
        //Assert.assertEquals(expectedResult,result);
        Assert.assertEquals(expectedResult,result);
    }

    @Test
    public void testrequestHello(){
        String expectedResult = "Hello From Request Hello";
        String result = helloController.requestHello();
        //Assert.assertEquals(expectedResult,result);
        Assert.assertEquals(expectedResult,result);
    }

}
