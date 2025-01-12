package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T0_forget_password {

    public static void main(String[] args) {
        //get Driver instance
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();

        // go to url
        driver.get(DocuportConstants.DOCUPORT_TEST);

        WebElement forgetPasswordLink = driver.findElement(By.cssSelector("div[class='text-right']>a"));
        forgetPasswordLink.click();

        WebElement resetPasswordHeading = driver.findElement(By.cssSelector("div[class='login-layout__form']>h1"));

        System.out.println("resetpasswordHEading: "+  resetPasswordHeading);





    }
}
