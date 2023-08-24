package org.example;

import org.example.pages.utils.WebDriverHolder;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BaseTestClass {
    public WebDriver chromeDriver;

    @BeforeEach
    @CsvFileSource
    public void init() throws MalformedURLException {


        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", new File("files").getAbsolutePath());
        chromeOptions.setExperimentalOption("prefs", prefs);

        chromeDriver = new ChromeDriver(chromeOptions);

        WebDriverHolder.setWebDriver(chromeDriver);
//        chromeDriver.get(PropertiesHelper.getProperty("url"));
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @AfterEach
    public void clear() {
        chromeDriver.quit();
//        WebDriverHolder.clearWebDriver();
    }
}
