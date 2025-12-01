package Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtil {
    public String captureScreenshot(WebDriver driver, String screenshotName) throws Exception {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = "screenshots/" + screenshotName + ".png";
        Files.createDirectories(Paths.get("screenshots")); // ensure folder exists
        Files.copy(source.toPath(), Paths.get(dest));
        System.out.println(dest);
        return dest; // returns the path of the screenshot
    }
}
