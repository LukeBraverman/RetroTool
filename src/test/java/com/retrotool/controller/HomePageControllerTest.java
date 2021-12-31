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

    @Test
    public void whenHomeControllerCalled_viewWithObjectWithEmptyPositiveCardTemplateReturned() throws Exception {
        CardTeamplate emptyPositiveCardTemplate = new CardTeamplate();
        emptyPositiveCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);

        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("HomePage"))
                .andExpect(MockMvcResultMatchers.model().attribute("positiveCardTemplate", emptyPositiveCardTemplate));
    }


    @Test
    public void whenGetAllPositiveTemplatesWithTwoTemplates_showTwoTemplates() throws Exception {

        List<CardTeamplate> twoPositiveCardTemplatesInAList = new ArrayList<>();
        CardTeamplate cardTeamplateOne = new CardTeamplate();
        cardTeamplateOne.setHeaderText("HeaderOne");
        cardTeamplateOne.setBodyText("BodyOne");
        CardTeamplate cardTeamplateTwo = new CardTeamplate();
        cardTeamplateTwo.setHeaderText("HeaderTwo");
        cardTeamplateTwo.setBodyText("BodyTwo");

        twoPositiveCardTemplatesInAList.add(cardTeamplateOne);
        twoPositiveCardTemplatesInAList.add(cardTeamplateTwo);

        when(homePageService.getPositiveCardTemplates()).thenReturn(twoPositiveCardTemplatesInAList);

         mockMvc.perform(get("/"))
                 .andExpect(status().isOk())
                 .andExpect(MockMvcResultMatchers.view().name("HomePage"))
                 .andExpect(MockMvcResultMatchers.model().attribute("positiveCardTemplates",twoPositiveCardTemplatesInAList));
    }

    @Test
    public void whenGetAllPositiveTemplatesWithEmptyList_showZeroTemplates() throws Exception {
        List<CardTeamplate> emptyListOfCardTemplates = Collections.emptyList();

        when(homePageService.getPositiveCardTemplates()).thenReturn(emptyListOfCardTemplates);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("HomePage"))
                .andExpect(MockMvcResultMatchers.model().attribute("positiveCardTemplates",emptyListOfCardTemplates));
    }

    @Test
    public void whenGetAllPositiveTemplatesWithTenTemplates_showTenTemplates() throws Exception {
        List<CardTeamplate> tenPositiveCardTemplatesInAList = new ArrayList<>();

        CardTeamplate cardTeamplateOne = new CardTeamplate();
        cardTeamplateOne.setHeaderText("1");
        cardTeamplateOne.setBodyText("1");
        CardTeamplate cardTeamplateTwo = new CardTeamplate();
        cardTeamplateTwo.setHeaderText("2");
        cardTeamplateTwo.setBodyText("2");
        CardTeamplate cardTeamplateThree = new CardTeamplate();
        cardTeamplateThree.setHeaderText("3");
        cardTeamplateThree.setBodyText("3");
        CardTeamplate cardTeamplateFour = new CardTeamplate();
        cardTeamplateFour.setHeaderText("4");
        cardTeamplateFour.setBodyText("4");
        CardTeamplate cardTeamplateFive = new CardTeamplate();
        cardTeamplateFive.setHeaderText("5");
        cardTeamplateFive.setBodyText("5");
        CardTeamplate cardTeamplateSix = new CardTeamplate();
        cardTeamplateSix.setHeaderText("6");
        cardTeamplateSix.setBodyText("6");
        CardTeamplate cardTeamplateSeven = new CardTeamplate();
        cardTeamplateSeven.setHeaderText("7");
        cardTeamplateSeven.setBodyText("7");
        CardTeamplate cardTeamplateEight = new CardTeamplate();
        cardTeamplateEight.setHeaderText("8");
        cardTeamplateEight.setBodyText("8");
        CardTeamplate cardTeamplateNine = new CardTeamplate();
        cardTeamplateNine.setHeaderText("9");
        cardTeamplateNine.setBodyText("9");
        CardTeamplate cardTeamplateTen = new CardTeamplate();
        cardTeamplateTen.setHeaderText("10");
        cardTeamplateTen.setBodyText("10");

        tenPositiveCardTemplatesInAList.add(cardTeamplateOne);
        tenPositiveCardTemplatesInAList.add(cardTeamplateTwo);
        tenPositiveCardTemplatesInAList.add(cardTeamplateThree);
        tenPositiveCardTemplatesInAList.add(cardTeamplateFour);
        tenPositiveCardTemplatesInAList.add(cardTeamplateFive);
        tenPositiveCardTemplatesInAList.add(cardTeamplateSix);
        tenPositiveCardTemplatesInAList.add(cardTeamplateSeven);
        tenPositiveCardTemplatesInAList.add(cardTeamplateEight);
        tenPositiveCardTemplatesInAList.add(cardTeamplateNine);
        tenPositiveCardTemplatesInAList.add(cardTeamplateTen);

        when(homePageService.getPositiveCardTemplates()).thenReturn(tenPositiveCardTemplatesInAList);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("HomePage"))
                .andExpect(MockMvcResultMatchers.model().attribute("positiveCardTemplates",tenPositiveCardTemplatesInAList));

    }





}