package com.retrotool.controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomePageService {

    public List<CardTeamplate> cardTeamplates = new ArrayList<>();


    public List<CardTeamplate> getPositiveCardTemplates() {
        return cardTeamplates;
    }

    public void addCardTemplate(CardTeamplate cardTeamplate) {
        cardTeamplates.add(cardTeamplate);
    }


}
