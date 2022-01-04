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
        List<CardTemplate> positiveCardTemplates = returnListOfCardTemplatesWithGivenTypeFromMainCollectionOfCardTemplates(TypeOfCardTemplate.POSITIVE);
        return positiveCardTemplates;
    }

    public List<CardTemplate> getNegativeCardTemplates() {
        List<CardTemplate> negativeCardTemplates = returnListOfCardTemplatesWithGivenTypeFromMainCollectionOfCardTemplates(TypeOfCardTemplate.NEGATIVE);
        return negativeCardTemplates;
    }

    public List<CardTemplate> getNeutralCardTemplates() {
        List<CardTemplate> neutralCardTemplates = returnListOfCardTemplatesWithGivenTypeFromMainCollectionOfCardTemplates(TypeOfCardTemplate.NEUTRAL);
        return neutralCardTemplates;
    }

    public List<CardTemplate> returnListOfCardTemplatesWithGivenTypeFromMainCollectionOfCardTemplates(TypeOfCardTemplate typeOfCardTemplateToGetFromCollection) {
        List<CardTemplate> cardTemplatesWithGivenType = new ArrayList<>();
        for (CardTemplate cardTemplate: cardTemplates) {
            if (cardTemplate.getTypeOfCardTemplate() == typeOfCardTemplateToGetFromCollection) {
                cardTemplatesWithGivenType.add(cardTemplate);
            }
        }
        return cardTemplatesWithGivenType;
    }

    public void addCardTemplate(CardTemplate cardTemplate) {
        cardTemplates.add(cardTemplate);
    }

    public void deleteCardTemplateWithGivenUUID(UUID UUIDofCardTemplateToDelete) {
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
