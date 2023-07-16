package com.example;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage selectFirstProduct() {
        By xpath = By.xpath("//div[@class='row heroGrid']/div");
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement firstProduct = driver.findElement(xpath);
        firstProduct.click();
        return this;
    }

    public ProductPage addToCart() {
        By xpath = By.xpath("//button[@class='product__button -addToCart btn -black']");
        WebElement addToCartButton = driver.findElement(xpath);
        addToCartButton.click();
        return this;
    }

    public ProductPage selectSize() {
        By xpath = By.xpath("//div[@class='product__content -sizes']/div");
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(xpath));
        Random random = new Random();
        List<WebElement> rastgeleBedenListesi = driver
                .findElements(xpath);
        int randomNumber = random.nextInt(rastgeleBedenListesi.size());

        WebElement secilenBeden = rastgeleBedenListesi.get(randomNumber);
        secilenBeden.click();
        return this;
    }

    public ProductPage goToCart() {
        By xpath = By.xpath("//a[@class='button -primary -block mini-cart__button -goToCart']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement goToCartButton = driver.findElement(xpath);
        goToCartButton.click();
        return this;
    }
}
