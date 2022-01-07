package com.retrotool.UnitTests.controller;


import com.retrotool.controller.DeleteCardTemplateController;
import com.retrotool.dao.CardTemplate;
import com.retrotool.dao.TypeOfCardTemplate;
import com.retrotool.service.HomePageService;
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
        CardTemplate dummyTestCardTemplate = new CardTemplate();
        dummyTestCardTemplate.setHeaderText("test one");
        dummyTestCardTemplate.setBodyText("body text");
        dummyTestCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);

        Mockito.doNothing().when(homePageService).deleteCardTemplateWithGivenUUID(dummyTestCardTemplate.uuid);

        mockMvc.perform(get("/DeleteCardTemplate")
                .param("uuidOfCardTemplateToDelete", String.valueOf(dummyTestCardTemplate.getUuid())))
                .andExpect(redirectedUrl("/"));
    }

    @Test
    public void whenCardTemplateDeleted_CallServiceLayerAndDeleteCardTemplateFromDao() throws Exception {
        CardTemplate dummyTestCardTemplate = new CardTemplate();
        dummyTestCardTemplate.setHeaderText("test one");
        dummyTestCardTemplate.setBodyText("body text");
        dummyTestCardTemplate.setTypeOfCardTemplate(TypeOfCardTemplate.POSITIVE);

        Mockito.doNothing().when(homePageService).deleteCardTemplateWithGivenUUID(dummyTestCardTemplate.uuid);

        mockMvc.perform(get("/DeleteCardTemplate")
                .param("uuidOfCardTemplateToDelete", String.valueOf(dummyTestCardTemplate.getUuid())));

        Mockito.verify(homePageService,Mockito.times(1)).deleteCardTemplateWithGivenUUID(dummyTestCardTemplate.uuid);

    }



}
