package com.hepsiburada.web.qa.steps.search;

import com.hepsiburada.web.qa.pages.basketPage.BasketPage;
import com.hepsiburada.web.qa.pages.homePage.HomePage;
import com.hepsiburada.web.qa.pages.productDetailPage.ProductDetail;
import com.hepsiburada.web.qa.pages.searchPage.SearchPage;
import com.hepsiburada.web.qa.steps.Hooks;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class SearchSteps {

    private WebDriver webDriver;

    public SearchSteps() {
        webDriver = Hooks.webDriver;
    }

    @And("user {int}. product add to basket & validate the added product in the basket")
    public void userProductAddToBasketValidateTheAddedProductInTheBasket(int addBasketIndex) throws InterruptedException {
        Actions hover = new Actions(webDriver);
        SearchPage searchPage = new SearchPage(webDriver);
        ProductDetail productDetail = new ProductDetail(webDriver);
        HomePage homePage = new HomePage(webDriver);
        hover.moveToElement(searchPage.getSearchProductAddBasketBtn().get(addBasketIndex - 1)).build().perform();
        searchPage.getSearchProductAddBasketBtn().get(addBasketIndex - 1).click();
        Thread.sleep(2000);

        webDriver.getWindowHandles().forEach(tab->webDriver.switchTo().window(tab));
        productDetail.getBasketBtn().click();
        String productTitle = productDetail.getProductTitle().getText();
        System.out.println("ITEM IN SEARCH LIST: "+productTitle);

        homePage.getBasketBtn().click();
        BasketPage basketPage = new BasketPage(webDriver);
        String productTitleToBasket = basketPage.getBasketProductTitle().getText();
        System.out.println("ITEM IN THE BASKET: "+productTitleToBasket);

        if (productTitle.matches(productTitleToBasket))
            System.out.println("The correct item has been added to the cart");
        else
            System.out.println("The false item has been added to the cart");
        webDriver.navigate().back();
    }


    @And("user click basket and go to basket page")
    public void userClickBasketAndGoToBasketPage() throws InterruptedException {
        HomePage homePage = new HomePage(webDriver);
        homePage.getBasketBtn().click();
        Thread.sleep(3000);

    }

}
