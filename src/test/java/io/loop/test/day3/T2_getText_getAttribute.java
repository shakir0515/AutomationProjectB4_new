package io.loop.test.day3;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.LoopCampConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
  go to url: https://loopcamp.vercel.app/registration_form.html
  verify header text expected:  Registration form
  verify placeholder attribute value for first name expected - first name
   */
public class T2_getText_getAttribute {
    public static void main(String[] args) {

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();

        driver.get(LoopCampConstants.REGISTRATION_FORM_URL);

        WebElement headerForRegistrationForm = driver.findElement(By.tagName("h2"));
        //Use getText method

        String actualHeaderForForm = headerForRegistrationForm.getText();

        if(actualHeaderForForm.equals(LoopCampConstants.EXPECTED_HEADER_FOR_FORM)){
            System.out.println("Expected header for form: \"" + LoopCampConstants.EXPECTED_HEADER_FOR_FORM + "\", matches actual header: \"" + actualHeaderForForm + "\" => TEST PASSED");
        } else {
            System.err.println("Expected header for form: \"" + LoopCampConstants.EXPECTED_HEADER_FOR_FORM + "\", DOES NOT MATCH actual header: \"" + actualHeaderForForm + "\" => TEST FAILED");
        }

        WebElement firstNamePlaceholder = driver.findElement(By.name("firstname"));

        String actualPlaceholderForFirstName = firstNamePlaceholder.getAttribute("placeholder");

        if (actualPlaceholderForFirstName.equals(LoopCampConstants.EXPECTED_PLACEHOLDER_FIRSTNAME)) {

            System.out.println("Expected placeholder matches with actual");
            System.out.println("Test passed");
        } else {
            System.out.println("Expected placeholder does not match with actual");
            System.err.println("Test failed");
        }



    }
}
