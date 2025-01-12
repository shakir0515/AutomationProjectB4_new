package io.loop.test.day3;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.DocuportUtils;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * go to docuport
 * enter username
 * do NOT enter password
 * click on login button
 * verify error message - please enter password
 */
public class T1_locators_getText {
    public static void main(String[] args) {
        // create driver object
//        WebDriver driver = new ChromeDriver();
//        //maximize
//        driver.manage().window().maximize();
//
//        driver.get("");

       WebDriver driver = WebDriverUtil.getDriver(DocuportConstants.BROWSER);
        driver.manage().window().maximize();
        driver.get(DocuportConstants.DOCUPORT_TEST);

        WebElement userName = driver.findElement(By.id("input-14"));
        userName.sendKeys(DocuportConstants.USERNAME_CLIENT);

        WebElement loginButton = driver.findElement(By.className("v-btn__content"));

        loginButton.click();

        WebElement errorMessage = driver.findElement(By.className("v-messages__message"));
      String actualErrorMessage = errorMessage.getText();
//        System.out.println("error message: " + actualErrorMessage);
        if(actualErrorMessage.equals(DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD)){
            System.out.println("Expected error message: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + ", matches actual error message: " + actualErrorMessage + " => TEST PASSED");
        } else {
            System.err.println("Expected error message: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + ", DOES NOT MATCH actual error message: " + actualErrorMessage + " => TEST FAILED");
        }
driver.quit();
    }
}