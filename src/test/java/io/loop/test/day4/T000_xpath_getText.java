package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*/*
    1. open chrome
    2. go to docuport
    3. click on forgot password
    4. validate url contains: reset-password
    5. validate - Enter the email address associated with yor account
    6. enter forgotpasswordg1@gmail.com to email box
    7. validate send button is displayed
    8. validate cancel button is displayed
    9. click send button
    10. validate - We've sent you an email with a link to reset your password. Please check your email
     */
public class T000_xpath_getText {
    public static void main(String[] args) throws InterruptedException {

        //get Driver instance
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();

        // go to url
        driver.get(DocuportConstants.DOCUPORT_TEST);

        WebElement forgetPassword = driver.findElement(By.xpath("//a[@href='/reset-password']"));
        forgetPassword.click();

        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(DocuportConstants.RESET_PASSWORD_URL)) {
            System.out.println("Test passed url");
        } else {
            System.out.println("test failed");
        }

        WebElement validateMessage = driver.findElement(By.xpath("//div[contains(text(),'email')]"));

        String actualValidateMessage = validateMessage.getText();

        if (actualValidateMessage.equals(DocuportConstants.RESET_PASSWORD_MESSAGE)) {

            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

// 6. enter forgotpasswordg1@gmail.com to email box
        WebElement emailInputBox = driver.findElement(By.xpath("//input[contains(@id, 'input')]"));


        emailInputBox.sendKeys(DocuportConstants.EMAIL_FOR_RESET_PASSWORD);

        WebElement sendButton = driver.findElement(By.xpath(" //span[normalize-space()='Send']"));

        WebElement cancelButton = driver.findElement(By.xpath("//span[contains(.,'Cancel')]"));

        if (cancelButton.isDisplayed()) {
            System.out.println("Test passed cancel button");
        }
        if (sendButton.isDisplayed()) {
            System.out.println("Test passed send button");
        }

        sendButton.click();

        Thread.sleep(7000);

        WebElement successMessage = driver.findElement(By.xpath(" //span[@class='body-1']"));

        Thread.sleep(5000);

        System.out.println("successMessage.getText() = " + successMessage.getText());


        try{
            System.out.println("successMessage.getText() = " + successMessage.getText());
        } catch (StaleElementReferenceException e){
            System.out.println("Element is not there anymore");
        }
    }
}
