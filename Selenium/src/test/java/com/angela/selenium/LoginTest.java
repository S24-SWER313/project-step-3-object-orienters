package com.angela.selenium;

import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    private String validUsername = "username";
    private String validPassword = "password";

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickSubmitButton();

        String text = getDriver().switchTo().alert().getText();


        assert "You have successfully logged in.".equals(text);

    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterUsername("invalid");
        loginPage.enterPassword("invalid");
        loginPage.clickSubmitButton();

        String text = getDriver().switchTo().alert().getText();

        assert !"You have successfully logged in.".equals(text);

    }


}
