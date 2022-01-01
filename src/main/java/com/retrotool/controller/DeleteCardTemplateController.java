package com.retrotool.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@AllArgsConstructor
public class DeleteCardTemplateController {

    private HomePageService homePageService;

    @DeleteMapping("/DeleteCardTemplate")
    public String deleteCardTemplate(@ModelAttribute("CardTemplate") CardTeamplate cardTeamplate) {
        homePageService.deleteCardTemplate(cardTeamplate);
        return "redirect:/";
    }


}
