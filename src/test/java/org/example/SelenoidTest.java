package org.example;

import org.example.pages.utils.WebDriverHolder;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class SelenoidTest {

    @Test
    public void testSelenoid() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();


        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable video recording */
//            put("enableVideo", true);
            put("enableVNC", true);
            put("enableLog", true);
            put("screenResolution", "1280x1024x24");
        }});
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

        WebDriverHolder.setWebDriver(driver);
        System.out.println("Selenoid test!!!!!!!!!!!!!!!!!!!!!!");
        driver.get("http://google.com");


//        FirefoxOptions optionsFF = new FirefoxOptions();
//        optionsFF.setCapability("browserVersion", "115.0");
//        optionsFF.setCapability("selenoid:options", new HashMap<String, Object>() {{
//            /* How to add test badge */
//            put("name", "Test badge...");
//
//            /* How to set session timeout */
//            put("sessionTimeout", "15m");
//
//            /* How to set timezone */
//            put("env", new ArrayList<String>() {{
//                add("TZ=UTC");
//            }});
//
//            /* How to add "trash" button */
//            put("labels", new HashMap<String, Object>() {{
//                put("manual", "true");
//            }});
//
//            /* How to enable video recording */
////            put("enableVideo", true);
//            put("enableVNC", true);
//        }});
//        RemoteWebDriver driverFF = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), optionsFF);
//
//        driverFF.get("http://google.com");
//
//        driverFF.quit();
    }
}
