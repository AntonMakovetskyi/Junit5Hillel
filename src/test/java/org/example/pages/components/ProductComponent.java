package org.example.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductComponent {

    private WebElement parentElement;

    private WebElement titleOfProduct;

    private WebElement priceOfProduct;

    public ProductComponent(WebElement parenElement) {
        this.parentElement = parenElement;
    }

    public String getTitle() {
        return parentElement.findElement(By.cssSelector(".goods-tile__title")).getText();
    }

    public String getPrice() {
        return parentElement.findElement(By.cssSelector(".goods-tile__price-value")).getText();
    }
}
