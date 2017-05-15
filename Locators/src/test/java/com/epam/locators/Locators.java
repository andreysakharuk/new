package com.epam.locators;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

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
        driver.findElement(By.cssSelector("[name=firstName]")).sendKeys("First Name");
        driver.findElement(By.cssSelector("[name=lastName]")).sendKeys("Last Name");
        driver.findElement(By.cssSelector("ul > li:nth-child(4) > div > div > input"))
            .sendKeys("Phone");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Email");
        driver.findElement(By.xpath("//*[@name='address1']")).sendKeys("Address");
        driver.findElement(By.xpath("//input[@placeholder='City']")).sendKeys("City");
        Select dropdown2 = new Select(driver.findElement(By.name("state")));
        dropdown2.selectByValue("AL");
        driver.findElement(By.xpath("//*[@placeholder='Zip']")).sendKeys("ZIP");
        driver.findElement(By.tagName("textarea")).sendKeys("Description");
        driver.findElement(By.linkText("Learn more")).click();
        driver.findElement(By.partialLinkText("Terms of Use")).click();
        driver.close();
    }


}
