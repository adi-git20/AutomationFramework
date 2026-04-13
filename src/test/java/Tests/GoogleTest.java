package Tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    @Test
    public void testSearch() {

        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
        driver.findElement(By.name("q")).submit();
    }
}
