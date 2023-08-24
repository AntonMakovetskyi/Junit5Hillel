package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.stream.Stream;

public class DraganddropTest extends BaseTestClass {
    @Test
    public void testDrgAndDr() {
        chromeDriver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement blockA = chromeDriver.findElement(By.id("column-a"));
        WebElement blockB = chromeDriver.findElement(By.id("column-b"));

        Actions actions = new Actions(chromeDriver);

        actions
                .dragAndDrop(blockA, blockB)
                .build()
                .perform();
    }
}
