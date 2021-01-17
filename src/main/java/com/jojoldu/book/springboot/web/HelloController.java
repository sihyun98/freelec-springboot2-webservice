package com.jojoldu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "환영합니다";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
