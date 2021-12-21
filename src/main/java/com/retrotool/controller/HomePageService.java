package com.retrotool.controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomePageService {

    public List<CardTeamplate> getPositiveCardTemplates() {

        List<CardTeamplate> cardTeamplates = new ArrayList<>();

        CardTeamplate cardTeamplateOne = new CardTeamplate();
        cardTeamplateOne.setBodyText("THIS IS A TEST BODY SENTENCE TO SEE IF IT WILL APPREAD");
        cardTeamplateOne.setHeaderText("header one");
        cardTeamplates.add(cardTeamplateOne);

        CardTeamplate cardTeamplateTwo = new CardTeamplate();
        cardTeamplateTwo.setBodyText("THIS IS A TEST BODY SENTENCE TO SEE IF IT WILL APPREAD");
        cardTeamplateTwo.setHeaderText("header two");
        cardTeamplates.add(cardTeamplateTwo);

        cardTeamplates.add(cardTeamplateTwo);
        cardTeamplates.add(cardTeamplateTwo);
        cardTeamplates.add(cardTeamplateTwo);
        cardTeamplates.add(cardTeamplateTwo);
        cardTeamplates.add(cardTeamplateTwo);
        cardTeamplates.add(cardTeamplateTwo);
        return cardTeamplates;
    }
}
