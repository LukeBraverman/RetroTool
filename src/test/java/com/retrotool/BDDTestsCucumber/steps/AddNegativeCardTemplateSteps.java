package com.retrotool.BDDTestsCucumber.steps;

import com.retrotool.dao.CardTemplate;
import com.retrotool.dao.CardTemplateArrayList;
import com.retrotool.dao.TypeOfCardTemplate;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;

public class AddNegativeCardTemplateSteps {


    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    CardTemplateArrayList cardTemplateArrayList;

    @Before
    public void setup() {
        cardTemplateArrayList.setCardTemplates(new ArrayList<>());
    }

    @Given("^the user calls the controller with a negative card template$")
    public void theUserCallsControllerWithPositiveCardTemplate(final List<CardTemplate> cardTemplates) {
        CardTemplate cardTemplateToTestWith = cardTemplates.get(0);
        testRestTemplate.postForObject("/AddNegativeCardTemplate", cardTemplateToTestWith, String.class);
    }

    @Then("^the template is assigned a negative enum for card type instance variable$")
    public void theTemplateIsAssignedAPositiveTypeEnum() {
        List<CardTemplate> cardTemplatesInDAOLayer = cardTemplateArrayList.getCardTemplates();
        Assertions.assertEquals(TypeOfCardTemplate.NEGATIVE,cardTemplatesInDAOLayer.get(0).getTypeOfCardTemplate());
    }
}