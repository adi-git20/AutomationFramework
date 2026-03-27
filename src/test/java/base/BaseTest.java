package base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentManager;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentManager.getReportInstance();
        System.out.println("Report initialized");
    }

    @BeforeMethod
    public void setupTest(Method method) {
        test = extent.createTest(method.getName());
        System.out.println("Test started: " + method.getName());

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
        System.out.println("Report flushed");
    }


public String captureScreenshot(String testName) throws IOException {

    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    String path = System.getProperty("user.dir") + "/reports/" + testName + ".png";

    FileUtils.copyFile(src, new File(path));

    return path;
}


@AfterMethod
public void tearDown(ITestResult result) throws IOException {

    if (result.getStatus() == ITestResult.FAILURE) {
        String path = captureScreenshot(result.getName());
        test.fail("Test failed").addScreenCaptureFromPath(path);
    }

    driver.quit();
}

}