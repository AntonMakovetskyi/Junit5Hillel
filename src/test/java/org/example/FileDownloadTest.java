package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FileDownloadTest extends BaseTestClass{

    @Test
    public void testDownload() {
        chromeDriver.get("https://the-internet.herokuapp.com/download");
        chromeDriver.findElement(By.linkText("some-file.txt")).click();

    }
}
