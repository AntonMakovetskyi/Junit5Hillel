package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class LoadingWaitTest extends BaseTestClass {
    @Test
    public void waitForHelloWorld() {
        chromeDriver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        chromeDriver.findElement(By.cssSelector("#start > button")).click();

        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        chromeDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

//        Wait<WebDriver> fluentWaiter = new FluentWait<>(chromeDriver)
//                .withTimeout(Duration.ofSeconds(5))
//                .pollingEvery(Duration.ofSeconds(1))
//                .ignoring(NoSuchElementException.class);
//
//        WebElement helloWordTextField = fluentWaiter
//                .until(webDriver -> webDriver.findElement(By.xpath("//div[@id='finish']/h4")));


        WebElement helloWordTextField = WaitersUtil.fluentWaiter(chromeDriver, By.xpath("//div[@id='finish']/h4"), Duration.ofSeconds(5));
//        WebElement helloWordTextField = chromeDriver.findElement(By.xpath("//div[@id='finish']/h4"));

        Assertions.assertTrue(helloWordTextField.isDisplayed());

    }

    @Test
    public void waitForHiddenHelloWorld() {
        chromeDriver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        chromeDriver.findElement(By.cssSelector("#start > button")).click();

        WebElement helloWorldField = WaitersUtil.fluentWaiter(chromeDriver, By.xpath("//div[@id='finish']/h4"), Duration.ofSeconds(5));

        Assertions.assertTrue(helloWorldField.isDisplayed());
    }

    @Test
    public void verifyHelloWorld() {
        chromeDriver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        chromeDriver.findElement(By.cssSelector("#start > button")).click();

        WaitersUtil.customExplicitWaiterOfLoading(chromeDriver, By.cssSelector("#loading"));
        WaitersUtil.explicitWaitOfInvisibility(chromeDriver, By.cssSelector("#loading"));

        WebElement helloWordTextField = chromeDriver.findElement(By.xpath("//div[@id='finish']/h4"));
        Assertions.assertTrue(helloWordTextField.isDisplayed());
    }
}
