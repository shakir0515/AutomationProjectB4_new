package io.loop.test.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * Navigate to Google search
 * maximize the page
 * get title of the page
 * get url of the page
 * validate the title, expected title is "Google"
 * validate the url of the page, expected url is "https://www.google.com/"
 * close the browser
 */
public class GoogleSearch {
    public static void main(String[] args) {
// create driver object
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com");
        //maximize
        driver.manage().window().maximize();

        String expectedTitle = "Google";
        System.out.println( driver.getTitle() );
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Actual title: " + actualTitle + ", matches expected title: " + expectedTitle + ". => TEST PASSED");
        } else {
            System.out.println("Actual title: " + actualTitle + ", does not match expected title: " + expectedTitle + ". => TEST FAILED");
        }
        System.out.println("=================");
        String expectedUrl = "https://www.google.com";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Actual url: " + actualUrl + ", matches expected url: " + expectedUrl + ". => TEST PASSED");
        }else {
            System.out.println("Actual url: " + actualUrl + ", DOES NOT match expected url: " + expectedUrl + ". => TEST FAILED");
        }
driver.quit();

    }
}
