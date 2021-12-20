package com.retrotool.controller;

import lombok.Data;

@Data
public class CardTeamplate {

    public String headerText;

    public String bodyText;

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
}
