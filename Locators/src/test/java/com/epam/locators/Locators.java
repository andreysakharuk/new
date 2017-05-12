package com.epam.locators;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Locators {

    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.consumerreports.org/home-services");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.name("query")).sendKeys("Painters");
        driver.findElement(By.name("postalcode")).sendKeys("10701");
        driver.findElement(By.className("porchButton")).click();
        Select dropdown = new Select(driver.findElement(By.tagName("select")));
        dropdown.selectByVisibleText("Asbestos Abatement");
        driver.findElement(By.cssSelector("li:nth-child(2)")).sendKeys("First Name");
        driver.findElement(By.xpath("//*[@placeholder='Last name']")).sendKeys("Last Name");

        driver.findElement(By.cssSelector("li:nth-child(2)")).sendKeys("Phone");
        driver.findElement(By.xpath("//*[@placeholder='Last name']")).sendKeys("Email");
        driver.findElement(By.xpath("//*[@placeholder='Last name']")).sendKeys("Address");
        driver.findElement(By.xpath("//*[@placeholder='Last name']")).sendKeys("City");
        driver.findElement(By.xpath("//*[@placeholder='Last name']")).sendKeys("ZIP");
        driver.findElement(By.xpath("//*[@placeholder='Last name']")).sendKeys("Description");
        driver.findElement(By.linkText("Learn more")).click();
        driver.findElement(By.partialLinkText("Terms of Use")).click();





    }

}
//        String userName = driver.findElement(By.xpath("//strong[@class='css-truncate-target']")).getText();
//        Assert.assertEquals(userName, "andreysakharuk");