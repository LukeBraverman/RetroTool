package com.retrotool.controller;

import com.retrotool.dao.CardTemplate;
import com.retrotool.dao.TypeOfCardTemplate;
import com.retrotool.service.HomePageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AddNegativeCardTemplateController {

    private HomePageService homePageService;

    @PostMapping("/AddNegativeCardTemplate")
    public String addNegativeCardTemplateToList(@ModelAttribute("NegativeCardTemplate") CardTemplate cardTemplate) {
        cardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEGATIVE);
        homePageService.addCardTemplate(cardTemplate);
        return "redirect:/";
    }
}
