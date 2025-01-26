package io.loop.test.day5;

import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class T1_testNG_intro {

    @Test( priority = 1)
    public void test2() {
        System.out.println("Test 2 is running....");

        String actual = "Feyruz";
        String expected = "Nadir";
        assertEquals(actual, expected,"Message will show if only test fails");
    }
    @Test (priority = 2)
    public void test1(){
        System.out.println("Test 1 is running....");
        String expected = "Diana";
        String actual = "Diana";
        assertEquals(actual, expected,"Actual does not macth expected");

    }
    @BeforeMethod
    public void setUpMethod() {
        System.out.println("Before method is running before each method....");
    }

    @AfterMethod
    public void tearDownMethod() {
        System.out.println("After method is running after each method....");
    }

    @BeforeClass
    public void setUp () {
        System.out.println("Before class is running....");
    }

    @AfterClass
    public void tearDown () {
        System.out.println("After class is running....");
    }
}
