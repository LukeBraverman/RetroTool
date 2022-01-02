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
        CardTemplate positiveCardTemplate = new CardTemplate();
        positiveCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);
        CardTemplate negativeCardTemplate = new CardTemplate();
        negativeCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEGATIVE);
        CardTemplate neutralCardTemplate = new CardTemplate();
        neutralCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEUTRAL);


        cardTemplates.add(positiveCardTemplate);
        cardTemplates.add(positiveCardTemplate);
        cardTemplates.add(negativeCardTemplate);
        cardTemplates.add(neutralCardTemplate);
        homePageService.cardTemplates = cardTemplates;

        List<CardTemplate> resultingCardTemplateList = homePageService.getPositiveCardTemplates();

        assertEquals(2,resultingCardTemplateList.size());


    }

    @Test
    public void returnAllNegativeCardTemplatesAsAList() {
        List<CardTemplate> cardTemplates = new ArrayList<>();
        CardTemplate positiveCardTemplate = new CardTemplate();
        positiveCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);
        CardTemplate negativeCardTemplate = new CardTemplate();
        negativeCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEGATIVE);
        CardTemplate neutralCardTemplate = new CardTemplate();
        neutralCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEUTRAL);


        cardTemplates.add(positiveCardTemplate);
        cardTemplates.add(negativeCardTemplate);
        cardTemplates.add(negativeCardTemplate);
        cardTemplates.add(neutralCardTemplate);
        homePageService.cardTemplates = cardTemplates;

        List<CardTemplate> resultingCardTemplateList = homePageService.getNegativeCardTemplates();

        assertEquals(2,resultingCardTemplateList.size());


    }

    @Test
    public void returnAllNeutralCardTemplatesAsAList() {
        List<CardTemplate> cardTemplates = new ArrayList<>();
        CardTemplate positiveCardTemplate = new CardTemplate();
        positiveCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);
        CardTemplate negativeCardTemplate = new CardTemplate();
        negativeCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEGATIVE);
        CardTemplate neutralCardTemplate = new CardTemplate();
        neutralCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEUTRAL);


        cardTemplates.add(positiveCardTemplate);
        cardTemplates.add(negativeCardTemplate);
        cardTemplates.add(neutralCardTemplate);
        cardTemplates.add(neutralCardTemplate);
        homePageService.cardTemplates = cardTemplates;

        List<CardTemplate> resultingCardTemplateList = homePageService.getNeutralCardTemplates();

        assertEquals(2,resultingCardTemplateList.size());


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