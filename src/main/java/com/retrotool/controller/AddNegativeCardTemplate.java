package com.retrotool.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AddNegativeCardTemplate {

    private HomePageService homePageService;

    @PostMapping("/AddNegativeCardTemplate")
    public String addNegativeCardTemplateToList(@ModelAttribute("NegativeCardTemplate") CardTemplate cardTemplate) {
        cardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEGATIVE);
        System.out.println(cardTemplate);
        homePageService.addCardTemplate(cardTemplate);
        return "redirect:/";
    }
}
