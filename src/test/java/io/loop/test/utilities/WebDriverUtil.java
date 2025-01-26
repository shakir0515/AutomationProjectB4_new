package io.loop.test.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverUtil {

    /**
     * @param browserType
     * @return the driver of that browser
     * @author SM
     */

    public static WebDriver getDriver(String browserType) {
        ChromeOptions options = new ChromeOptions();
        if (browserType.equalsIgnoreCase("chrome")) {
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            return new ChromeDriver(options);
        } else if (browserType.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("safari")) {
            return new SafariDriver();
        } else {
            System.out.println("No driver found");
            System.out.println("Driver is null");
            return null;
        }

    }
}
