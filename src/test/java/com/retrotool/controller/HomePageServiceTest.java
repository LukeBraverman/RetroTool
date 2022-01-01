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
        List<CardTeamplate> cardTeamplates = new ArrayList<>();
        CardTeamplate cardTeamplate = new CardTeamplate();
        cardTeamplates.add(cardTeamplate);
        homePageService.cardTemplates = cardTeamplates;

        List<CardTeamplate> resultingCardTemplateList = homePageService.getPositiveCardTemplates();

        assertEquals(1,resultingCardTemplateList.size());


    }

    @Test
    public void addAPositiveCardTemplateToList() {
        CardTeamplate cardTeamplate = new CardTeamplate();

        homePageService.addCardTemplate(cardTeamplate);

        assertEquals(1,homePageService.cardTemplates.size());

    }

    @Test
    public void deleteACardPositiveCardTemplate() {
        CardTeamplate cardTeamplate = new CardTeamplate();
        cardTeamplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);
        homePageService.cardTemplates.add(cardTeamplate);

        homePageService.deleteCardTemplate(cardTeamplate);

        assertEquals(0,homePageService.cardTemplates.size());
    }

}