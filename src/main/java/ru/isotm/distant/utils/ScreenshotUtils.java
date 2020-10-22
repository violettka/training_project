package utils;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    public static void saveScreenshotLocally(WebDriver driver, Description description) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String scrFilename = "Fail_Screenshot_" + description.getMethodName() + ".png";
        File outputFile = new File(".", scrFilename);
        try {
            System.out.println("Saving screenshot of failed test...");
            FileUtils.copyFile(scrFile, outputFile);
        } catch (IOException ioe) {
            System.out.println("Error taking screenshot");
        }
    }
}
