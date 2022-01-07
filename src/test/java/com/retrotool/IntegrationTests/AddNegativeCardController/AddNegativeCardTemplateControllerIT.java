package com.retrotool.IntegrationTests.AddNegativeCardController;

import com.retrotool.dao.CardTemplate;
import com.retrotool.dao.TypeOfCardTemplate;
import com.retrotool.dao.CardTemplateArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddNegativeCardTemplateControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    CardTemplateArrayList cardTemplateArrayList;

    @BeforeEach
    void setUp() {
        cardTemplateArrayList.setCardTemplates(new ArrayList<>());
    }

    @Test
    public void whenAddNegativeControllerCalled_placeCardIntoEmptyArrayListInDao() {
        CardTemplate cardTemplate = new CardTemplate();
        this.restTemplate.postForObject("/AddNegativeCardTemplate",cardTemplate, String.class);
        assertEquals(1,cardTemplateArrayList.getCardTemplates().size());
    }

    @Test
    public void whenAddNegativeControllerCalled_ensureCardPlacedIntoDaoIsPositice() {
        CardTemplate cardTemplate = new CardTemplate();
        this.restTemplate.postForObject("/AddNegativeCardTemplate",cardTemplate, String.class);
        assertEquals(TypeOfCardTemplate.NEGATIVE,cardTemplateArrayList.getCardTemplates().get(0).getTypeOfCardTemplate());
    }
}
