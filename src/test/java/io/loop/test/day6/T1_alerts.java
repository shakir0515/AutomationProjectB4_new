package io.loop.test.day6;

import io.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
Information alert practice
1. Open browser
2. Go to website: https://loopcamp.vercel.app/javascript-alerts.html
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Validate “You successfully clicked an alert” text is displayed

Confirmation alert practice
1. Click to “Click for JS Confirm” button
2. Click to OK button from the alert
3. Verify “You clicked: Ok” text is displayed.
4. Click to “Click for JS Confirm” button
5. Click to Cancel button from the alert
6. Validate “You clicked: Cancel” text is displayed.

Prompt alert practice
1. Click to “Click for JS Prompt” button
2. Send "Loop Academy"
3. Click Ok
4. Validate "You entered: Loop Academy" text is displayed
*/
public class T1_alerts extends TestBase {

    @Test
    public void infoAlert() {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
// //button[@onclick='jsAlert()']
        WebElement clickForJSAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickForJSAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement successMessageForInfoAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = successMessageForInfoAlert.getText();
        String expected = "You successfully clicked an alert";

        Assert.assertEquals(actual, expected,"Actual does not match");
    }

    @Test
    public void confirmationAlert() {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");

        WebElement clickForJSConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));

        clickForJSConfirm.click();

        driver.switchTo().alert().accept(); // will click ok

        WebElement successMessageForConfirmationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = successMessageForConfirmationAlert.getText();
        String expected = "You clicked: Ok";



        clickForJSConfirm.click();

        driver.switchTo().alert().dismiss();

        // You clicked: Cancel

        expected = "You clicked: Cancel";

        actual = successMessageForConfirmationAlert.getText();

        Assert.assertEquals(actual, expected,"Did not click cancel");
    }

    @Test
    public void  promptAlert () {

        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        clickForJSPrompt.click();

        String text = "LOOPCAMP";
//        driver.switchTo().alert().sendKeys(text);
//        driver.switchTo().alert().accept();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();

        WebElement successMessageForPromptAlert = driver.findElement(By.xpath("//p[@id='result']"));

        String actual = successMessageForPromptAlert.getText();
        String expected = "You entered: " + text;

        Assert.assertEquals(actual, expected,"No MATCH!");

        clickForJSPrompt.click();
        alert.sendKeys(text);
        alert.dismiss();

       actual = successMessageForPromptAlert.getText();
       expected = "You entered: " + null;

        Assert.assertEquals(actual, expected,"No MATCH!");
    }
}
