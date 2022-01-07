package com.retrotool.dao;

import com.retrotool.dao.TypeOfCardTemplate;
import lombok.Data;

import java.util.UUID;

@Data
public class CardTemplate {

    public UUID uuid;

    public String headerText;

    public String bodyText;

    public TypeOfCardTemplate typeOfCardTemplate;

    public CardTemplate() {
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

    @Override
    public String toString() {
        return "CardTemplate{" +
                "uuid=" + uuid +
                ", headerText='" + headerText + '\'' +
                ", bodyText='" + bodyText + '\'' +
                ", typeOfCardTemplate=" + typeOfCardTemplate +
                '}';
    }
}
