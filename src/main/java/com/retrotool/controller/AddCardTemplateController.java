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
    public String addCardTemplateToList(@ModelAttribute("CardTemplate") CardTeamplate cardTeamplate) {


        //add card template to service layer

        //redirect

        //ensure not 404 error




        return "";
    }
}
