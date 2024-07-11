package com.angela.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SeleniumApplication {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        Select select = new Select(driver.findElement(By.name("my-select")));

        select.selectByIndex(1);
        textBox.sendKeys("Selenium");
//        submitButton.click();

       // WebElement message = driver.findElement(By.id("message"));
       System.out.println( textBox.getText());


//        driver.quit();
    }

}
