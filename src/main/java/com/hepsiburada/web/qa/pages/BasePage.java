package com.hepsiburada.web.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/*
 * Abstract class that all pages in a UI can extend from.
 */
public abstract class BasePage {

    public WebDriverWait webDriverWait;
    protected WebDriver webDriver;

    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public WebDriver getWebDriver() {
        return webDriver;
    }
}