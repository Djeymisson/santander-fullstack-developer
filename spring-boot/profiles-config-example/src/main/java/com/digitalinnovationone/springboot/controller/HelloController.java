package com.digitalinnovationone.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.message}")
    private String appMessage;

    @GetMapping("/")
    public String helloMessage() {
        return "Hello, Stranger!";
    }

    @GetMapping("/message")
    public String getAppMessage() {
        return appMessage;
    }
}
