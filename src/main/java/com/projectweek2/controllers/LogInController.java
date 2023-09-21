package com.projectweek2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "login.html";
    }
    
}
