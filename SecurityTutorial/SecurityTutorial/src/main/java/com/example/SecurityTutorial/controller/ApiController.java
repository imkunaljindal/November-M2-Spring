package com.example.SecurityTutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ApiController {

    @GetMapping("/home")
    public String home() {
        return "Welcome to HOME page";
    }

    @GetMapping("/student")
    public String student() {
        return "Welcome to STUDENT page";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Welcome to ADMIN page";
    }
}
