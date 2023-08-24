package org.example.pages;

import org.example.pages.components.MenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    private final String MAIN_PAGE_URI = "https://account.battle.net/";
    private By mainContent = By.xpath("//main[@class='container main-container']");
    private By userInfoButton = By.xpath("//main[@class='container main-container']");

    public MenuComponent menuComponent;

    public MainPage openMainPage() {
        webDriver.get(MAIN_PAGE_URI);
        return this;
    }

    public MainPage() {
        this.webDriver = webDriver;
        menuComponent = new MenuComponent();
    }
    public boolean getMainContentVisibility() {
        return webDriver.findElement(mainContent).isDisplayed();
    }

    public UserInformPage clickOnUserInformButton() {
        webDriver.findElement(userInfoButton).click();
        return new UserInformPage();
    }
}
