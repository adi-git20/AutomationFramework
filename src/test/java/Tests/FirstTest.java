package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class FirstTest {

    @Test
    public void launchBrowser() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.booking.com/flights/index.html");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {

            // 🔹 Handle popup (if appears)
            try {
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@aria-label='Dismiss sign-in info.']")
                )).click();
            } catch (Exception e) {
                System.out.println("No popup appeared");
            }

            // 🔹 Click "Going to" field
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[contains(@placeholder,'Where')]")
            )).click();

            // 🔹 Enter destination
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[contains(@placeholder,'Where')]")
            )).sendKeys("Thailand");

            // 🔹 Select first suggestion
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//ul//li[1]")
            )).click();

            // 🔹 Click Search
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@data-ui-name='button_search_submit']")
            )).click();

            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        

        driver.quit();
    }
}