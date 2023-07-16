package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomePage() {
        driver.get("https://www.network.com.tr/");
        return this;
    }

    public HomePage searchItem(String item) {
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys(item, Keys.RETURN);
        return this;
    }

    public HomePage goToCartPage()
    {
        WebElement cartButton = driver.findElement(By.xpath("//a[@class='new-header__link -cart']"));
        cartButton.click();
        return this;
    }
}