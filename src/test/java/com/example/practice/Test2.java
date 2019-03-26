package com.example.practice;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test2 {
    @Autowired AmazonPage amazonPage;
    @Autowired GooglePage googlePage;

    @Test
    public void googleSearch() {
        googlePage.load();
        googlePage.search("bugs bunny");
        Assert.assertEquals("bugs bunny - Google Search", googlePage.getTitle());
    }

    @Test
    public void shouldGetALotOfResults() throws Exception {
        amazonPage.load();
        amazonPage.search("bunny");
        Assert.assertTrue(amazonPage.getResultCount() >= 100_000);
    }

    @Test
    public void shouldGetFewerResults() throws Exception {
        amazonPage.load();
        amazonPage.search("bugs bunny dvd");
        Assert.assertTrue(amazonPage.getResultCount() < 100_000);
    }
}
