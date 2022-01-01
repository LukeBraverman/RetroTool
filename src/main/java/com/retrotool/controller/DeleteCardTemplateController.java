package com.retrotool.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@AllArgsConstructor
public class DeleteCardTemplateController {

    private HomePageService homePageService;

    @GetMapping("/DeleteCardTemplate")
    public String deleteCardTemplate(@RequestParam UUID Id) {
        System.out.println(Id + "<--- param recieved");
//        homePageService.deleteCardTemplate(cardTeamplate);

        /*
        todo:
        Get delete button click to pass hardcoded param value to this controller
        Get delete button click to pass softcoded param value to this controller
        pass param value to service BUT CHANGE SERVICE TESTS FIRST
        change logic in service layer to delete card based on UUID passed in

         */
        return "redirect:/";
    }


}
