package school;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GenerateRandomNumber;
import utils.SeleniumUtils;

public class ContractsPage {
    @FindBy(xpath = "//div[contains(@id, 'ContractsTable')]//input[contains(@id, 'BasicSearch-I')]")
    private WebElement search;
    @FindBy(xpath = "//div[contains(@id, 'ContractsTable')]//div[contains(@id, 'BasicSearch-search')]")
    private WebElement clickSearch;
    @FindBy(xpath = "//td[contains(@id,'ContractsTable-rows-row0-col0')]//span[@data-sap-ui][@class='sapMText sapUiSelectable sapMTextMaxWidth']")
    private WebElement openContract;
    @FindBy(xpath = "//td[contains(@id, 'ContractsTable-rows-row0-col1')]/div[@class='sapUiTableCellInner']//span[@class='sapMSelectListItemText']")
    private WebElement status;


    public WebElement getSearch() {
        return search;
    }
    public WebElement getClickSearch() {
        return clickSearch;
    }

    public WebElement getOpenContract() {
        return openContract;
    }

    public WebElement getStatus() {
        return status;
    }

    public void checkNewContractExist(){
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        wait.until(ExpectedConditions.visibilityOf(getSearch()));
        SeleniumUtils.typeInField(getSearch(), GenerateRandomNumber.getRandomNumber());
        getClickSearch().click();
        wait.until(ExpectedConditions.textToBePresentInElement(getOpenContract(), GenerateRandomNumber.getRandomNumber()));
        assert getOpenContract().getText().contains(GenerateRandomNumber.getRandomNumber());
        assert getStatus().getText().equals("Создан");
    }
}

