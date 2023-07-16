package com.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }
    

    public CartPage clickContinue() {
        By xpath = By.xpath("//*[@id=\"cop-app\"]/div/div[1]/div[1]/div[2]/div/div[2]/button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement continueButton = driver.findElement(xpath);
        continueButton.click();
        return this;
    }

    public CartPage removeProductInCart(){
        By xpath = By.xpath("//button[@class='mini-cart__button -remove']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement continueButton = driver.findElement(xpath);
        continueButton.click();
        return this;
    }

    public CartPage checkCartEmpty(){
        By xpath = By.xpath("//span[@class='mini-cart__text -empty']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement cartEmptyText = driver.findElement(xpath);
        Assert.assertEquals("Sepetiniz Henüz Boş", cartEmptyText.getText());
        return this;
    }
}
