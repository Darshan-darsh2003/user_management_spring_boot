package com.darshan.usermanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping("/")
    public String greet() {
        return "Hello! Welcome to the User Management Application.";
    }
}
