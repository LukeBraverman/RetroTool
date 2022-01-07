package com.retrotool.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CardTemplateArrayList {

    public void setCardTemplates(List<CardTemplate> cardTemplates) {
        this.cardTemplates = cardTemplates;
    }

    private List<CardTemplate> cardTemplates = new ArrayList<>();

    public List<CardTemplate> getCardTemplates() {
        return cardTemplates;
    }
}
