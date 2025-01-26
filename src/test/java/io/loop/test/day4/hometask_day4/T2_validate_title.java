package io.loop.test.day4.hometask_day4;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/*Task 2
================
1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Validate title:
Expected: “Wooden spoon | Etsy”*/
public class T2_validate_title {

    public static void main(String[] args) throws InterruptedException {

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        WebDriver driver = new ChromeDriver(options);

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        Thread.sleep(5000);
        String urlEtsy = "https://www.etsy.com/";
        driver.navigate().to(urlEtsy);
        Thread.sleep(5000);
        WebElement search = driver.findElement(By.xpath("//input[@data-id='search-query']"));

        Thread.sleep(5000);

        search.sendKeys("wooden spoon");

        String expectedTitleEtsy = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actualTitleEtsy = driver.getTitle();

        if (actualTitleEtsy.equals(expectedTitleEtsy)) {
            System.out.println("Test PASSED: Actual title:" + actualTitleEtsy + " matching expected " + expectedTitleEtsy);
        } else {
            System.err.println("Test Failed, actual title: " + actualTitleEtsy + " and expected: " + expectedTitleEtsy + " doesn't match");
        }
        driver.quit();

    }
}
