package com.hepsiburada.web.qa.pages.productDetailPage;

import com.hepsiburada.web.qa.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class ProductDetail extends BasePage {

    @FindBy(id = "addToCart")
    private WebElement basketBtn;

    @FindBy(id = "product-name")
    private WebElement productTitle;


    public ProductDetail(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }
}
