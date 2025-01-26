package io.loop.test.day4;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
      1- Open a Chrome browser
      2- Go to: https://www.nba.com
      3- Locate all the links in the page.
       */
public class T1_findElements {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.get("https://www.nba.com");

//Thread.sleep(5000);
// difference it will not wait whole 10 seconds. after page loads it stop
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) --> OLD SELENIUM

       List <WebElement> nbaLinks =  driver.findElements(By.tagName("a"));

        System.out.println("nbaLinks.size() = " + nbaLinks.size());


        List <WebElement> nbaLinksWithXpath =  driver.findElements(By.xpath ("//a"));

        System.out.println("nbaLinksWithXpath = " + nbaLinksWithXpath.size());

        for (WebElement eachNbaLink : nbaLinks) {
            if (!eachNbaLink.getText().equals("")) {
                System.out.println("eachNbaLink.getText() = " + eachNbaLink.getText());
                System.out.println("eachNbaLink.getDomAttribute(\"href\") = " + eachNbaLink.getDomAttribute("href"));

            }
        }

        for (int i = 0; i < nbaLinks.size(); i++) {
            if (!nbaLinks.get(i).getText().equals("")) {
                System.out.println("nbaLinks.get(i).getText() = " + nbaLinks.get(i).getText());
                System.out.println("nbaLinks.get(i).getDomAttribute(\"hreft\") = " + nbaLinks.get(i).getDomAttribute("href"));
            }
        }
    }
}
