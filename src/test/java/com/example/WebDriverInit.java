package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverInit {
    private WebDriver driver;
    private Properties prop;

    public WebDriverInit() {
        prop = new Properties();
        String fileName = "app.config";

        try (FileInputStream fis = new FileInputStream(fileName)) {

            prop.load(fis);
            System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome.driver.path"));
            driver = new ChromeDriver();
        } catch (IOException ex) {
            System.out.println("File not found: " + fileName);
        } finally {
            driver = DriverFactory.createDriver(DriverFactory.Browser.CHROME);
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
