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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@WebMvcTest(AddCardTemplateController.class)
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
        CardTemplate dummyTestCardTemplate = new CardTemplate();
        dummyTestCardTemplate.setHeaderText("test one");
        dummyTestCardTemplate.setBodyText("body text");
        dummyTestCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);
        Mockito.doNothing().when(homePageService).addCardTemplate(dummyTestCardTemplate);


        mockMvc.perform(post("/AddCardTemplate")
        .flashAttr("CardTemplate",dummyTestCardTemplate));

        Mockito.verify(homePageService,Mockito.times(1)).addCardTemplate(dummyTestCardTemplate);

    }

    @Test
    public void whenAddCardTemplateControllerCalledWithModelAttribute_expect301OkAndRedirectToHomeController() throws Exception {
        CardTemplate dummyTestCardTemplate = new CardTemplate();
        dummyTestCardTemplate.setHeaderText("test one");
        dummyTestCardTemplate.setBodyText("body text");
        dummyTestCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);

        Mockito.doNothing().when(homePageService).addCardTemplate(dummyTestCardTemplate);

        mockMvc.perform(post("/AddCardTemplate")
                .flashAttr("CardTemplate",dummyTestCardTemplate))
                .andExpect(redirectedUrl("/"));


    }

}