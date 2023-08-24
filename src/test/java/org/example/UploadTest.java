package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;


public class UploadTest extends BaseTestClass{

    @Test
    public void uploadTest() throws IOException {
        chromeDriver.get("https://the-internet.herokuapp.com/upload");
        File file = new File("files/file1.txt");
        chromeDriver.findElement(By.cssSelector("#file-upload")).sendKeys(file.getAbsolutePath());
    }
}
