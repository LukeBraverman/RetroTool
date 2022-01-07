package com.retrotool.UnitTests.service;

import com.retrotool.dao.CardTemplate;
import com.retrotool.dao.CardTemplateArrayList;
import com.retrotool.dao.TypeOfCardTemplate;
import com.retrotool.service.HomePageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class HomePageServiceTest {
    @InjectMocks
    HomePageService homePageService;

    @Mock
    CardTemplateArrayList cardTemplateArrayList;

    @BeforeEach
    public void setUp() {
         homePageService = new HomePageService(cardTemplateArrayList);
    }


    @Test
    public void returnAllPositiveCardTemplatesAsAList() {
        List<CardTemplate> cardTemplates = new ArrayList<>();
        CardTemplate positiveCardTemplate = new CardTemplate();
        positiveCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);
        CardTemplate negativeCardTemplate = new CardTemplate();
        negativeCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEGATIVE);
        CardTemplate neutralCardTemplate = new CardTemplate();
        neutralCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEUTRAL);


        cardTemplates.add(positiveCardTemplate);
        cardTemplates.add(positiveCardTemplate);
        cardTemplates.add(negativeCardTemplate);
        cardTemplates.add(neutralCardTemplate);

        when(cardTemplateArrayList.getCardTemplates()).thenReturn(cardTemplates);
        List<CardTemplate> resultingCardTemplateList = homePageService.getPositiveCardTemplates();

        assertEquals(2,resultingCardTemplateList.size());


    }

    @Test
    public void returnAllNegativeCardTemplatesAsAList() {
        List<CardTemplate> cardTemplates = new ArrayList<>();
        CardTemplate positiveCardTemplate = new CardTemplate();
        positiveCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);
        CardTemplate negativeCardTemplate = new CardTemplate();
        negativeCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEGATIVE);
        CardTemplate neutralCardTemplate = new CardTemplate();
        neutralCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEUTRAL);


        cardTemplates.add(positiveCardTemplate);
        cardTemplates.add(negativeCardTemplate);
        cardTemplates.add(negativeCardTemplate);
        cardTemplates.add(neutralCardTemplate);
        when(cardTemplateArrayList.getCardTemplates()).thenReturn(cardTemplates);

        List<CardTemplate> resultingCardTemplateList = homePageService.getNegativeCardTemplates();

        assertEquals(2,resultingCardTemplateList.size());


    }

    @Test
    public void returnAllNeutralCardTemplatesAsAList() {
        List<CardTemplate> cardTemplates = new ArrayList<>();
        CardTemplate positiveCardTemplate = new CardTemplate();
        positiveCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);
        CardTemplate negativeCardTemplate = new CardTemplate();
        negativeCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEGATIVE);
        CardTemplate neutralCardTemplate = new CardTemplate();
        neutralCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEUTRAL);


        cardTemplates.add(positiveCardTemplate);
        cardTemplates.add(negativeCardTemplate);
        cardTemplates.add(neutralCardTemplate);
        cardTemplates.add(neutralCardTemplate);
        when(cardTemplateArrayList.getCardTemplates()).thenReturn(cardTemplates);

        List<CardTemplate> resultingCardTemplateList = homePageService.getNeutralCardTemplates();

        assertEquals(2,resultingCardTemplateList.size());


    }

    @Test
    public void addAPositiveCardTemplateToList() {
        CardTemplate cardTemplate = new CardTemplate();
        List<CardTemplate> cardTemplates = new ArrayList<>();

        when(cardTemplateArrayList.getCardTemplates()).thenReturn(cardTemplates);

        homePageService.addCardTemplate(cardTemplate);

        assertEquals(1,homePageService.getCardTemplateArrayList().getCardTemplates().size());

    }

    @Test
    public void deleteACardPositiveCardTemplate() {
        CardTemplate cardTemplate = new CardTemplate();
        cardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);
        homePageService.getCardTemplateArrayList().getCardTemplates().add(cardTemplate);

        homePageService.deleteCardTemplateWithGivenUUID(cardTemplate.uuid);

        assertEquals(0,homePageService.getCardTemplateArrayList().getCardTemplates().size());
    }

    @Test
    public void returnRetroToolWhenGenerateHeaderText() {
        String generatedText = homePageService.generateHeaderText();
        assertEquals("Retro tool",generatedText);
    }

    @Test
    public void whenGenerateAPositiveCardTemplate_returnAEmptyPositieCardTemplate() {
        CardTemplate cardTemplateExpected = new CardTemplate();
        cardTemplateExpected.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);

        CardTemplate cardTemplateGenerated = homePageService.returnAEmptyCardTemplatesWithGivenType(TypeOfCardTemplate.POSITIVE);
        cardTemplateGenerated.setUuid(cardTemplateExpected.getUuid());
        assertEquals(cardTemplateExpected,cardTemplateGenerated);
    }

    @Test
    public void whenGenerateANegativeCardTemplate_returnAEmptyNegativeCardTemplate() {
        CardTemplate cardTemplateExpected = new CardTemplate();
        cardTemplateExpected.setTypeOfCardTemplate(TypeOfCardTemplate.NEGATIVE);

        CardTemplate cardTemplateGenerated = homePageService.returnAEmptyCardTemplatesWithGivenType(TypeOfCardTemplate.NEGATIVE);
        cardTemplateExpected.setUuid(cardTemplateGenerated.getUuid());
        assertEquals(cardTemplateExpected,cardTemplateGenerated);
    }

    @Test
    public void whenGenerateANeutralCardTemplate_returnAEmptyNeutralCardTemplate() {
        CardTemplate cardTemplateExpected = new CardTemplate();
        cardTemplateExpected.setTypeOfCardTemplate(TypeOfCardTemplate.NEUTRAL);

        CardTemplate cardTemplateGenerated = homePageService.returnAEmptyCardTemplatesWithGivenType(TypeOfCardTemplate.NEUTRAL);
        cardTemplateExpected.setUuid(cardTemplateGenerated.getUuid());
        assertEquals(cardTemplateExpected,cardTemplateGenerated);
    }

    @Test
    public void whenRequestingPositiveCardTemplates_returnPositiveCardTemplatesFromCollection() {
        List<CardTemplate> cardTemplates = new ArrayList<>();
        CardTemplate positiveCardTemplate = new CardTemplate();
        positiveCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);
        CardTemplate negativeCardTemplate = new CardTemplate();
        negativeCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEGATIVE);
        CardTemplate neutralCardTemplate = new CardTemplate();
        neutralCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEUTRAL);


        cardTemplates.add(positiveCardTemplate);
        cardTemplates.add(positiveCardTemplate);
        cardTemplates.add(negativeCardTemplate);
        cardTemplates.add(neutralCardTemplate);
        when(cardTemplateArrayList.getCardTemplates()).thenReturn(cardTemplates);

        List<CardTemplate> resultingCardTemplateList = homePageService.returnListOfCardTemplatesWithGivenTypeFromMainCollectionOfCardTemplates(TypeOfCardTemplate.POSITIVE);

        assertEquals(2,resultingCardTemplateList.size());
    }

    @Test
    public void whenRequestingNegativeCardTemplates_returnNegativeCardTemplatesFromCollection() {
        List<CardTemplate> cardTemplates = new ArrayList<>();
        CardTemplate positiveCardTemplate = new CardTemplate();
        positiveCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);
        CardTemplate negativeCardTemplate = new CardTemplate();
        negativeCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEGATIVE);
        CardTemplate neutralCardTemplate = new CardTemplate();
        neutralCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEUTRAL);


        cardTemplates.add(positiveCardTemplate);
        cardTemplates.add(negativeCardTemplate);
        cardTemplates.add(negativeCardTemplate);
        cardTemplates.add(neutralCardTemplate);
        when(cardTemplateArrayList.getCardTemplates()).thenReturn(cardTemplates);

        List<CardTemplate> resultingCardTemplateList = homePageService.returnListOfCardTemplatesWithGivenTypeFromMainCollectionOfCardTemplates(TypeOfCardTemplate.NEGATIVE);

        assertEquals(2,resultingCardTemplateList.size());
    }

    @Test
    public void whenRequestingNeutralCardTemplates_returnNeutralCardTemplatesFromCollection() {
        List<CardTemplate> cardTemplates = new ArrayList<>();
        CardTemplate positiveCardTemplate = new CardTemplate();
        positiveCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);
        CardTemplate negativeCardTemplate = new CardTemplate();
        negativeCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEGATIVE);
        CardTemplate neutralCardTemplate = new CardTemplate();
        neutralCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEUTRAL);


        cardTemplates.add(positiveCardTemplate);
        cardTemplates.add(negativeCardTemplate);
        cardTemplates.add(neutralCardTemplate);
        cardTemplates.add(neutralCardTemplate);
        when(cardTemplateArrayList.getCardTemplates()).thenReturn(cardTemplates);

        List<CardTemplate> resultingCardTemplateList = homePageService.returnListOfCardTemplatesWithGivenTypeFromMainCollectionOfCardTemplates(TypeOfCardTemplate.NEUTRAL);

        assertEquals(2,resultingCardTemplateList.size());
    }
}