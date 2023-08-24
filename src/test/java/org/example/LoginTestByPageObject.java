package org.example;

import org.example.pages.LoginPage;
import org.example.pages.utils.WebDriverHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LoginTestByPageObject extends BaseTestClass{
    @Test
    public void verifyLogin() {
        WebDriverHolder.getWebDriver().get("https://account.battle.net/login");

        boolean loginIsSuccess = new LoginPage(WebDriverHolder.getWebDriver())
                .enterUserName("anton.makovetskyi@gmail.com")
                .enterPassword("Art123456!")
                .clickOnSubmitButton()
                .getMainContentVisibility();

        Assertions.assertTrue(loginIsSuccess);
    }
}
