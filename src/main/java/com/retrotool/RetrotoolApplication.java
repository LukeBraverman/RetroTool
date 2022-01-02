package com.retrotool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetrotoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetrotoolApplication.class, args);
    }

}

/*
TODO: ADD 2 more colums, one negativem, one neutral
TODO: Ensure service layer sorts list and returns only positive/nagative/neutral in 3 seperate methods
 */