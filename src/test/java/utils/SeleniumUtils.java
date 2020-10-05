package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import school.request.LoginPage;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeleniumUtils {

    private static WebDriver driver;
    private static WebDriver driverHeadless;
    private static WebDriverWait wait;

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--window-size=1920,1200");
       // options.addArguments("--headless");
        return driver = new ChromeDriver(options);
    }

    public static WebDriver getDriverHeadless() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        //options.addArguments("--headless", "--window-size=1920,1200");
        return new ChromeDriver(options);
    }

    public static WebDriverWait getDriverWait() {
        if (wait == null) {
            wait = new WebDriverWait(driver, 20);
        }
        return wait;
    }

    public static WebDriverWait getDriverWait(int timeout) {
        return new WebDriverWait(driver, timeout);
    }

    public static void initializeAndAuthorize(WebDriver driver) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://");
        //driver.findElement(By.xpath("//button[@id='details-button']")).click();
        //driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        try {
            loginPage.login();
        } catch (NoSuchElementException ex) {
            System.out.println("Already logged in. Can be false positive if login page is changed");
        }

        driver.get("https://distant.isotm.ru/request-online-test/?school_id=64");
    }

    public static void typeInField(WebElement xpath, String value) {
        String val = value;

        xpath.clear();

        for (int i = 0; i < val.length(); i++) {
            char c = val.charAt(i);
            String s = new StringBuilder().append(c).toString();
            xpath.sendKeys(s);
        }
    }

    public static String getNumbersFromString(String stringWithNum) {
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher m = pattern.matcher(stringWithNum);
        if (m.find()) {
            return m.group(1);
        }
        throw new RuntimeException("Cannot find numbers in String");
    }

}
