package com.hepsiburada.web.qa.steps.homepage;

import com.hepsiburada.web.qa.pages.homePage.HomePage;
import com.hepsiburada.web.qa.steps.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class HomepageSteps {

    private WebDriver webDriver;

    public HomepageSteps() {
        webDriver = Hooks.webDriver;
    }

    @And("Type {string} product in the search field and search")
    public void typeProductInTheSearchFieldAndSearch(String product) {
        HomePage homePage = new HomePage(webDriver);
        homePage.getSearchArea().sendKeys(product);
        homePage.getSearchBtn().click();
    }

    @Then("user check product count")
    public void userCheckProductCount() {

    }

    @And("user select {string} category")
    public void userSelectCategory(String string) {
        HomePage homePage = new HomePage(webDriver);
        homePage.getSelectCategory(string).click();
    }

    @And("user select {string} subcategory")
    public void userSelectSubcategory(String string) {
        Actions hover = new Actions(webDriver);
        HomePage homePage = new HomePage(webDriver);
        hover.moveToElement(homePage.getSelectSubCategory(string)).build().perform();
    }

    @And("user select {string} product on subcategory")
    public void userSelectProductOnSubcategory(String string) {
        HomePage homePage = new HomePage(webDriver);
        homePage.getSelectSubCategoryProduct(string).click();

    }
}
