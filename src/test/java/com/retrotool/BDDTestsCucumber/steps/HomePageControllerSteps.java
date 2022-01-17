package com.retrotool.BDDTestsCucumber.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retrotool.dao.CardTemplateArrayList;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class HomePageControllerSteps {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    CardTemplateArrayList cardTemplateArrayList;

    @Autowired
    private ObjectMapper objectMapper;

    private  ResponseEntity<String> responseFromRequest;

    @Before
    public void setup() {
        cardTemplateArrayList.setCardTemplates(new ArrayList<>());
        responseFromRequest = null;
    }

    @Given("^the user calls the home controller url$")
    public void theUserCallsTheHomeController()
    {
        ResponseEntity<String> response = this.testRestTemplate.getForEntity("/", String.class);
        responseFromRequest = response;

    }

    @Then("^expect status to be 200 OK.$")
    public void expectResponseFromRequestObjectToBe200OK() {
        Assertions.assertEquals(HttpStatus.OK,responseFromRequest.getStatusCode());
    }
}
