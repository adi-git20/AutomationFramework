package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.BaseTest;

import java.io.IOException;
import java.time.Duration;



public class BookingFirstTest extends BaseTest {

	
	
    
    public void randomElementVisibility() throws InterruptedException, IOException {

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
    
    @Test
    public void firstBookingConfirmation() throws InterruptedException, IOException {

        driver.get("https://www.booking.com/flights/index.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        try {

        	By stayBtn = By.xpath("//a[.//span[text()='Stays']]");
            wait.until(ExpectedConditions.elementToBeClickable(stayBtn)).click();
            
            Thread.sleep(2000);
            
            System.out.println("Page Loaded");
            
          
            try {
                WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(15));

                WebElement closeBtn = waitt.until(
                    ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@role='dialog']//button")
                    )
                );

                closeBtn.click();
                System.out.println("Popup closed");

            } catch (Exception e) {
                System.out.println("Popup not found");
            }
            
            Thread.sleep(2000);
            		
        	
            
            WebElement destination = wait.until(
            	    ExpectedConditions.elementToBeClickable(
            	        By.xpath("//input[@placeholder='Where are you going?']")
            	    )
            	);

            	destination.click();
            	destination.clear();
            	destination.sendKeys("Kolkata");
            
            Thread.sleep(2000);
            
            By date = By.xpath("//button[@data-testid='searchbox-dates-container']");
            wait.until(ExpectedConditions.elementToBeClickable(date)).click();
            
            WebElement datePicker = wait.until(
            	    ExpectedConditions.elementToBeClickable(
            	        By.xpath("//span[@data-date='2026-04-15']")
            	    )
            	);
            
            	datePicker.click();
            	
            Thread.sleep(2000);
            
            By adults = By.xpath("//button[@data-testid='occupancy-config']");
            wait.until(ExpectedConditions.elementToBeClickable(adults)).click();
            
            //Thread.sleep(2000);
            
            By doneBtn = By.xpath("//button[.//span[text()='Done']]");
            wait.until(ExpectedConditions.elementToBeClickable(doneBtn)).click();
            
            //Thread.sleep(2000);
            
            By submit = By.xpath("//button[@type='submit']");
            wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
            
         

            Thread.sleep(2000);

           

            System.out.println("Success");

            test.pass("Test executed successfully");
            
            
            //WebElement element = driver.findElement(By.xpath("//h1[text()='Kolkata: 627 properties found']"));
            //highlightElement(element);
            
            Assert.assertTrue(driver.getTitle().contains("Kolkata"), "Title validation failed");
            
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());

        } catch (Exception e) {
        	
        	System.out.println("Inside catch block");
        	String path = captureScreenshot("failure");
            test.fail("Test failed").addScreenCaptureFromPath(path);
            
            System.out.println("Screenshot saved at: " + path);
            
            e.printStackTrace();
        }
    }
    
    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
    
}