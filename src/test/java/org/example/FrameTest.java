package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FrameTest extends BaseTestClass {
    @Test
    public void verifyFameText() {
        chromeDriver.get("https://the-internet.herokuapp.com/nested_frames");

        chromeDriver.switchTo().frame("frame-bottom");

        WebElement bodyOfFrame = chromeDriver.findElement(By.xpath("//body"));
        Assertions.assertEquals(bodyOfFrame.getText(), "BOTTOM");
        chromeDriver.switchTo().defaultContent();
    }
}
