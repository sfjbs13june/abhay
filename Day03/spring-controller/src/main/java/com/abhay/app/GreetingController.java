package com.abhay.app;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greet")
    public String SayGreet(){
        return "Greet From App";
    }

    @GetMapping("/welcome")
    public String SayWelcome(){
        return "Welcome From App";
    }

    @RequestMapping("/hi")
    public String SayHi(){
        return "Hi From App";
    }

    @RequestMapping("/thanks")
    public String SayThanks(){
        return "Thanks From App";
    }

}
