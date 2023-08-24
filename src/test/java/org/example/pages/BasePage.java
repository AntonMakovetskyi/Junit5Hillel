package org.example.pages;

import org.example.pages.utils.WebDriverHolder;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public WebDriver webDriver;

    public BasePage( ) {
        this.webDriver = WebDriverHolder.getWebDriver();
    }
}
