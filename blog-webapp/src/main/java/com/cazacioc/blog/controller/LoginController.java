package com.cazacioc.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping
    public String hello(ModelMap model) {
        return "login";
    }
}
