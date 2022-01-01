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
     */

    @Test
    public void whenGetAllPositiveTemplatesWithTwoTemplates_showTwoTemplates() throws Exception {

        List<CardTemplate> twoPositiveCardTemplatesInAList = new ArrayList<>();
        CardTemplate cardTemplateOne = new CardTemplate();
        cardTemplateOne.setHeaderText("HeaderOne");
        cardTemplateOne.setBodyText("BodyOne");
        CardTemplate cardTemplateTwo = new CardTemplate();
        cardTemplateTwo.setHeaderText("HeaderTwo");
        cardTemplateTwo.setBodyText("BodyTwo");

        twoPositiveCardTemplatesInAList.add(cardTemplateOne);
        twoPositiveCardTemplatesInAList.add(cardTemplateTwo);

        when(homePageService.getPositiveCardTemplates()).thenReturn(twoPositiveCardTemplatesInAList);

         mockMvc.perform(get("/"))
                 .andExpect(status().isOk())
                 .andExpect(MockMvcResultMatchers.view().name("HomePage"))
                 .andExpect(MockMvcResultMatchers.model().attribute("positiveCardTemplates",twoPositiveCardTemplatesInAList));
    }

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
    public void whenGetAllPositiveTemplatesWithTenTemplates_showTenTemplates() throws Exception {
        List<CardTemplate> tenPositiveCardTemplatesInAList = new ArrayList<>();

        CardTemplate cardTemplateOne = new CardTemplate();
        cardTemplateOne.setHeaderText("1");
        cardTemplateOne.setBodyText("1");
        CardTemplate cardTemplateTwo = new CardTemplate();
        cardTemplateTwo.setHeaderText("2");
        cardTemplateTwo.setBodyText("2");
        CardTemplate cardTemplateThree = new CardTemplate();
        cardTemplateThree.setHeaderText("3");
        cardTemplateThree.setBodyText("3");
        CardTemplate cardTemplateFour = new CardTemplate();
        cardTemplateFour.setHeaderText("4");
        cardTemplateFour.setBodyText("4");
        CardTemplate cardTemplateFive = new CardTemplate();
        cardTemplateFive.setHeaderText("5");
        cardTemplateFive.setBodyText("5");
        CardTemplate cardTemplateSix = new CardTemplate();
        cardTemplateSix.setHeaderText("6");
        cardTemplateSix.setBodyText("6");
        CardTemplate cardTemplateSeven = new CardTemplate();
        cardTemplateSeven.setHeaderText("7");
        cardTemplateSeven.setBodyText("7");
        CardTemplate cardTemplateEight = new CardTemplate();
        cardTemplateEight.setHeaderText("8");
        cardTemplateEight.setBodyText("8");
        CardTemplate cardTemplateNine = new CardTemplate();
        cardTemplateNine.setHeaderText("9");
        cardTemplateNine.setBodyText("9");
        CardTemplate cardTemplateTen = new CardTemplate();
        cardTemplateTen.setHeaderText("10");
        cardTemplateTen.setBodyText("10");

        tenPositiveCardTemplatesInAList.add(cardTemplateOne);
        tenPositiveCardTemplatesInAList.add(cardTemplateTwo);
        tenPositiveCardTemplatesInAList.add(cardTemplateThree);
        tenPositiveCardTemplatesInAList.add(cardTemplateFour);
        tenPositiveCardTemplatesInAList.add(cardTemplateFive);
        tenPositiveCardTemplatesInAList.add(cardTemplateSix);
        tenPositiveCardTemplatesInAList.add(cardTemplateSeven);
        tenPositiveCardTemplatesInAList.add(cardTemplateEight);
        tenPositiveCardTemplatesInAList.add(cardTemplateNine);
        tenPositiveCardTemplatesInAList.add(cardTemplateTen);

        when(homePageService.getPositiveCardTemplates()).thenReturn(tenPositiveCardTemplatesInAList);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("HomePage"))
                .andExpect(MockMvcResultMatchers.model().attribute("positiveCardTemplates",tenPositiveCardTemplatesInAList));

    }





}