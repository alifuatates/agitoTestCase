package com.hepsiburada.web.qa.pages.searchPage;

import com.hepsiburada.web.qa.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class SearchPage extends BasePage {

    @FindBys({
            @FindBy(className = "productListContent-innerWrapper"),
            @FindBy(className = "productListContent-item")
    })
    private List<WebElement> searchProductAddBasketBtn;


    public SearchPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }
}
