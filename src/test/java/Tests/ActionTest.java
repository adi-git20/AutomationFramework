package Tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionTest extends BaseTest {

    @Test
    public void testMouseHover() {

        driver.get("https://www.amazon.in");

        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.id("nav-link-accountList")))
               .perform();
    }
}
