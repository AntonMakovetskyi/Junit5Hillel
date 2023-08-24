package org.example;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxTest extends BaseTestClass {

    @Test
    public void checkAllCheckboxes() {
        chromeDriver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = chromeDriver.findElements(By.xpath("//input"));

        for (WebElement chkbox: checkboxes) {
            if(chkbox.isSelected()) {
                chkbox.click();
            }
        }
    }

    @Test
    public void checkAllCheckboxesByAttribute() {
        chromeDriver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = chromeDriver.findElements(By.xpath("//input"));

        for (WebElement chkbox: checkboxes) {
            if(chkbox.getAttribute("checked") == null) {
                chkbox.click();
            }
        }
    }

}
