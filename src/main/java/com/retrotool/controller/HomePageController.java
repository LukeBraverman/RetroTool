package com.retrotool.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomePageController {

    private HomePageService homePageService;

    @GetMapping("/")
    public String HomePage(Model model) {

        String headerText = "RetroTool!";

        List<CardTemplate> positiveCardTemplates = homePageService.getPositiveCardTemplates();

        CardTemplate emptyPositiveCardTemplate = new CardTemplate();
        emptyPositiveCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);

        model.addAttribute("positiveCardTemplate", emptyPositiveCardTemplate);
        model.addAttribute("headerText", headerText);
        model.addAttribute("positiveCardTemplates", positiveCardTemplates);




        return "HomePage";
    }
}
