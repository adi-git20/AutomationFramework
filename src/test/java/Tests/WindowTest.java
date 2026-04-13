package Tests;

import base.BaseTest;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowTest extends BaseTest {

    @Test
    public void testWindowSwitch() {

        driver.get("https://demoqa.com/browser-windows");

        String parent = driver.getWindowHandle();

        driver.findElement(org.openqa.selenium.By.id("windowButton")).click();

        Set<String> handles = driver.getWindowHandles();

        for (String handle : handles) {
            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);
                System.out.println(driver.getTitle());
                driver.close();
            }
        }

        driver.switchTo().window(parent);
    }
}
