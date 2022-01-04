package com.retrotool.controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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
        cardTemplates.removeIf( cardTemplateInList -> cardTemplateInList.getUuid().equals(UUIDofCardTemplateToDelete));
    }

    public String generateHeaderText() {
        return "Retro tool";
    }

    public CardTemplate returnAEmptyCardTemplatesWithGivenType(TypeOfCardTemplate typeOfCardTemplateToCreate) {
            CardTemplate cardTemplate = new CardTemplate();
            cardTemplate.setTypeOfCardTemplate(typeOfCardTemplateToCreate);
        return cardTemplate;
    }
}
