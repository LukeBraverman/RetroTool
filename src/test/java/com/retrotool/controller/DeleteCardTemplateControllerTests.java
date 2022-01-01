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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@WebMvcTest(DeleteCardTemplateController.class)
@ExtendWith(MockitoExtension.class)
public class DeleteCardTemplateControllerTests {

    @InjectMocks
    DeleteCardTemplateController deleteCardTemplateController;

    @MockBean
    HomePageService homePageService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenCardTemplateDeleted_redirectToHomeController() throws Exception {
        CardTeamplate dummyTestCardTemplate = new CardTeamplate();
        dummyTestCardTemplate.setHeaderText("test one");
        dummyTestCardTemplate.setBodyText("body text");
        dummyTestCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);

        Mockito.doNothing().when(homePageService).deleteCardTemplate(dummyTestCardTemplate);

        mockMvc.perform(get("/DeleteCardTemplate")
                .flashAttr("CardTemplate",dummyTestCardTemplate))
                .andExpect(redirectedUrl("/"));
    }

    @Test
    public void whenCardTemplateDeleted_CallServiceLayerAndDeleteCardTemplateFromDao() throws Exception {
        CardTeamplate dummyTestCardTemplate = new CardTeamplate();
        dummyTestCardTemplate.setHeaderText("test one");
        dummyTestCardTemplate.setBodyText("body text");
        dummyTestCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);

        Mockito.doNothing().when(homePageService).deleteCardTemplate(dummyTestCardTemplate);

        mockMvc.perform(get("/DeleteCardTemplate")
                .flashAttr("CardTemplate",dummyTestCardTemplate));

        Mockito.verify(homePageService,Mockito.times(1)).deleteCardTemplate(dummyTestCardTemplate);

    }



}
