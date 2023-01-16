package com.abhay.app;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class GreetingControllerTest {

    GreetingController greetingController = new GreetingController();


    @Test
    public void TestSayGreet(){
        String expectedResult = "Greet From App";
        String result = greetingController.SayGreet();
        Assert.assertEquals(expectedResult,result);
    }

    @Test
    public void TestSayWelcome(){
        String expectedResult = "Welcome From App";
        String result = greetingController.SayWelcome();
        Assert.assertEquals(expectedResult,result);
    }

    @Test
    public void TestSayHi(){
        String expectedResult = "Hi From App";
        String result = greetingController.SayHi();
        Assert.assertEquals(expectedResult,result);
    }


    @Test
    public void TestSayThanks(){
        String expectedResult = "Thanks From App";
        String result = greetingController.SayThanks();
        Assert.assertEquals(expectedResult,result);
    }
}
