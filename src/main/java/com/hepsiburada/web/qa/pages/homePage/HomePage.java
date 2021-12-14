package com.hepsiburada.web.qa.pages.homePage;

import com.hepsiburada.web.qa.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class HomePage extends BasePage {

    @FindBy(className = "desktopOldAutosuggestTheme-input")
    private WebElement searchArea;

    @FindBy(css = ".sf-MenuItems-1Sj7h > li > span > span ")
    private List<WebElement> selectCategoryBar;
    public WebElement getSelectCategory (String string) {
        for (int i = 0; i < selectCategoryBar.size(); i++) {
            if ( selectCategoryBar.get(i).getText().matches(string)){
                return selectCategoryBar.get(i);
            }
        }
        return  null;
    }

    @FindBy(css = ".sf-ChildMenuItems-3VA7f > div > ul > li > a ")
    private List<WebElement> selectSubCategory;
    public WebElement getSelectSubCategory (String string) {
        for (int i = 0; i < selectSubCategory.size(); i++) {
            if ( selectSubCategory.get(i).getText().matches(string)){
                return selectSubCategory.get(i);
            }
        }
        return  null;
    }

    @FindBy(css = ".sf-ChildMenuItems-VRuN- > li > ul > li > a ")
    private List<WebElement> selectSubCategoryProduct;
    public WebElement getSelectSubCategoryProduct (String string) {
        for (int i = 0; i < selectSubCategoryProduct.size(); i++) {
            if ( selectSubCategoryProduct.get(i).getText().matches(string)){
                return selectSubCategoryProduct.get(i);
            }
        }
        return  null;
    }


    @FindBy(className = "SearchBoxOld-buttonContainer")
    private WebElement searchBtn;

    @FindBy(id = "shoppingCart")
    private WebElement basketBtn;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

}