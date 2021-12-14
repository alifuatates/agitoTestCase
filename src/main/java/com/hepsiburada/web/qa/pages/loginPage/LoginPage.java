package com.hepsiburada.web.qa.pages.loginPage;

import com.hepsiburada.web.qa.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LoginPage extends BasePage {

    @FindBy(id = "myAccount")
    private WebElement myAccount;

    @FindBy(id = "login")
    private WebElement loginPageBtn;

    @FindBy(id = "txtUserName")
    private WebElement loginUserName;

    @FindBy(name = "password")
//    @FindBy(id = "txtPassword")
    private WebElement loginUserPass;

    @FindBy(id = "btnLogin")
    private WebElement loginBtn;

    @FindBy(id = "btnEmailSelect")
    private WebElement passwordEnterAndLoginBtn;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

}
