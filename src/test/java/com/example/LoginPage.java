package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private String userName;
    private String password;

    public LoginPage(WebDriver driver) {
        super(driver);

        String allLines = "";
        String splitCharacter = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("credentials.csv"));
            while ((allLines = br.readLine()) != null) // returns a Boolean value
            {
                String[] line = allLines.split(splitCharacter); // use comma as separator
                System.out.println("User name :" + line[0] + "password :" + line[1]);

                this.userName = line[0];
                this.password = line[1];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LoginPage SetLoginCredentials(){
        WebElement userNameInput = driver.findElement(By.id("n-input-email"));
        userNameInput.sendKeys(userName, Keys.RETURN);

        WebElement passwordInput = driver.findElement(By.id("n-input-password"));
        passwordInput.sendKeys(password, Keys.RETURN);

        By xpath = By.xpath("//img[@class='headerCheckout__logo__img']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement logoElement = driver.findElement(xpath);
        logoElement.click();

        return this;
    }
}
