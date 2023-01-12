package com.abhay.app;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    @Test
    public void SayWelcome() {
        String expectedResult = "welcome from greeting";
        Greeting greeting = new Greeting();
        String result1 = greeting.SayWelcome();
        Assert.assertEquals(expectedResult,result1);
    }

    @Test
    public void SayHello() {
        String expectedResult = "hello from greeting";
        Greeting greeting = new Greeting();
        String result2 = greeting.SayHello();
        Assert.assertEquals(expectedResult,result2);
    }

    @Test
    public void SayBye() {
        String expectedResult = "bye from greeting";
        Greeting greeting = new Greeting();
        String result3 = greeting.SayBye();
        Assert.assertEquals(expectedResult,result3);
    }

}