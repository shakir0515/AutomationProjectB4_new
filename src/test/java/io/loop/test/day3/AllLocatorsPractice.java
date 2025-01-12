package io.loop.test.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLocatorsPractice {
    public static void main(String[] args) {
        // create driver object
        WebDriver driver = new ChromeDriver();
        //maximize
        driver.manage().window().maximize();

        driver.navigate().to("https://loopcamp.vercel.app/registration_form.html");
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Scooby");

        WebElement withClassName = driver.findElement(By.className("form-control"));

        WebElement lastName = driver.findElement(By.name("lastname"));

        lastName.sendKeys("DOO");





    }
}
