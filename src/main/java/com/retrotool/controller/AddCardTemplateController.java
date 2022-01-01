package com.retrotool.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AddCardTemplateController {

    private HomePageService homePageService;

    @PostMapping("/AddCardTemplate")
    public String addCardTemplateToList(@ModelAttribute("CardTemplate") CardTemplate cardTemplate) {
        homePageService.addCardTemplate(cardTemplate);
        return "redirect:/";
    }
}
