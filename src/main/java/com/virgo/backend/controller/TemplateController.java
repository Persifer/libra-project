package com.virgo.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    public String redirectToLogin(){
        return "login"; // deve avere lo stesso nome del file html che abbiamo in templates

    }
}
