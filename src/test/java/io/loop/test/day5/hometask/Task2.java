package io.loop.test.day5.hometask;
// navigate to https://demoqa.com/checkbox
// validate title
//validate checkbox is not checked
// click on checkbox
// validate the message

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task2 {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod () {
        driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
    }

    @AfterMethod
    public void tearDownMethod () {
        driver.close();
    }

    @Test

    public void demoqaTest () {

        driver.get("https://demoqa.com/checkbox");
        String actualTitle = driver.getTitle();
        String expectedTitle = "DEMOQA";

        assertEquals(actualTitle, expectedTitle, "Actual does not match the expected");



        WebElement checkbox = driver.findElement(By.xpath("//span[@class='rct-checkbox']"));

        // Use JavaScriptExecutor to scroll to the element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", checkbox);

        checkbox.click();

    }

}
