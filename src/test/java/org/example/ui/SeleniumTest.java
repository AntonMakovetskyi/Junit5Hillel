package org.example.ui;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.example.LoggerExample;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.logging.Logger;

@Epic("UI Testing")
@Feature("Auth tests")
public class SeleniumTest {

    static Logger log = LoggerExample.LOGGER;
    static WebDriver chromeDriver;

    @BeforeAll
    public static void init() {
        chromeDriver = new ChromeDriver();
    }

    @BeforeEach
    public void openStartPage() {
        chromeDriver.get("https://account.battle.net/");
    }

    @Test
    public void verifyLogin() throws InterruptedException {
        enterUserName("anton.makovetskyi@gmail.com");
        enterPassword("Art123456!");
        clickSubmitButton();
        Thread.sleep(5000);
        WebElement welcomePage = chromeDriver.findElement(By.className("title-and-error-container"));
        Assertions.assertTrue(welcomePage.isDisplayed());

    }

    @Test
    public void verifyLoginNegative() throws InterruptedException {
        enterUserName("anton.makovetskyi@gmail.com1");
        enterPassword("Art123zsc456!");
        clickSubmitButton();
        WebElement welcomePage = chromeDriver.findElement(By.cssSelector(".grid-container.wrapper"));
        Assertions.assertTrue(welcomePage.isDisplayed());
    }

    @Test
    @Story("This is a Fail Story.")
    public void verifyWindowHandle() {
        chromeDriver.navigate().to("https://www.google.com.ua/");
        chromeDriver.navigate().back();
        chromeDriver.navigate().forward();
        chromeDriver.navigate().refresh();

        chromeDriver.getWindowHandle();
    }



    public void enterUserName(String userName) throws InterruptedException {
        Thread.sleep(3000);
        log.info("User Added");
        WebElement usernameField = chromeDriver.findElement(By.cssSelector("#accountName"));
        usernameField.clear();
        usernameField.sendKeys(userName);
    }

    public void enterPassword(String pass) {
        WebElement passwordField = chromeDriver.findElement(By.cssSelector("input[title='Пароль']"));
        passwordField.clear();
        passwordField.sendKeys(pass);
    }

    public void clickSubmitButton() {
        WebElement loginButton = chromeDriver.findElement(By.xpath("//button[contains(text(), 'Авторизоваться')]"));
        loginButton.click();
    }

    @AfterAll
    public static void clear() {
        chromeDriver.quit();
    }


}
