package com.example;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class NetworkTest {
    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;
    private LoginPage loginPage;

    public NetworkTest() {
        WebDriverInit driverInit = new WebDriverInit();
        this.driver = driverInit.getDriver();
        this.homePage = new HomePage(driver);
        this.productPage = new ProductPage(driver);
        this.cartPage = new CartPage(driver);
        this.loginPage = new LoginPage(driver);
    }

    @Test
    public void runTest() throws InterruptedException {
        try {
            homePage.goToHomePage().searchItem("ceket");
            wait(5000);
            productPage.selectFirstProduct().selectSize().addToCart().goToCart();
            wait(5000);
            cartPage.clickContinue();
            wait(5000);
            loginPage.SetLoginCredentials();
            wait(5000);
            homePage.goToCartPage();
            wait(5000);
            cartPage.removeProductInCart().checkCartEmpty();
            wait(5000);
        } finally {
            driver.quit();
        }
    }

    public void wait(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}