package com.angela.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    private static WebDriver driver;

    @BeforeAll
    public static void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/login.html");
    }

//    @AfterAll
//    public static void TearDown() {
//        if (driver != null)
//            driver.quit();
//    }

    public WebDriver getDriver() {
        return driver;
    }
}
