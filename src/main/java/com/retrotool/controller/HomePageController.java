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
        List<CardTemplate> negativeCardTemplates = homePageService.getNegativeCardTemplates();
        List<CardTemplate> neutralCardTemplates = homePageService.getNeutralCardTemplates();




        CardTemplate emptyPositiveCardTemplate = new CardTemplate();
        emptyPositiveCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);



        CardTemplate emptyNegativeCardTemplate = new CardTemplate();
        emptyNegativeCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEGATIVE);
        CardTemplate emptyNeutralCardTemplate = new CardTemplate();
        emptyNeutralCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEUTRAL);


        model.addAttribute("positiveCardTemplate", emptyPositiveCardTemplate);
        model.addAttribute("negativeCardTemplate", emptyNegativeCardTemplate);
        model.addAttribute("neutralCardTemplate", emptyNeutralCardTemplate);

        model.addAttribute("headerText", headerText);
        model.addAttribute("positiveCardTemplates", positiveCardTemplates);
        model.addAttribute("negativeCardTemplates", negativeCardTemplates);
        model.addAttribute("neutralCardTemplates", neutralCardTemplates);






        return "HomePage";
    }
}
