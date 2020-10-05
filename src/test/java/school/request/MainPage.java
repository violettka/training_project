package school.request;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSubmit() {
        return submit;
    }

    public void login() throws InterruptedException {
        getUsername().sendKeys("rodionova_i");
        getPassword().sendKeys("berlin_test_2020");
        getSubmit().click();
        Thread.sleep(5000);
    }
}
