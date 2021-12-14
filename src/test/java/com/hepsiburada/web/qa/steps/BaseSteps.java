package com.hepsiburada.web.qa.steps;

import com.hepsiburada.web.qa.pages.loginPage.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
//    TEST_USER_EMAIL=testuserautomationa@gmai.com TEST_USER_PASSWORD=testuserautomation123A ./mvnw clean test

    private WebDriver webDriver;
    private String loginUserName = System.getenv("testuserautomationa@gmai.com");
    private String loginPassword = System.getenv("testuserautomation123A");


    public BaseSteps() {
        webDriver = Hooks.webDriver;
    }

    @Given("I navigate to hepsiburada.com homepage")
    public void iNavigateToHepsiburadaHomepage() {
        System.out.println("I navigate to hepsiburada.com homepage");
        String url = "https://www.hepsiburada.com";
        webDriver.get(url);
    }

    @When("user login system")
    public void userLoginSystem() throws InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.getMyAccount().click();
        Thread.sleep(3000);
        loginPage.getLoginPageBtn().click();
        Thread.sleep(3000);
        loginPage.getLoginUserName().click();
        loginPage.getLoginUserName().sendKeys("testuserautomationa@gmai.com");
        loginPage.getLoginBtn().click();
        loginPage.getLoginUserPass().click();
        loginPage.getLoginUserPass().sendKeys("testuserautomation123A");
        loginPage.getPasswordEnterAndLoginBtn().click();
        Thread.sleep(3000);
    }

    @Then("the page must have {string} content")
    public void thePageMustHaveContent(String content) {
        Assert.assertTrue(webDriver.getPageSource().contains(content));
    }
}
