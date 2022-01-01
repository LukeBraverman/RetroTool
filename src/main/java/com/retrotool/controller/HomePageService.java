package com.retrotool.controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HomePageService {

    public List<CardTemplate> cardTemplates = new ArrayList<>();


    public List<CardTemplate> getPositiveCardTemplates() {
        CardTemplate cardTemplate = new CardTemplate();
        return cardTemplates;
    }

    public void addCardTemplate(CardTemplate cardTemplate) {
        cardTemplates.add(cardTemplate);
    }

    public void deleteCardTemplate(UUID UUIDofCardTemplateToDelete) {

        CardTemplate cardTemplate = null;
        System.out.println(UUIDofCardTemplateToDelete);
        System.out.println(cardTemplates);
        for (CardTemplate cardTemplateInList: cardTemplates) {

            if ( cardTemplateInList.getUuid() == UUIDofCardTemplateToDelete) {
                cardTemplate = cardTemplateInList;
            }
        }

        if ( cardTemplate != null) {
            cardTemplates.remove(cardTemplate);
        }

        System.out.println(cardTemplates);
    }


}
