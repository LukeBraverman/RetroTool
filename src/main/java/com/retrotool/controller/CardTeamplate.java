package com.retrotool.controller;

import lombok.Data;

import java.util.UUID;

@Data
public class CardTeamplate {

    public UUID uuid;

    public String headerText;

    public String bodyText;

    public TypeOfCardTemplate typeOfCardTemplate;

    public CardTeamplate() {
        uuid = UUID.randomUUID();
    }

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public TypeOfCardTemplate getTypeOfCardTemplate() {
        return typeOfCardTemplate;
    }

    public void setTypeOfCardTemplate(TypeOfCardTemplate typeOfCardTemplate) {
        this.typeOfCardTemplate = typeOfCardTemplate;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
