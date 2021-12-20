package com.retrotool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String HomePage(Model model) {

        String headerText = "RetroTool!";

        model.addAttribute("headerText", headerText);


        return "HomePage";
    }
}
