package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupHandler {

    public static void handlePopup(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            WebElement popup = wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@role='dialog']//button")
                )
            );
            popup.click();
            System.out.println("Popup closed");

        } catch (Exception e) {
            System.out.println("No popup found");
        }
    }
}