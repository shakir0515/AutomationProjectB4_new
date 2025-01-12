package io.loop.test.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args) {
        // create driver object
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com");
        //maximize
        driver.manage().window().maximize();

        //locate element
        WebElement searchBoxWithID = driver.findElement(By.id("APjFqb"));

        WebElement searchBoxWithName = driver.findElement(By.name("q"));

        WebElement aboutLink = driver.findElement(By.linkText("About"));
        aboutLink.click();

        String textToSearch = "Feyruz is the king of Java";

        searchBoxWithID.sendKeys(textToSearch);

        searchBoxWithID.clear();
        searchBoxWithID.sendKeys("Nadir is smart " + Keys.ENTER);
    }
}
