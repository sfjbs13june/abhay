package com.abhay.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Greeting greeting = new Greeting();
        String result1= greeting.SayWelcome();
        System.out.println(result1);

        String result2 = greeting.SayHello();
        System.out.println(result2);

        String result3 = greeting.SayBye();
        System.out.println(result3);

    }
}
