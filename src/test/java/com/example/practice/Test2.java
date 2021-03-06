package com.example.practice;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Test2 {
    @Autowired AmazonPage amazonPage;
    @Autowired GooglePage googlePage;

    @Test
    @Tag("auto")
    void googleSearch() {
        googlePage.load();
        googlePage.search("bugs bunny");
        Assertions.assertEquals("bugs bunny - Google Search", googlePage.getTitle());
    }

    @Test
    @Tag("auto")
    void shouldGetALotOfResults() throws Exception {
        amazonPage.load();
        amazonPage.search("bunny");
        Assertions.assertTrue(amazonPage.getResultCount() >= 100_000);
    }

    @Test
    @Tag("auto")
    void shouldGetFewerResults() throws Exception {
        amazonPage.load();
        amazonPage.search("bugs bunny dvd");
        Assertions.assertTrue(amazonPage.getResultCount() < 100_000);
    }
}
