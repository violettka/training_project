package utils;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JsonReader {

    private WebDriver driverHeadless = SeleniumUtils.getDriverHeadless();

    public String getJsonElement(String url, String xPath, String element) throws InterruptedException {
        SeleniumUtils.initializeAndAuthorize(driverHeadless);
        driverHeadless.get(url);
        JSONObject test = new JSONObject(driverHeadless.findElement(By.xpath(xPath)).getText());
        driverHeadless.quit();
        return test.get(element).toString();
    }
}
