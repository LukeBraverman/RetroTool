package com.retrotool.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomePageServiceTest {
    HomePageService homePageService;

    @BeforeEach
    public void setUp() {
         homePageService = new HomePageService();
    }


    @Test
    public void returnAllPositiveCardTemplatesAsAList() {
        List<CardTemplate> cardTemplates = new ArrayList<>();
        CardTemplate cardTemplate = new CardTemplate();
        cardTemplates.add(cardTemplate);
        homePageService.cardTemplates = cardTemplates;

        List<CardTemplate> resultingCardTemplateList = homePageService.getPositiveCardTemplates();

        assertEquals(1,resultingCardTemplateList.size());


    }

    @Test
    public void addAPositiveCardTemplateToList() {
        CardTemplate cardTemplate = new CardTemplate();

        homePageService.addCardTemplate(cardTemplate);

        assertEquals(1,homePageService.cardTemplates.size());

    }

    @Test
    public void deleteACardPositiveCardTemplate() {
        CardTemplate cardTemplate = new CardTemplate();
        cardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);
        homePageService.cardTemplates.add(cardTemplate);

        homePageService.deleteCardTemplate(cardTemplate.uuid);

        assertEquals(0,homePageService.cardTemplates.size());
    }

}