package io.loop.test.day3.hometaskDay3;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.time.Duration;

/*


    the rest is homework
    locate:
    username
    password
    login
        with css
    login to docuport
    locate home icon of docuport after login or any other element after login
    validated that you logged in

     */
public class Home_task1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.get(DocuportConstants.DOCUPORT_TEST);

        WebElement username = driver.findElement(By.cssSelector("input[type='text']"));

        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        username.sendKeys(DocuportConstants.USERNAME_CLIENT);

        password.sendKeys(DocuportConstants.PASSWORD);

        loginButton.click();

        Thread.sleep(5000);
        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));

        Thread.sleep(5000);
        continueButton.click();

WebElement elementAfterLogin = driver.findElement(By.cssSelector("div[class='v-avatar primary']"));

if (elementAfterLogin.isDisplayed()){
    System.out.println("The element is displayable ===> TEST PASSED");
}else{
    System.out.println("The element is not on display ===> Test FAILED");
}
        }
    }





