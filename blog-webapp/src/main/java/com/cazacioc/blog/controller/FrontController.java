package com.cazacioc.blog.controller;

import com.cazacioc.blog.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FrontController {

    @Autowired
    private EntryService entryService;

    @RequestMapping
    public String hello(ModelMap model) {
        model.addAttribute("entries", entryService.getAllEntries());
        return "front";
    }

}
