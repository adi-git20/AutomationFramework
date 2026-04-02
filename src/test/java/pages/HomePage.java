package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 🔥 FIX
    }
    
    

    // Locators
    By destination = By.xpath("//input[@placeholder='Where are you going?']");
    By suggestion = By.xpath("//li//div[contains(text(),'Kolkata')]");
    By dateBox = By.xpath("//button[@data-testid='searchbox-dates-container']");
    By guests = By.xpath("//button[@data-testid='occupancy-config']");
    By doneBtn = By.xpath("//button[.//span[text()='Done']]");
    By searchBtn = By.xpath("//button[@type='submit']");

    // Methods

    public void enterDestination(String city) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(destination));
        element.click();
        element.sendKeys(city);

        wait.until(ExpectedConditions.elementToBeClickable(suggestion)).click();
    }

    public void selectDate(String date) {
        wait.until(ExpectedConditions.elementToBeClickable(dateBox)).click();

        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[@data-date='" + date + "']")
        )).click();
    }

    public void selectGuests() {
        wait.until(ExpectedConditions.elementToBeClickable(guests)).click();

        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@aria-label='Increase number of Adults']")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(doneBtn)).click();
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
    }
}