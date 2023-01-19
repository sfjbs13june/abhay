package com.abhay.app.Container;

import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorOperation {

    @GetMapping("/add")
    public long addition(@RequestParam("a") long a,@RequestParam("b") long b){
        return a+b;
    }
    @PostMapping("/sub")
    public long subtraction(@RequestParam("a") long a,@RequestParam("b") long b){
        return a-b;
    }

    @PutMapping("/mul")
    public long multiplication(@RequestParam("a") long a , @RequestParam("b") long b){
        return a*b;
    }

    @DeleteMapping("/div")
    public long division(@RequestParam("a") long a,@RequestParam("b") long b){
        return a/b;
    }
}
