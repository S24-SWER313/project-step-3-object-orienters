package com.angela.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private WebElement usernameBox;
    private WebElement passwordBox;
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.usernameBox = driver.findElement(By.name("username"));
        this.passwordBox = driver.findElement(By.name("password"));
        this.submitButton = driver.findElement(By.id("login-form-submit"));
    }

    public void enterUsername(String username) {
        usernameBox.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordBox.sendKeys(password);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
