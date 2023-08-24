package org.example;

import org.example.pages.LoginPage;
import org.example.pages.MainPage;
import org.example.pages.UserInformPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class UserInfoTest extends BaseTestClass{

    @Test
    public void verifyUserInfo() {
        chromeDriver.get("https://account.battle.net/login");

        new LoginPage(chromeDriver)
                .enterUserName("anton.makovetskyi@gmail.com")
                .enterPassword("Art123456!")
                .clickOnSubmitButton();

        chromeDriver.get("https://account.battle.net/details");
//                .clickOnUserInformButton()
//                .getUserInfoBlockText();
        UserInformPage userInformPage = PageFactory.initElements(chromeDriver, UserInformPage.class);

        userInformPage.menuComponent.clickOnUserInformButton();
        new MainPage().menuComponent.clickOnUserInformButton();

        Assertions.assertEquals("ЛИЧНАЯ ИНФОРМАЦИЯ", userInformPage.getUserInfoBlockText());


    }
}
