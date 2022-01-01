package com.retrotool.controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomePageService {

    public List<CardTeamplate> cardTemplates = new ArrayList<>();


    public List<CardTeamplate> getPositiveCardTemplates() {
        return cardTemplates;
    }

    public void addCardTemplate(CardTeamplate cardTeamplate) {
        cardTemplates.add(cardTeamplate);
    }

    public void deleteCardTemplate(CardTeamplate cardTeamplate) {
        cardTemplates.remove(cardTeamplate);
    }


}
