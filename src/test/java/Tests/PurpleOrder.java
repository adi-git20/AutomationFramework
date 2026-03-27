package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PurpleOrder {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.purplle.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // 🔹 Close popup if appears
            try {
                WebElement closePopup = wait.until(
                        ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='close']")));
                closePopup.click();
            } catch (Exception e) {
                System.out.println("No popup appeared");
            }

            // 🔹 Search product
            WebElement searchBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search for products']")));
            searchBox.sendKeys("lipstick");

            WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
            searchButton.click();

            // 🔹 Click on first product
            WebElement firstProduct = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'product')]//a)[1]")));
            firstProduct.click();

            // 🔹 Switch to new tab
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 🔹 Add to cart
            WebElement addToCartBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add to Cart')]")));
            addToCartBtn.click();

            System.out.println("Product added to cart successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // driver.quit();
    }
}
