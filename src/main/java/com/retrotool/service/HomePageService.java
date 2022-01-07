package com.retrotool.service;

import com.retrotool.dao.CardTemplate;
import com.retrotool.dao.TypeOfCardTemplate;
import com.retrotool.dao.CardTemplateArrayList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class HomePageService {



    private CardTemplateArrayList cardTemplateArrayList;

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
        List<CardTemplate> cardTemplatesWithAllTypeToSort = cardTemplateArrayList.getCardTemplates();
        for (CardTemplate cardTemplate: cardTemplatesWithAllTypeToSort) {
            if (cardTemplate.getTypeOfCardTemplate() == typeOfCardTemplateToGetFromCollection) {
                cardTemplatesWithGivenType.add(cardTemplate);
            }
        }
        return cardTemplatesWithGivenType;
    }

    public void addCardTemplate(CardTemplate cardTemplate) {
        cardTemplateArrayList.getCardTemplates().add(cardTemplate);
    }

    public void deleteCardTemplateWithGivenUUID(UUID UUIDofCardTemplateToDelete) {
        cardTemplateArrayList.getCardTemplates().removeIf( cardTemplateInList -> cardTemplateInList.getUuid().equals(UUIDofCardTemplateToDelete));
    }

    public String generateHeaderText() {
        return "Retro tool";
    }

    public CardTemplate returnAEmptyCardTemplatesWithGivenType(TypeOfCardTemplate typeOfCardTemplateToCreate) {
            CardTemplate cardTemplate = new CardTemplate();
            cardTemplate.setTypeOfCardTemplate(typeOfCardTemplateToCreate);
        return cardTemplate;
    }

    public CardTemplateArrayList getCardTemplateArrayList() {
        return cardTemplateArrayList;
    }
}
