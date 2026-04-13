package Tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void testNavigation() {

        driver.get("https://www.google.com");

        System.out.println("Title: " + driver.getTitle());

        driver.navigate().to("https://www.amazon.in");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }
}
