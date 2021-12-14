package com.hepsiburada.web.qa.pages.basketPage;

import com.hepsiburada.web.qa.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class BasketPage extends BasePage {

    @FindBy(id = "edit_basket_button")
    private  WebElement editBasketBtn;

    @FindBy(className = "delete_all_2uTds")
    private WebElement allItemDeleteBtn;

    @FindBy(className = "red_3m-Kl")
    private WebElement confirmDeleteBtn;

    @FindBy(css = ".product_name_3Lh3t > a")
    private WebElement basketProductTitle;

    @FindBy(css = ".content_Z9h8v > h1")
    private WebElement emptyBasketMessage;

    public BasketPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
}

