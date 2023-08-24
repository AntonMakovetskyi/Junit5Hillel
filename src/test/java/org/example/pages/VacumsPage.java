package org.example.pages;

import org.example.pages.components.ProductComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VacumsPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//li[@class='catalog-grid__cell catalog-grid__cell_type_slim ng-star-inserted']")
    private List<WebElement> vacums;

    public VacumsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getPriceOfVacum(int idOfVacum) {
        return new ProductComponent(vacums.get(idOfVacum)).getPrice();
    }
}
