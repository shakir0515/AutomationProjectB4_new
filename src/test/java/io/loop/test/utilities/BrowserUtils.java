package io.loop.test.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class BrowserUtils {
    /**
     * validate if driver switched to expected url or title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author shakir
     * implements assertion
     */

    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle) {
        // to lowercase the params in order to avoid miss type
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();

        //get all windowHandles, switch one by one and each time check the url matches expected to stop
        Set <String> windowHandles = driver.getWindowHandles();
        for (String each: windowHandles) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }
        }
        // after stopping on expected url validate the title
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     * @param driver
     * @param targetTitle
     * @author shakir
     */
    public static void switchToWindow (WebDriver driver, String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().toLowerCase().contains(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }
}
