package com.abhay.app.ContainerTest;


import com.abhay.app.Container.CalculatorOperation;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorOperationTest {

    CalculatorOperation calculatorOperation =  new CalculatorOperation();

    @Test
    public void testCalculatorOperationAdd(){
        long a =  11L;
        long b =  10L;
        long expectedResult = 21;
        long result = calculatorOperation.addition(a,b);
        Assert.assertEquals(expectedResult,result);
    }
    @Test
    public void testCalculatorOperationSub(){
        long a = 22L;
        long b = 11L;
        long expectedResult = 11;
        long result = calculatorOperation.subtraction(a,b);
        Assert.assertEquals(expectedResult,result);
    }

    @Test
    public void testCalculatorOperationMul(){
        long a = 10L;
        long b = 11L;
        long expectedResult = 110;
        long result = calculatorOperation.multiplication(a,b);
        Assert.assertEquals(expectedResult,result);
    }
    @Test
    public void testCalculatorOperationDiv(){
        long a = 22L;
        long b = 11L;
        long expectedResult = 2;
        long result = calculatorOperation.division(a,b);
        Assert.assertEquals(expectedResult,result);
    }
}
