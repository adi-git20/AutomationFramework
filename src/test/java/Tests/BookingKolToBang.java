package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.BaseTest;

import java.io.IOException;
import java.time.Duration;



public class BookingKolToBang extends BaseTest {

	
	
    @Test
    public void testBookingFlow() throws InterruptedException, IOException {

        driver.get("https://www.booking.com/flights/index.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        try {

        	
        	
        	
            System.out.println("Page Loaded");

            Thread.sleep(2000);

            By airport = By.xpath("//a[@id='airport_taxis']");
            wait.until(ExpectedConditions.elementToBeClickable(airport)).click();

            Thread.sleep(2000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy({ top: document.body.scrollHeight, behavior: 'smooth' })");

            Thread.sleep(2000);

            By howDo = By.xpath("//h3[@itemprop='name']");
            wait.until(ExpectedConditions.elementToBeClickable(howDo)).click();

            System.out.println("Success");

            test.pass("Test executed successfully");
            
            Assert.assertTrue(driver.getTitle().contains("Booking"), "Title validation failed");

        } catch (Exception e) {
        	
        	System.out.println("Inside catch block");
        	String path = captureScreenshot("failure");
            test.fail("Test failed").addScreenCaptureFromPath(path);
            
            System.out.println("Screenshot saved at: " + path);
            
            e.printStackTrace();
        }
    }
}