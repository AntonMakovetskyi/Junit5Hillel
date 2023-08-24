package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitersUtil {

    public static WebElement fluentWaiter(WebDriver webDriver, By by, Duration durationOfWaiting) {
        Wait<WebDriver> fluentWaiter = new FluentWait<>(webDriver)
                .withTimeout(durationOfWaiting)
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        return fluentWaiter
                .until(driver -> driver.findElement(by));
    }

    public static WebElement explicitWait(WebDriver webDriver, By by) {
        WebDriverWait explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void explicitWaitOfInvisibility(WebDriver webDriver, By by) {
        WebDriverWait explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void customExplicitWaiterOfLoading(WebDriver webDriver, By by) {
        WebDriverWait explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        explicitWait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return webDriver.findElements(by).size() > 0;
            }
        });
    }


}
