package com.retrotool.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomePageController {

    private HomePageService homePageService;

    @GetMapping("/")
    public String HomePage(Model model) {

        String headerText = "RetroTool!";

        homePageService.getPositiveCardTemplates();

        model.addAttribute("headerText", headerText);


        return "HomePage";
    }
}
