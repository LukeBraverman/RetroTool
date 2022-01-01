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
    public String deleteCardTemplate(@RequestParam UUID uuidOfCardTemplateToDelete) {
        System.out.println(uuidOfCardTemplateToDelete + "<--- param recieved");
        homePageService.deleteCardTemplate(uuidOfCardTemplateToDelete);

        /*
        todo:

        pass param value to service BUT CHANGE SERVICE TESTS FIRST
        change logic in service layer to delete card based on UUID passed in

         */
        return "redirect:/";
    }


}
