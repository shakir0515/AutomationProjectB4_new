package io.loop.test.day5;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/*
    1. Open Chrome browse
    2. Go to http://the-internet.herokuapp.com/dropdown
    3. Verify “Dropdown list” default selected value is correct - Expected: “Please select an option”

 */
public class T3_simple_dropdown {

    WebDriver driver;
    String expected = "Please select an option";
    String actual;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
    }

    @AfterMethod
    public  void  tearDownMethod() {
        driver.close();
    }


    @Test
    public void dropdownTest() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // create a dropdown
        //WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        //Select dropdown = new Select(dropdownElement)

        Select dropdown = new Select(driver.findElement(By.id("dropdown")));

       actual =  dropdown.getFirstSelectedOption().getText();
       assertEquals(actual, expected, "Actual does not match the expected");



    }

}
