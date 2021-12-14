package com.hepsiburada.web.qa.webdriver;

import com.hepsiburada.web.qa.util.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
    private WebDriverFactory() {

    }

    public static WebDriver getInstance(BrowserType browser) {
        WebDriver webDriver;

        switch (browser) {
            default:
            case CHROME:
                setChromeDriver();
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                setFirefoxDriver();
                webDriver = new FirefoxDriver();
                break;
        }
        return webDriver;
    }

    public static void setChromeDriver() {
        String chromeBinary = "src/main/resources/chrome/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeBinary);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-agent=\"Mozilla/5.0 (WghrXkuMnF) AppleWebKit/5.0 Chrome/8.0 Safari/5.0\n\"");
        new ChromeDriver(options);
    }

    private static void setFirefoxDriver() {
        String firefoxBinary = "src/main/resources/firefox/geckodriver";
        System.setProperty("webdriver.gecko.driver", firefoxBinary);
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("user-agent=\"Mozilla/5.0 (WghrXkuMnF) AppleWebKit/5.0 Chrome/8.0 Safari/5.0\n\"");
        new FirefoxOptions(options);
    }
}