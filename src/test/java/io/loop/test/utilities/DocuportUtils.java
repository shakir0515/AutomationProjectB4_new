package io.loop.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class DocuportUtils {

    /**
     * logins to docuport app
     * @param driver, which initialized in TestBase
     * @param role, comes from DocuportConstants
     * @author shakir
     */
    public static void login (WebDriver driver, String role) throws InterruptedException {

        driver.get(ConfigurationReader.getProperties("docuportBETA"));
//label[.='Username or email']/following-sibling::input
        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement logInButton = driver.findElement(By.className("v-btn__content"));

        switch (role.toLowerCase()) {
            case "client":
                username.sendKeys(DocuportConstants.USERNAME_CLIENT);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "supervisor":
                username.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "advisor":
                username.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
            case "employee":
                username.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;

            default: throw new InterruptedException("There is not such a role: " + role);

        }

        logInButton.click();

        if (role.toLowerCase().equals("client")) {
            Thread.sleep(3000);
            WebElement con = driver.findElement(By.xpath("//button[@type='submit']"));
            con.click();
            Thread.sleep(3000);
        }

    }

    /**
     * logs out from docuport app
     * @param driver, which initialized in TestBase
     * @author shakir
     */

    public static void logout (WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(ConfigurationReader.getProperties("docuportBETA"));
        WebElement userIcon = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));

        userIcon.click();

        WebElement logOut = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();



    }

}
