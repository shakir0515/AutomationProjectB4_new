package io.loop.test.day5.hometask;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/*Tasks
https://loopcamp.vercel.app/radio-buttons.html
Tasks
Create two distinct groups of radio buttons:
go website
assert title
blue color button is selected by default
validate green button is disables
validate 4 others are enabled
*/
public class Task1 {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

    @Test
    public void radioButtonsAssert() {
        driver.get("https://loopcamp.vercel.app/radio-buttons.html");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Radio buttons";

        assertEquals(actualTitle, expectedTitle, "Actual does not match the expected");

//blue color button is selected by default
        WebElement blueColor = driver.findElement(By.cssSelector("input#blue"));

        assertTrue(blueColor.isSelected(), "Blue color is not selected by default");

        WebElement greenColor = driver.findElement(By.cssSelector("input#green"));
        assertFalse(greenColor.isEnabled(), "Green color is not selected by default");


//validate 4 others are enabled
        List <WebElement> colors = driver.findElements(By.xpath("//input[@name='color']"));

        boolean isEnabled;

        for (WebElement eachElement: colors) {
            System.out.println(eachElement.getDomAttribute("id") + " is enable = " + eachElement.isEnabled());
        }
    }
}
