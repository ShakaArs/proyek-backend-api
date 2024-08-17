package com.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {
    @GetMapping
    public String welcome() {
        return "(GET) Welcome to the Spring bootAPI!";
    }

    // @PostMapping
    // public String welcomePost() {
    //     return "(POST) Welcome to the Spring bootAPI!";
    // }
}
