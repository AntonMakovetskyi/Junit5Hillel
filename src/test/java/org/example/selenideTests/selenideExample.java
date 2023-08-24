package org.example.selenideTests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;


public class selenideExample {

    @Test
    public void selenideTest() {
        Configuration.baseUrl="http://google.com";
//        Configuration.browser="firefox";
        Configuration.screenshots=true;
        Configuration.timeout=5000;
//        Configuration.holdBrowserOpen=true;


        Selenide.open("/edit");

        SelenideElement testElement = $("");
        $x("");
        $(By.tagName(""));

        ElementsCollection elements = $$("");
        $$x("");
        $$(By.id(""));


        testElement
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .shouldBe(Condition.hidden)
                .dragAndDrop(DragAndDropOptions.to(""));

//        Selenide.actions().doubleClick().pause().build().perform();
        Selenide.executeJavaScript("");


        elements.filter(Condition.visible).exclude(Condition.disabled).shouldHave(texts("test"));





    }
}
