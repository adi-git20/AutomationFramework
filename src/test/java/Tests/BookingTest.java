package Tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import utils.PopupHandler;

public class BookingTest extends BaseTest {

    @Test
   public void bookingFlow() {

        
    	HomePage home = new HomePage(driver);
    	driver.get("https://www.booking.com/flights/index.html");
        // Handle popup
        PopupHandler.handlePopup(driver);

        home.enterDestination("Kolkata");
        home.selectDate("2026-04-15");
        home.selectGuests();
        home.clickSearch();

        System.out.println("Test Completed");
    }
}
