package request;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumUtils;

public class SubmitPage6 {

    @FindBy(xpath = "//div[@id='submit_form_tab']//h1")
    private WebElement submitPageHeader;
    @FindBy(xpath = "//input[@id=\"accept_gdpr_check\"]")
    private WebElement checkBox;
    @FindBy(xpath = "//textarea[@id='parent_comment']")
    private WebElement parentComment;
    @FindBy(xpath = "//button[@type=\"button\"]/*[text()='Отправить заявку']")
    private WebElement buttonSendRequest;
    @FindBy(xpath = "//div[@id=\"submit_form_tab\"]//i[contains(@class, 'success--text')]")
    private WebElement successIcon;

    public WebElement getSubmitPageHeader() {
        return submitPageHeader;
    }

    public WebElement getCheckBox() {
        return checkBox;
    }

    public WebElement getParentComment() {
        return parentComment;
    }

    public WebElement getButtonSendRequest() {
        return buttonSendRequest;
    }

    public WebElement getSuccessIcon() {
        return successIcon;
    }

    public void sendRequest(WebDriver driver, String parentComment){
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        WebDriverWait waitRequestSent = SeleniumUtils.getDriverWait(200);
        wait.until(ExpectedConditions.visibilityOf(getSubmitPageHeader()));
        assert getSubmitPageHeader().getText().equals("Завершение");
        getParentComment().sendKeys(parentComment);
        Actions act= new Actions(driver);
        act.moveToElement(getCheckBox()).click().build().perform();
        getButtonSendRequest().click();
        waitRequestSent.until(ExpectedConditions.visibilityOf(getSuccessIcon()));
    }
}

