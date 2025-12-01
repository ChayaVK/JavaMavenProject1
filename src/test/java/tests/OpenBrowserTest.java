package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utils.JiraAttachment;
import Utils.ScreenshotUtil;

public class OpenBrowserTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openBrowserTest() throws Exception {
        driver.get("https://www.google.com");
        System.out.println("Browser opened successfully!");
        ScreenshotUtil s = new ScreenshotUtil();
        String screenshotPath = s.captureScreenshot(driver, "testFailure");
        JiraAttachment.attachScreenshot("SCRUM-4", screenshotPath);
        
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
