package org.example.pages.components;

import org.example.pages.BasePage;
import org.example.pages.UserInformPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuComponent extends BasePage {

    private WebElement userInformButton;

    private WebElement gamesButton;

    public MenuComponent() {

    }

    public UserInformPage clickOnUserInformButton() {
        userInformButton.click();
        return new UserInformPage();
    }
}
