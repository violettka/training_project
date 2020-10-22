package school;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GenerateRandomNumber;
import utils.SeleniumUtils;

public class InvoicesPage {

    @FindBy(xpath = "//div[contains(@id, 'InvoicesTable')]//input[contains(@id, 'BasicSearch-I')]")
    private WebElement search;
    @FindBy(xpath = "//div[contains(@id, 'InvoicesTable')]//div[contains(@id,'BasicSearch-search')]")
    private WebElement clickSearch;
    @FindBy(xpath = "//td[contains(@id,'InvoicesTable-rows-row0-col0')]//span[@data-sap-ui]")
    private WebElement openInvoice;
    @FindBy(xpath = "//td[contains(@id,'InvoicesTable-rows-row0-col1')]//span[@data-sap-ui]")
    private WebElement status;


    public WebElement getSearch() {
        return search;
    }

    public WebElement getClickSearch() {
        return clickSearch;
    }

    public WebElement getOpenInvoice() {
        return openInvoice;
    }

    public WebElement getStatus() {
        return status;
    }

    public void checkNewContractExist(){
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        wait.until(ExpectedConditions.visibilityOf(getSearch()));
        SeleniumUtils.typeInField(getSearch(), GenerateRandomNumber.getRandomNumber());
        getClickSearch().click();
        wait.until(ExpectedConditions.textToBePresentInElement(getOpenInvoice(), GenerateRandomNumber.getRandomNumber()));
        assert getOpenInvoice().getText().contains(GenerateRandomNumber.getRandomNumber());
        //       assert invoicesPage.getStatus().getText().equals("Новый");
    }
}
