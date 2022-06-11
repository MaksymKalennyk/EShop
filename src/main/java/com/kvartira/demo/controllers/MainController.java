package com.kvartira.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Домашня сторінка");
        return "Home";
    }

    @GetMapping("/contact")
    public String about(Model model) {
        model.addAttribute("title", "Про нас");
        return "contact";
    }

}
