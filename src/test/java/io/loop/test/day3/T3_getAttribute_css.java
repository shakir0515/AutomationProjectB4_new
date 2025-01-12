package io.loop.test.day3;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.LoopCampConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
    go to docuport app
    identify docuport with css
    get value of the attribute
    validate if it is "Docuport"

    the rest is home work
    locate:
    username
    password
    login
        with css
    login to docuport
    locate home icon of docuport after login or any other element after login
    validated that you logged in

     */
public class T3_getAttribute_css {
    public static void main(String[] args) {

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
// go to docuport app
        driver.get(DocuportConstants.DOCUPORT_TEST);

        // locate with css

        WebElement logo = driver.findElement(By.cssSelector("img[src='/img/login-intro.00527dd6.svg']"));

        // get the value of the Attribute

        String docuport = logo.getDomAttribute("alt");

        System.out.println("docuport: " + docuport);

        if(DocuportConstants.LOGO_DOCUPORT.equals(docuport)){
            System.out.println("Expected result matches with actual");
            System.out.println("TEST PASSED");
        } else {
            System.out.println("Expected does not match with actual");
            System.out.println("Test FAILED");
        }

        WebElement username = driver.findElement(By.cssSelector("input#input-14"));

        WebElement password = driver.findElement(By.cssSelector("input#input-15"));

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        username.sendKeys("b1g1_advisor@gmail.com");

        password.sendKeys("Group1");




}
}