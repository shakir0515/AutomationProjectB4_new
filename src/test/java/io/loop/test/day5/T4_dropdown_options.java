package io.loop.test.day5;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/*
   1. Open Chrome browser
   2. Go to https://demoqa.com/select-menu
   3. go old style select menu
   4. Select Yellow and validate
   5. Select Red and validate
   6. Select White and validate
   Use all Select options. (visible text, value, index)
    */
public class T4_dropdown_options {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);

       // driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
         driver.close();
    }
    @Test
    public void colorTest() {
        Select dropdown = new Select(driver.findElement(By.id("oldSelectMenu")));
        dropdown.selectByIndex(3);
        assertEquals(dropdown.getFirstSelectedOption().getText(),"Yellow","Actual does not match the expected");

        dropdown.selectByValue("red");
        assertEquals(dropdown.getFirstSelectedOption().getText(),"Red","Actual does not match");

        dropdown.selectByVisibleText("White");
        assertEquals(dropdown.getFirstSelectedOption().getText(),"White","Actual does not match");

        dropdown.selectByContainsVisibleText("Purp");
        assertEquals(dropdown.getFirstSelectedOption().getText(),"Purple","Actual does not match");
    }
}
