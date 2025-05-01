package com.example.animalpictureapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "Hello, the server is working! Please navigate to localhost:8081/animalapp";
    }
}