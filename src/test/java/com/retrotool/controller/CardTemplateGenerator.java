package com.retrotool.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardTemplateGenerator {


    public List<CardTemplate> returnAVariableAmountOfCardTemplatesWithGivenType(int amountOfCardTemplatesToCreate, TypeOfCardTemplate typeOfCardTemplateToCreate) {
        if (amountOfCardTemplatesToCreate == 0) {
            return Collections.emptyList();
        }
        List<CardTemplate> cardTemplatesGenerated = new ArrayList<>();
        for (int i=0; i < amountOfCardTemplatesToCreate; i++) {
            CardTemplate cardTemplate = new CardTemplate();
            cardTemplate.setHeaderText("Card template " + i );
            cardTemplate.setBodyText("Card body " + i);
            cardTemplate.setTypeOfCardTemplate(typeOfCardTemplateToCreate);
            cardTemplatesGenerated.add(cardTemplate);
        }
        return cardTemplatesGenerated;
    }
}
