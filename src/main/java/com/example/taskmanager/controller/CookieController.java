package com.example.taskmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {

    @RequestMapping("/cookie")
    public String cookiePage() {
        return "cookie";
    }
}

