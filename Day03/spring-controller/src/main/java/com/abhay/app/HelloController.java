package com.abhay.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")

    public String SayHello(){
        return "Hello From App";
    }

    @RequestMapping("/request/hello")

    public String requestHello(){
        return "Hello From Request Hello";
    }
}
