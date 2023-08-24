package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtonTest extends BaseTestClass {

    @Test
    public void setYesRadiobtn() {
        chromeDriver.get("https://demoqa.com/radio-button");

        List<WebElement> radioButtons = chromeDriver.findElements(By.xpath("//input[@type='radio']"));

        for (WebElement radbtn : radioButtons) {
            if(!radbtn.isSelected() && radbtn.isEnabled()) {

                JavascriptExecutor jsExecutor = (JavascriptExecutor) chromeDriver;
                jsExecutor.executeScript("arguments[0].click();", radbtn);
//                radbtn.click();
            }
        }

    }
}
