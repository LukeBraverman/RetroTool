package com.retrotool.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AddCardTemplateController {

    private HomePageService homePageService;

    @PostMapping("/AddPositiveCardTemplate")
    public String addPositiveCardTemplateToList(@ModelAttribute("CardTemplate") CardTemplate cardTemplate) {
         cardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);
        homePageService.addCardTemplate(cardTemplate);
        return "redirect:/";
    }
}
