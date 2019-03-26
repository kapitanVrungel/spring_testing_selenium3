package com.example.practice;

import com.google.common.base.Predicate;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class GooglePage extends PageObject {
    @FindBy(name="q") WebElement searchBox;

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getPage() {
        return "http://www.google.com";
    }

    public void search(String string) {
        searchBox.clear();
        searchBox.sendKeys(string);
        searchBox.submit();
    }

    public String getTitle() {
        wait.until((Predicate<WebDriver>) d -> d.getTitle().startsWith("bugs bunny"));
        return driver.getTitle();
    }
}
