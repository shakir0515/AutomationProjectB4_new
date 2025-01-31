package io.loop.test.day7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/*
    1. Open a chrome browser
    2. Go to : http://the-internet.herokuapp.com/windows
    3. Assert: Title is “The Internet”
    4. Click to: “Click Here” link
    5. Switch to new Window.
    6. Assert: Title is “New Window”
     */
public class T1_window extends TestBase {

    @Test
    public void test_window_handle () {
        driver.get("http://the-internet.herokuapp.com/windows");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";

        assertEquals(actualTitle, expectedTitle,"No Match detected");

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());



     WebElement clickHere = driver.findElement(By.xpath("//a[@href='/windows/new']"));
//a[text()='Click Here']
     clickHere.click();
        System.out.println("driver.getTitle() = " + driver.getTitle());

    // get original windowhandle

        String originalWindow = driver.getWindowHandle();

        // get all window handles

        Set <String> windowHandles = driver.getWindowHandles();

        // loop through and stay at the last

        for (String each : windowHandles) {
            System.out.println("each window handle = " + each);
            driver.switchTo().window(each);
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());

        driver.switchTo().window(originalWindow);

//driver.switchTo().defaultContent();
        System.out.println("driver.getTitle() = " + driver.getTitle());

    }
}
