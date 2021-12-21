package com.retrotool.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HomePageController.class)
@ExtendWith(MockitoExtension.class)
class AddCardTemplateControllerTest {
    @InjectMocks
    AddCardTemplateController addCardTemplateController;

    @MockBean
    HomePageService homePageService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenCardTemplatePosted_callServiceLayerAndAddTemplateToDAO() throws Exception {
        CardTeamplate dummyTestCardTemplate = new CardTeamplate();
        dummyTestCardTemplate.setHeaderText("test one");
        dummyTestCardTemplate.setBodyText("body text");
        Mockito.doNothing().when(homePageService).addCardTemplate(dummyTestCardTemplate);


        mockMvc.perform(post("/AddCardTemplate")
        .flashAttr("CardTemplate",dummyTestCardTemplate))
                .andExpect(status().isOk());

        Mockito.verify(homePageService,Mockito.times(1)).addCardTemplate(dummyTestCardTemplate);

    }

    @Test
    public void whenAddCardTemplateControllerCalledWithModelAttribute_expect200OkAndRedirectToHomeController() throws Exception {
        CardTeamplate dummyTestCardTemplate = new CardTeamplate();
        dummyTestCardTemplate.setHeaderText("test one");
        dummyTestCardTemplate.setBodyText("body text");
        Mockito.doNothing().when(homePageService).addCardTemplate(dummyTestCardTemplate);

        mockMvc.perform(post("/AddCardTemplate")
                .flashAttr("CardTemplate",dummyTestCardTemplate))
                .andExpect(status().isOk())
                .andExpect(redirectedUrl("/"));


    }

}