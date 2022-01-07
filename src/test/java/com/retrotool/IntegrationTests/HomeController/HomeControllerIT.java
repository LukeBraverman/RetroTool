package com.retrotool.IntegrationTests.HomeController;

import com.retrotool.controller.HomePageController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    HomePageController homePageController;



    @Test
    public void whenHomeControllerCalled_ContextLoads() {
        this.restTemplate.getForObject("/", String.class);
    }
}
