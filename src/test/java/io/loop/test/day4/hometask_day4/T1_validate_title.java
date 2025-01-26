package io.loop.test.day4.hometask_day4;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/*Task 1
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Validate title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Validate title equals:
Expected: Google*/
public class T1_validate_title {
    public static void main(String[] args) {



        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);




        String url = "https://google.com";
        driver.navigate().to(url);

        WebElement gmail = driver.findElement(By.cssSelector("a[aria-label='Gmail ']"));

        gmail.click();

        String actualTitle = driver.getTitle();

        String expectedTitleContains = "Gmail";

        if (actualTitle.contains(expectedTitleContains)){

            System.out.println("Actual title contains " + expectedTitleContains + " ==> TEST PASSED");
        }else {
            System.out.println("Actual title does not contain " + expectedTitleContains + " ==> TEST FAILED");
        }

        driver.navigate().back();

        String actualTitle2 = driver.getTitle();

        String expectedTitle2 = "Google";
        if (actualTitle2.equals(expectedTitle2)){

            System.out.println("Actual title equals " + expectedTitle2 + " ==> TEST PASSED");
        }else {
            System.out.println("Actual title does not equal " + expectedTitle2 + " ==> TEST FAILED");
        }

        driver.quit();




    }
}