package io.loop.test.day4.hometask_day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*task 2
=============
1. login to docuport application
2. logout from docuport application
3. Validate successful login
4. Validate successful logout*/
public class T2_validate_docuport {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);

        driver.get(DocuportConstants.DOCUPORT_TEST);

        WebElement username = driver.findElement(By.cssSelector("input[type='text']"));

        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));

        WebElement loginButton = driver.findElement(By.xpath("//div[@class='col col-12']/button"));

        username.sendKeys(DocuportConstants.USERNAME_ADVISOR);

        password.sendKeys(DocuportConstants.PASSWORD);

        loginButton.click();

        Thread.sleep(5000);

        WebElement bach1Group1 = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));

        if (bach1Group1.isDisplayed()) {
            System.out.println("You are in homepage for Advisor ==> Login Validated");
        } else {
            System.out.println("You are not in Login Page");
        }

        bach1Group1.click();

        WebElement logoutButton = driver.findElement(By.xpath("//*[contains(text(),'Log out')]"));

        logoutButton.click();
        System.out.println("Logging out..");


        Thread.sleep(5000);
        try {
            loginButton.isDisplayed();
        } catch (StaleElementReferenceException e) {
            // Re-find the element
            loginButton = driver.findElement(By.xpath("//div[@class='col col-12']/button"));
            loginButton.isDisplayed();
        }
        System.out.println(loginButton.isDisplayed() ?
                "You are on sign in page ==> Logout Validated" :
                "IT IS FAILED ==> You are not in Logout Page");
    }
}
