package com.abhay.app;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class CalculatorControllerTest {

    CalculatorController calculatorController = new CalculatorController();

    @Test
    public void testCalculatorControllerAdd(){
        double a = 3.0;
        double b = 7.0;
        double expectedResult = 10.0;
        double result = calculatorController.add(a,b);
        Assert.assertEquals(expectedResult,result,0.00);
    }

    @Test
    public void testCalculatorControllerSub(){
        double a = 10.0;
        double b = 8.0;
        double expectedResult = 2.0;
        double result = calculatorController.sub(a,b);
        Assert.assertEquals(expectedResult,result,0.0);
    }

    @Test
    public void testCalculatorControllerMul(){
        double a = 10.0;
        double b = 8.0;
        double expectedResult = 80.0;
        double result = calculatorController.mul(a,b);
        Assert.assertEquals(expectedResult,result,0.0);
    }

    @Test
    public void testCalculatorControllerDiv(){
        double a = 10.0;
        double b = 5.0;
        double expectedResult = 2.0;
        double result = calculatorController.div(a,b);
        Assert.assertEquals(expectedResult,result,0.0);
    }
}
