package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    public enum Browser {
        CHROME,
        FIREFOX,
        EDGE,
        SAFARI
    }

    public static WebDriver createDriver(Browser browser) {
        WebDriver driver;

        switch (browser) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            case CHROME:
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }

        return driver;
    }
}
