package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
   https://the-internet.herokuapp.com/forgot_password
    */
public class T00_css_isDisplayed {
    public static void main(String[] args) {
        //get Driver instance
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();

        // go to url
        driver.get("https://the-internet.herokuapp.com/forgot_password");

        WebElement forgetPasswordHeading = driver.findElement(By.cssSelector("div[class='example']>h2"));
        System.out.println("forgetPasswordHeading = " + forgetPasswordHeading.getText());
//isDisplayed()
        if ((forgetPasswordHeading.isDisplayed())) {
            System.out.println("Test PASS");
        } else {
            System.out.println("FAILED");
        }

        System.out.println(forgetPasswordHeading.isDisplayed());

    }
}
