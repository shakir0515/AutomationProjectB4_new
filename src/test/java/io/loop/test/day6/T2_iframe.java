package io.loop.test.day6;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class T2_iframe extends TestBase {

    @Test
    public void iframeTest() {
        driver.get("https://loopcamp.vercel.app/iframe.html");

//        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
//        driver.switchTo().frame(iframe); //by element

//driver.switchTo().frame("mce_0_ifr"); // by ID

        driver.switchTo().frame(0); // BY Index

//        WebElement someText = driver.findElement(By.xpath("//body[@id='tinymce']//p"));
//        System.out.println("someText.getText() = " + someText.getText());

        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));

        textBox.clear();

        textBox.sendKeys("Loopcamp");

        assertEquals(textBox.getText(),"Loopcamp", "No match");

        WebElement header = driver.findElement(By.xpath("//h3[contains(text(),'An iFrame')]"));

        driver.switchTo().defaultContent();

        assertTrue(header.isDisplayed(),"Not displayed");
    }

    @Test
    public void nestedFrame() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");

        List <WebElement> iframes = driver.findElements(By.xpath("//frame"));
        System.out.println(iframes.size());
    }
}
