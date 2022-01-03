package com.retrotool.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AddNegativeCardTemplate {

    private HomePageService homePageService;

    @PostMapping("/AddNegativeCardTemplate")
    public String addNegativeCardTemplateToList() {

        return "";
    }
}
