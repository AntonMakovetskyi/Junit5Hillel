package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {
    static WebDriver chromeDriver;

    private String buttonGeneralLocator = "//button[text() = '%s']";

    @BeforeAll
    public static void init() {
        chromeDriver = new ChromeDriver();
    }

    @BeforeEach
    public void openStartPage() {
        chromeDriver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void verifyJSAlert() {
        clickOnJsAlert("Click for JS Alert");

        Alert jsAlert = chromeDriver.switchTo().alert();
        Assertions.assertEquals("I am a JS Alert", jsAlert.getText());
        jsAlert.accept();
    }

    @Test
    public void verifyJSConfirm() {
        clickOnJsAlert("Click for JS Confirm");
        Alert jsAlert = chromeDriver.switchTo().alert();
        Assertions.assertEquals("I am a JS Confirm", jsAlert.getText());
        jsAlert.dismiss();
    }

    @Test
    public void verifyJSPrompt() {
        clickOnJsAlert("Click for JS Prompt");
        Alert jsAlert = chromeDriver.switchTo().alert();
        Assertions.assertEquals("I am a JS prompt", jsAlert.getText());
        jsAlert.sendKeys("Anton");
        jsAlert.accept();
    }

    @Test
    public void verifyJsAlertScripted() {
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) chromeDriver;
//        clickOnJsAlert("Click for JS Alert");
//        javascriptExecutor.executeScript("return jsAlert();");
        pressJSAlertButtonByScript();
    }

    private void pressJSAlertButtonByScript() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) chromeDriver;
        WebElement jsAlertButton = clickOnJsAlert("Click for JS Alert");
        javascriptExecutor.executeScript("return arguments[0].click();", jsAlertButton);
    }

    private WebElement clickOnJsAlert(String buttonText) {
        String jsAlertLocator = String.format(buttonGeneralLocator, buttonText);
        return chromeDriver.findElement(By.xpath(jsAlertLocator));
    }


    @AfterAll
    public static void clear() {
        chromeDriver.quit();
    }
}
