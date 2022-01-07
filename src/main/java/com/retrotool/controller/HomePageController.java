package com.retrotool.controller;

import com.retrotool.dao.CardTemplate;
import com.retrotool.dao.TypeOfCardTemplate;
import com.retrotool.service.HomePageService;
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
        String headerText = homePageService.generateHeaderText();

        List<CardTemplate> positiveCardTemplates = homePageService.getPositiveCardTemplates();
        List<CardTemplate> negativeCardTemplates = homePageService.getNegativeCardTemplates();
        List<CardTemplate> neutralCardTemplates = homePageService.getNeutralCardTemplates();

        CardTemplate emptyPositiveCardTemplate = homePageService.returnAEmptyCardTemplatesWithGivenType(TypeOfCardTemplate.POSITIVE);
        CardTemplate emptyNegativeCardTemplate = homePageService.returnAEmptyCardTemplatesWithGivenType(TypeOfCardTemplate.NEGATIVE);
        CardTemplate emptyNeutralCardTemplate = homePageService.returnAEmptyCardTemplatesWithGivenType(TypeOfCardTemplate.NEUTRAL);

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
