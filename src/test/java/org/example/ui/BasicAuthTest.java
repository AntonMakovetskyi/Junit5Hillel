package org.example.ui;

import io.qameta.allure.*;
import org.example.BaseTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Epic("UI Testing")
public class BasicAuthTest extends BaseTestClass {

    @Feature("Auth tests")
    @Flaky
    @Link(name = "test link", url = "http://google.com")
    @Issue(value = "DEF-243")
    @TmsLink(value = "TC-101")
    @Owner("Anton")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void testBasicAuth() {
        chromeDriver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        WebElement contentTextField = chromeDriver.findElement(By.xpath("//p"));

        Assertions.assertNotEquals("Congratulations! You must have the proper credentials.", contentTextField.getText());
    }
}
