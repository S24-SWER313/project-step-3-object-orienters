package com.angela.selenium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;

public class NokiaTest {
    private static WebDriver driver;

    @BeforeAll
    public static void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().deleteCookieNamed ("CONSENT");
        driver.manage().addCookie(new Cookie("CONSENT","YES+shp.gws-"+ LocalDate.now().toString().replace("-","")+"-0-RC2.en+FX+374"));
        driver.get("https://www.hmd.com/en_us/nokia-c-300/buy");
//        driver.navigate().refresh();
    }

     @Test
        public void testNokiaPage() {
            NokiaPage nokiaPage = new NokiaPage(driver);

            nokiaPage.clickUnlockedCarrier();
            nokiaPage.clickCheckoutBtn();
            int count = nokiaPage.BuyFromBtnsCount();
            assert count == 2;
        }
}
