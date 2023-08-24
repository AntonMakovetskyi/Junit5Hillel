package org.example.pages;

import org.example.pages.components.MenuComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class UserInformPage extends BasePage {

    private WebElement parentElement;

    public MenuComponent menuComponent;

    @FindBy(xpath = "//h3[text()='Личная информация']")
    @CacheLookup
    private WebElement userInfoBlock;

    @FindBy(xpath = "//div[@id='personal-info-card']//a[@class='card-header-link float-md-right']")
    private WebElement replaceButton;

    @FindAll({@FindBy(id = "test"), @FindBy(xpath = "test")})
    private List<WebElement> listOfElements;

    public UserInformPage() {

        menuComponent = new MenuComponent();
    }

//    public WebElement getUserInfoBlock() {
////        return webDriver.findElement()
//    }

    public String getUserInfoBlockText() {
        return parentElement.getText();
    }
}
