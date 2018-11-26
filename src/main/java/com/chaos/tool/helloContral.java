package com.chaos.tool;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloContral {
    @RequestMapping("/hello")
    public String hell0(){
        return "hello,world!";
    }
}
