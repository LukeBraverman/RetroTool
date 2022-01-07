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
public class AddNeutralCardTemplateController {

    private HomePageService homePageService;

    @PostMapping("/AddNeutralCardTemplate")
    public String addNeutralCardTemplateToList(@ModelAttribute("NeutralCardTemplate") CardTemplate cardTemplate) {
        cardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEUTRAL);
        homePageService.addCardTemplate(cardTemplate);
        return "redirect:/";
    }
}
