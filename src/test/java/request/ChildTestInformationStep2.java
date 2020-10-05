package request;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumUtils;
import values.ChildTestInformationStep2Values;

import java.util.List;

public class ChildTestInformationStep2 {

    @FindBy(xpath = "//div[@id=\"subject_list_tab\"]//h1")
    private WebElement textTitleStep2;
    @FindBy(xpath = "//div[@id='diag_tests_list']//div[@class='v-list-item__title']")
    private List<WebElement> diagTestsList;
    @FindBy(xpath = "//*[@id='subject_list_tab']//div/h2")
    private WebElement price;
    @FindBy(xpath = "//div[@id=\"subject_list_tab\"]//button[@class='next_step_btn v-btn v-btn--contained theme--light v-size--default isotm']/span/i")
    private WebElement buttonSubjectListTab;


    public WebElement getTextTitleStep2() {
        return textTitleStep2;
    }

    public WebElement getButtonSubjectListTab() {
        return buttonSubjectListTab;
    }
    public List<WebElement> getDiagTestsList() {
        return diagTestsList;
    }

    public WebElement getPrice() {
        return price;
    }

    public void saveDiagTestListValues(String diagTestStepHeader) {
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        wait.until(ExpectedConditions.visibilityOfAllElements(getTextTitleStep2()));
        assert getTextTitleStep2().getText().equals(diagTestStepHeader);
        ChildTestInformationStep2Values.setDiagTestList(getDiagTestsList());
    }

}
