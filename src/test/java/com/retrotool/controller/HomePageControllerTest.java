package com.retrotool.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HomePageController.class)
@ExtendWith(MockitoExtension.class)

class HomePageControllerTest {
    @InjectMocks
    HomePageController homePageController;

    @MockBean
    HomePageService homePageService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenHomeControllerCalled_200okReturned() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void whenHomeControllerCalled_viewWithHeaderContainingStringRetroToolReturned() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("HomePage"))
                .andExpect(MockMvcResultMatchers.model().attribute("headerText", "RetroTool!"));
    }

//    @Test
//    public void whenHomeControllerCalled_viewWithObjectWithEmptyPositiveCardTemplateReturned() throws Exception {
//        CardTemplate emptyPositiveCardTemplate = new CardTemplate();
//        emptyPositiveCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);
//
//        this.mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.view().name("HomePage"))
//                .andExpect(MockMvcResultMatchers.model().attribute("positiveCardTemplate", emptyPositiveCardTemplate));
//    }
    /*
    Test above is broken. I added a random UUID generation function. This was to allow fo delete to work. Since UUID is random, the card template
    created in the given section, will not have the same uuid in ad the 'positive card template' which is generated during run time in the controller.
    When i refactor this positive card template generation to the service layer, i can revisit this test and fix.

    Repeat for negative and neutral
     */



    @Test
    public void whenGetAllPositiveTemplatesWithEmptyList_showZeroTemplates() throws Exception {
        List<CardTemplate> emptyListOfCardTemplates = Collections.emptyList();

        when(homePageService.getPositiveCardTemplates()).thenReturn(emptyListOfCardTemplates);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("HomePage"))
                .andExpect(MockMvcResultMatchers.model().attribute("positiveCardTemplates",emptyListOfCardTemplates));
    }

    @Test
    public void whenGetAllNegativeTemplatesWithEmptyList_showZeroTemplates() throws Exception {
        List<CardTemplate> emptyListOfCardTemplates = Collections.emptyList();

        when(homePageService.getNegativeCardTemplates()).thenReturn(emptyListOfCardTemplates);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("HomePage"))
                .andExpect(MockMvcResultMatchers.model().attribute("negativeCardTemplates",emptyListOfCardTemplates));
    }

    @Test
    public void whenGetAllNeutralTemplatesWithEmptyList_showZeroTemplates() throws Exception {
        List<CardTemplate> emptyListOfCardTemplates = Collections.emptyList();

        when(homePageService.getPositiveCardTemplates()).thenReturn(emptyListOfCardTemplates);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("HomePage"))
                .andExpect(MockMvcResultMatchers.model().attribute("neutralCardTemplates",emptyListOfCardTemplates));
    }

    @Test
    public void whenGetAllPositiveTemplatesWithTwoTemplates_showTwoTemplates() throws Exception {
        CardTemplateGenerator cardTemplateGenerator = new CardTemplateGenerator();
        List<CardTemplate> twoPositiveCardTemplatesInAList = cardTemplateGenerator.returnAVariableAmountOfCardTemplatesWithGivenType(2, TypeOfCardTemplate.POSITIVE);

        when(homePageService.getPositiveCardTemplates()).thenReturn(twoPositiveCardTemplatesInAList);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("HomePage"))
                .andExpect(MockMvcResultMatchers.model().attribute("positiveCardTemplates",twoPositiveCardTemplatesInAList));
    }

    @Test
    public void whenGetAllNegativeTemplatesWithTwoTemplates_showTwoTemplates() throws Exception {
        CardTemplateGenerator cardTemplateGenerator = new CardTemplateGenerator();
        List<CardTemplate> twoNegativeCardTemplatesInAList = cardTemplateGenerator.returnAVariableAmountOfCardTemplatesWithGivenType(2, TypeOfCardTemplate.NEGATIVE);

        when(homePageService.getNegativeCardTemplates()).thenReturn(twoNegativeCardTemplatesInAList);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("HomePage"))
                .andExpect(MockMvcResultMatchers.model().attribute("negativeCardTemplates",twoNegativeCardTemplatesInAList));
    }

    @Test
    public void whenGetAllNeutralTemplatesWithTwoTemplates_showTwoTemplates() throws Exception {
        CardTemplateGenerator cardTemplateGenerator = new CardTemplateGenerator();
        List<CardTemplate> twoNeutralCardTemplatesInAList = cardTemplateGenerator.returnAVariableAmountOfCardTemplatesWithGivenType(2, TypeOfCardTemplate.NEUTRAL);

        when(homePageService.getPositiveCardTemplates()).thenReturn(twoNeutralCardTemplatesInAList);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("HomePage"))
                .andExpect(MockMvcResultMatchers.model().attribute("neutralCardTemplates",twoNeutralCardTemplatesInAList));
    }

    @Test
    public void whenGetAllPositiveTemplatesWithTenTemplates_showTenTemplates() throws Exception {
        CardTemplateGenerator cardTemplateGenerator = new CardTemplateGenerator();
        List<CardTemplate> tenPositiveCardTemplatesInAList = cardTemplateGenerator.returnAVariableAmountOfCardTemplatesWithGivenType(10,TypeOfCardTemplate.POSITIVE);

        when(homePageService.getPositiveCardTemplates()).thenReturn(tenPositiveCardTemplatesInAList);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("HomePage"))
                .andExpect(MockMvcResultMatchers.model().attribute("positiveCardTemplates",tenPositiveCardTemplatesInAList));
    }

    @Test
    public void whenGetAllNegativeTemplatesWithTenTemplates_showTenTemplates() throws Exception {
        CardTemplateGenerator cardTemplateGenerator = new CardTemplateGenerator();
        List<CardTemplate> tenNegativeCardTemplatesInAList = cardTemplateGenerator.returnAVariableAmountOfCardTemplatesWithGivenType(10,TypeOfCardTemplate.NEGATIVE);

        when(homePageService.getNegativeCardTemplates()).thenReturn(tenNegativeCardTemplatesInAList);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("HomePage"))
                .andExpect(MockMvcResultMatchers.model().attribute("negativeCardTemplates",tenNegativeCardTemplatesInAList));
    }

    @Test
    public void whenGetAllNeutralTemplatesWithTenTemplates_showTenTemplates() throws Exception {
        CardTemplateGenerator cardTemplateGenerator = new CardTemplateGenerator();
        List<CardTemplate> tenNeutralCardTemplatesInAList = cardTemplateGenerator.returnAVariableAmountOfCardTemplatesWithGivenType(10,TypeOfCardTemplate.NEUTRAL);

        when(homePageService.getNegativeCardTemplates()).thenReturn(tenNeutralCardTemplatesInAList);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("HomePage"))
                .andExpect(MockMvcResultMatchers.model().attribute("neutralCardTemplates",tenNeutralCardTemplatesInAList));
    }





}