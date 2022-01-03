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

@WebMvcTest(AddNegativeCardTemplate.class)
@ExtendWith(MockitoExtension.class)
class AddNegativeCardTemplateTest {
    @InjectMocks
    AddNegativeCardTemplate addNegativeCardTemplate;

    @MockBean
    HomePageService homePageService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenAddNegativeCardTemplateControllerCalledWithModelAttribute_expect301OkAndRedirectToHomeController() throws Exception {
        CardTemplate dummyTestCardTemplate = new CardTemplate();
        dummyTestCardTemplate.setHeaderText("test one");
        dummyTestCardTemplate.setBodyText("body text");
        dummyTestCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEGATIVE);

        Mockito.doNothing().when(homePageService).addCardTemplate(dummyTestCardTemplate);

        mockMvc.perform(post("/AddNegativeCardTemplate")
                .flashAttr("CardTemplate",dummyTestCardTemplate))
                .andExpect(redirectedUrl("/"));
    }

    @Test
    public void whenCardTemplatePosted_cardTemplateGetsSetANegativeEnumType() throws Exception {
        CardTemplate dummyTestCardTemplate = new CardTemplate();
        dummyTestCardTemplate.setHeaderText("test one");
        dummyTestCardTemplate.setBodyText("body text");

        Mockito.doNothing().when(homePageService).addCardTemplate(dummyTestCardTemplate);

        mockMvc.perform(post("/AddNegativeCardTemplate")
                .flashAttr("CardTemplate",dummyTestCardTemplate));

        assertEquals(TypeOfCardTemplate.NEGATIVE,dummyTestCardTemplate.getTypeOfCardTemplate());
    }

    @Test
    public void whenCardTemplatePosted_callServiceLayerAndAddTemplateToDAO() throws Exception {
        CardTemplate dummyTestCardTemplate = new CardTemplate();
        dummyTestCardTemplate.setHeaderText("test one");
        dummyTestCardTemplate.setBodyText("body text");
        dummyTestCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.NEGATIVE);
        Mockito.doNothing().when(homePageService).addCardTemplate(dummyTestCardTemplate);


        mockMvc.perform(post("/AddNegativeCardTemplate")
                .flashAttr("CardTemplate",dummyTestCardTemplate));

        Mockito.verify(homePageService,Mockito.times(1)).addCardTemplate(dummyTestCardTemplate);

    }
}