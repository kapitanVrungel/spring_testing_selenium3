package com.example.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class PageObject {
    WebDriver driver;
    @Autowired WebDriverWait wait;

    @Autowired
    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void load() {
        driver.get(getPage());
    }

    protected abstract String getPage();
}
