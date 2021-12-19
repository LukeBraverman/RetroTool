package com.retrotool.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@AutoConfigureMockMvc
@WebMvcTest(HomePageController.class)
class HomePageControllerTest {
    @InjectMocks
    HomePageController homePageController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenHomeControllerCalled_viewWithHeaderContainingStringRetroToolReturned() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("HomePage"))
                .andExpect(MockMvcResultMatchers.model().attribute("headerText", "RetroTool!"));

    }

    @Test
    public void whenHomeControllerCalled_200okReturned() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

}