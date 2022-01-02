package com.retrotool.controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HomePageService {

    public List<CardTemplate> cardTemplates = new ArrayList<>();


    public List<CardTemplate> getPositiveCardTemplates() {
        List<CardTemplate> positiveCardTemplates = new ArrayList<>();
        for (CardTemplate cardTemplate: cardTemplates) {
            if (cardTemplate.getTypeOfCardTemplate() == TypeOfCardTemplate.POSITIVE) {
                positiveCardTemplates.add(cardTemplate);
            }
        }
        return positiveCardTemplates;
    }

    public List<CardTemplate> getNegativeCardTemplates() {
        List<CardTemplate> negativeCardTemplates = new ArrayList<>();
        for (CardTemplate cardTemplate: cardTemplates) {
            if (cardTemplate.getTypeOfCardTemplate() == TypeOfCardTemplate.NEGATIVE) {
                negativeCardTemplates.add(cardTemplate);
            }
        }
        return negativeCardTemplates;
    }

    public List<CardTemplate> getNeutralCardTemplates() {
        List<CardTemplate> neutralCardTemplates = new ArrayList<>();
        for (CardTemplate cardTemplate: cardTemplates) {
            if (cardTemplate.getTypeOfCardTemplate() == TypeOfCardTemplate.NEUTRAL) {
                neutralCardTemplates.add(cardTemplate);
            }
        }
        return neutralCardTemplates;
    }

    public void addCardTemplate(CardTemplate cardTemplate) {
        cardTemplates.add(cardTemplate);
    }

    public void deleteCardTemplate(UUID UUIDofCardTemplateToDelete) {
        //Replace with .removeIf( x -> x.getUuid().equals(UUIDofCardTemplateToDelete))
        CardTemplate cardTemplate = null;
        for (CardTemplate cardTemplateInList: cardTemplates) {
            if ( cardTemplateInList.getUuid().equals(UUIDofCardTemplateToDelete) ) {
                cardTemplate = cardTemplateInList;
            }
        }
        if ( cardTemplate != null) {
            cardTemplates.remove(cardTemplate);
        }
    }
}
