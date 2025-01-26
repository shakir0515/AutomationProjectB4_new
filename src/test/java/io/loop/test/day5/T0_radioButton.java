package io.loop.test.day5;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/*
      https://loopcamp.vercel.app/radio-buttons.html
      wait implicitly 10 seconds
      is selected
      is enabled
       */
public class T0_radioButton {
    public static void main(String[] args) {
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.get("https://loopcamp.vercel.app/radio-buttons.html");

// selenium 3 wait
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


// selenium 4
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement red = driver.findElement(By.xpath("//input[@id='red']"));

        WebElement green = driver.findElement(By.xpath("//input[@id='green']"));

        // isSelected();
        System.out.println("BEFORE CLICKING " + red.isSelected());

        red.click();
        System.out.println("AFTER CLICKING " + red.isSelected());

        System.out.println("red.isEnabled() = " + red.isEnabled());


        green.click();
        System.out.println("green.isSelected() = " + green.isSelected());

        System.out.println("green.isEnabled() = " + green.isEnabled());

        driver.quit();

    }
}
