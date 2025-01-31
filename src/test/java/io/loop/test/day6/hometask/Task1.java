package io.loop.test.day6.hometask;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/*task1
=============
go to http://the-internet.herokuapp.com/dropdown
validate "Please select an option" is selected by default
Choose option 1 and validate that it is selected
Choose option 2 and validate that it is selected
Validate dropdown name is "Dropdown List"*/
public class Task1 extends TestBase {
    @Test
    public void dropdownTest() {
        driver.get("http://the-internet.herokuapp.com/dropdown");

        Select dropdown = new Select(driver.findElement(By.id("dropdown")));

        String actualFirstSelected = dropdown.getFirstSelectedOption().getText();

        String expected = "Please select an option";

        assertEquals(actualFirstSelected, expected, "NO match");

        dropdown.selectByIndex(1);

        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 1", "No match");


        dropdown.selectByContainsVisibleText("tion 2");

        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2", "No match");

        String expectedHeader = "Dropdown List";

        String actualHeader = driver.findElement(By.tagName("h3")).getText();

        assertEquals(actualHeader, expectedHeader, "No match for the header");
    }
    /*task3
=============
login as an advisor
go to received document
click search
click status dropdown
choose in progress*/
    @Test
    public void dropdownTest2() throws InterruptedException {
        driver.get(DocuportConstants.DOCUPORT_TEST);

        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        username.sendKeys(DocuportConstants.USERNAME_ADVISOR);
        password.sendKeys(DocuportConstants.PASSWORD);
        WebElement signIn = driver.findElement(By.className("v-btn__content"));
        signIn.click();

        Thread.sleep(5000);

        WebElement receivedDocs = driver.findElement(By.xpath("//h2[contains(text(), 'Received')]"));
        receivedDocs.click();

        WebElement searchButton = driver.findElement(By.xpath("//span[contains(text(), 'Search')]"));
        searchButton.click();

        WebElement statusDropdown = driver.findElement(By.xpath("//label[contains(text(), 'Status')]"));
        statusDropdown.click();

        Thread.sleep(3000);

        WebElement inProgressOption = driver.findElement(By.xpath("//div[contains(text(), 'In progress')]"));
        inProgressOption.click();

        assertTrue(inProgressOption.isDisplayed());
    }
}
