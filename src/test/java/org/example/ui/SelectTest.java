package org.example.ui;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.example.BaseTestClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@Epic("UI Testing")
public class SelectTest extends BaseTestClass {

    @Feature("Select tests")
    @Test
    public void verifyOptions() {
        chromeDriver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement webElement = chromeDriver.findElement(By.cssSelector("#dropdown"));

        Select ourDropdown = new Select(webElement);

        ourDropdown.selectByVisibleText("Option 2");

        ourDropdown.getOptions();
    }
}
