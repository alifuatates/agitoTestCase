package com.hepsiburada.web.qa.steps.basketpage;

import com.hepsiburada.web.qa.pages.basketPage.BasketPage;
import com.hepsiburada.web.qa.steps.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class BasketPageSteps {
    private WebDriver webDriver;

    public BasketPageSteps() {
        webDriver = Hooks.webDriver;
    }

    @And("delete all items in the basket")
    public void deleteAllItemsInTheBasket() {
        BasketPage basketPage = new BasketPage(webDriver);
        basketPage.getAllItemDeleteBtn().click();
        basketPage.getConfirmDeleteBtn().click();

    }

    @Then("Confirm {string} content on user basket page")
    public void confirmContentOnUserBasketPage(String content) {
        BasketPage basketPage = new BasketPage(webDriver);
        String msg = basketPage.getEmptyBasketMessage().getText();
        if (msg.matches(content))
            System.out.println("No product in the basket");
        else
            System.out.println("There are product/products in the basket");

    }
}
