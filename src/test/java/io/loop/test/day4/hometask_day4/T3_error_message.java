package io.loop.test.day4.hometask_day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*task 3
=============
1. navigate to docuport application
2. validate placeholders for user name and password
3. without sending username and password click login button
4. validate username and password error messages */
public class T3_error_message {

    public static void main(String[] args) {

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);

        driver.navigate().to(DocuportConstants.DOCUPORT_TEST);

        WebElement firstNamePlaceholder = driver.findElement(By.name("firstname"));

        //String actualPlaceholderForFirstName = firstNamePlaceholder.getAttribute("placeholder");
    }
}
