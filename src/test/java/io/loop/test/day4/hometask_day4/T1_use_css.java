package io.loop.test.day4.hometask_day4;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.LoopCampConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*task 1
=============
1. go to https://loopcamp.vercel.app/forgot-password.html
2. locate 5 elements, forgot password, email, email input, retrieve password, powered by LOOPCAMP
3. use css
4. Validate those elements are displayed*/
public class T1_use_css {

    public static void main(String[] args) {

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);

        driver.navigate().to(LoopCampConstants.LOOPCAMP_FORGET_PASSWORD_URL);

        //. locate 5 elements, forgot password, email, email input, retrieve password, powered by LOOPCAMP

        WebElement forgetPasswordHeader = driver.findElement(By.cssSelector("div[class='example']>h2"));

        WebElement emailLabel = driver.findElement(By.cssSelector("label[for='email']"));

        WebElement emailInput = driver.findElement(By.cssSelector("input[type='text']"));

        WebElement retrievePasswordButton = driver.findElement(By.cssSelector("button[id='form_submit']"));

        WebElement poweredByLOOPCAMP = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
//4. Validate those elements are displayed*/
        if (forgetPasswordHeader.isDisplayed()) {
            System.out.println("Forget password header is visible");
        }
        if (emailLabel.isDisplayed()) {
            System.out.println("email label is visible");
        }
        if (emailInput.isDisplayed()) {
            System.out.println("email input is visible");
        }
        if (retrievePasswordButton.isDisplayed()) {
            System.out.println("Retrieve password button is visible");
        }
        if (poweredByLOOPCAMP.isDisplayed()) {
            System.out.println("Powered by loopcamp is visible");
        }


        driver.quit();
    }
}
