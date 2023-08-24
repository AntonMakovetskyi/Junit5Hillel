package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private By userNameInputField = By.id("accountName");
    private By passwordInputField = By.id("password");
    private By submitButton = By.id("submit");

    private WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;

        if (!driver.getTitle().equals("Авторизация в Battle.net")) {
            throw new IllegalStateException("Wrong page!!!");
        }
    }

    public LoginPage enterUserName(String userName) {
        driver.findElement(userNameInputField).sendKeys(userName);
        return this;
    }
    public LoginPage enterPassword(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
        return this;
    }

    public MainPage clickOnSubmitButton() {
        driver.findElement(submitButton).click();
        return new MainPage();
    }
}
