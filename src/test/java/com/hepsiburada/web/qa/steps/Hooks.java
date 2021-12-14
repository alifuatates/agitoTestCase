package com.hepsiburada.web.qa.steps;

import com.hepsiburada.web.qa.util.BrowserType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import static com.hepsiburada.web.qa.webdriver.WebDriverFactory.getInstance;

public class Hooks {
    public static WebDriver webDriver;

    @Before
    public void openBrowser(){
        System.out.println("Opening browser");
        webDriver = getInstance(BrowserType.CHROME);
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
    }

    @After
    public void embedScreenshot(Scenario scenario){
        System.out.println("Tearing down Scenario");

        if(scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png", "URL: " + webDriver.getCurrentUrl());
            } catch (WebDriverException ScreenshotNotSupported) {
                System.err.println(ScreenshotNotSupported.getMessage());
            }
        }
        webDriver.quit();

    }
}
