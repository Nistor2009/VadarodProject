package com.example.VadarodProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {
    @GetMapping("hello")
    public String hello(){
        return "Hello";
    }
}
