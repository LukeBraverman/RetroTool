package com.retrotool.controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomePageService {

    public List<CardTemplate> cardTemplates = new ArrayList<>();


    public List<CardTemplate> getPositiveCardTemplates() {
        CardTemplate cardTemplate = new CardTemplate();
        System.out.println(cardTemplate.getUuid() + "<-- UUID given ");
        cardTemplates.add(cardTemplate); //ToDo: delete line 16; for testing only.
        return cardTemplates;
    }

    public void addCardTemplate(CardTemplate cardTemplate) {
        cardTemplates.add(cardTemplate);
    }

    public void deleteCardTemplate(CardTemplate cardTemplate) {
        cardTemplates.remove(cardTemplate);
    }


}
