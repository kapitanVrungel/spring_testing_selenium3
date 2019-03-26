package com.example.practice;

import org.openqa.selenium.WebDriver;

public class YahooPage extends PageObject {
    public YahooPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getPage() {
        return "http://www.yahoo.com";
    }
}
