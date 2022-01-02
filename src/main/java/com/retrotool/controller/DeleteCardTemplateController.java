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
        homePageService.deleteCardTemplate(uuidOfCardTemplateToDelete);
        return "redirect:/";
    }


}
