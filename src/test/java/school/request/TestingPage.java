package school.request;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DateUtils;
import utils.GenerateRandomNumber;
import utils.JsonReader;
import utils.SeleniumUtils;
import values.ChildTestInformationStep2Values;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class TestingPage {
    @FindBy(xpath = "//div[@id='__filter3-text']")
    private WebElement testingIcon;
    @FindBy(xpath = "//tbody[@id='isotm---OnlineRequestDetailsView--TestResultsTableDisplay-tblBody']/tr/td/span")
    private List<WebElement> resultsTableDiagTestList;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--PriceText']")
    private WebElement priceText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--ResultText']")
    private WebElement resultText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--EditButton-inner']")
    private WebElement editButton;
    @FindBy(xpath = "//bdi[@id='isotm---OnlineRequestDetailsView--SaveButton-BDI-content']")
    private WebElement saveButton;
    @FindBy(xpath = "//bdi[@id='__mbox-btn-0-BDI-content']")
    private WebElement okButton;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--SchoolPicker-arrow']")
    private WebElement schoolPicker;
    @FindBy(xpath = "//li[@id='__item15-isotm---OnlineRequestDetailsView--SchoolPicker-44']")
    private WebElement schoolPicker43Nasledie;
    @FindBy(xpath = "//div[@id='__filter0-text']")
    private WebElement iconStudent;
    @FindBy(xpath = "//label[@id='isotm---OnlineRequestDetailsView--StudentClassInput-label']")
    private WebElement studentClassInput;
    @FindBy(xpath = "//li[@id='__item17-isotm---OnlineRequestDetailsView--StudentClassInput-10']")
    private WebElement studentClassInput10;
    @FindBy(xpath = "//bdi[@id='isotm---OnlineRequestDetailsView--CreateContractBtn-BDI-content']")
    private WebElement buttonCreateContract;
    @FindBy(xpath = "//bdi[@id='__button14-BDI-content']")
    private WebElement buttonCreateContractOK;
    @FindBy(xpath = "//input[@id='CreateContractFragment--ContractDateInput-inner']")
    private WebElement inputContractData;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--RequestStatusText-text']")
    private WebElement requestStatusText;

    @FindBy(xpath = "//tbody[@id='isotm---OnlineRequestDetailsView--TestResultEditTable-tblBody']/tr")
    private List<WebElement> listOfSubjects;
    @FindBy(xpath = "//table[@id='isotm---OnlineRequestDetailsView--TestResultEditTable-listUl']//div[@role='checkbox']")
    private List<WebElement> listOfCheckBox;
    @FindBy(xpath = "//table[@id='isotm---OnlineRequestDetailsView--TestResultEditTable-listUl']//span[@class='sapMSltArrow']")
    private List<WebElement> listOfGrades;
    @FindBy(xpath = "//div[@class='sapUiSimpleFixFlexFlexContent']/ul[@class='sapMSelectList sapMSltList-CTX']/li")
    private List<WebElement> dropdownMenu;
    @FindBy(xpath = "//textarea[@id='isotm---OnlineRequestDetailsView--CommentInput-inner']")
    private WebElement comment;

    public WebElement getTestingIcon() {
        return testingIcon;
    }

    public List<WebElement> getResultsTableDiagTestList() {
        return resultsTableDiagTestList;
    }

    public WebElement getPriceText() {
        return priceText;
    }

    public WebElement getResultText() {
        return resultText;
    }

    public WebElement getEditButton() {
        return editButton;
    }

    public WebElement getSchoolPicker() {
        return schoolPicker;
    }

    public WebElement getSchoolPicker43Nasledie() {
        return schoolPicker43Nasledie;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getOkButton() {
        return okButton;
    }

    public WebElement getIconStudent() {
        return iconStudent;
    }

    public WebElement getStudentClassInput() {
        return studentClassInput;
    }

    public WebElement getStudentClassInput10() {
        return studentClassInput10;
    }

    public List<WebElement> getDropdownMenu() {
        return dropdownMenu;
    }

    public List<WebElement> getListOfSubjects() {
        return listOfSubjects;
    }

    public List<WebElement> getListOfCheckBox() {
        return listOfCheckBox;
    }

    public List<WebElement> getListOfGrades() {
        return listOfGrades;
    }

    public WebElement getButtonCreateContract() {
        return buttonCreateContract;
    }

    public WebElement getInputContractData() {
        return inputContractData;
    }

    public WebElement getButtonCreateContractOK() {
        return buttonCreateContractOK;
    }

    public WebElement getRequestStatusText() {
        return requestStatusText;
    }

    public WebElement getComment() {
        return comment;
    }

    public List<WebElement> getSubjectList() {
        List<WebElement> subjectList = new ArrayList<>();
        subjectList.addAll(getResultsTableDiagTestList());
        subjectList.removeIf(it -> it.getText().equals("Не выполнено"));
        return subjectList;
    }

    public void editSchool() throws InterruptedException, IOException {
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        getTestingIcon().click();
        wait.until(ExpectedConditions.visibilityOf(getPriceText()));
        String oldPrice = getPriceText().getText();
        String oldResultText = getResultText().getText();
        getEditButton().click();
        getSchoolPicker().click();
        wait.until(ExpectedConditions.visibilityOf(getSchoolPicker43Nasledie()));
        getSchoolPicker43Nasledie().click();
        getSaveButton().click();
        wait.until(ExpectedConditions.visibilityOf(getOkButton()));
        getOkButton().click();
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(getPriceText(), oldPrice)));
        assert getResultText().getText().equals(oldResultText);
    }

    public void editClass() throws InterruptedException, IOException {
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        getTestingIcon().click();
        wait.until(ExpectedConditions.visibilityOf(getPriceText()));
        String oldResultText = getResultText().getText();
        String oldPrice = getPriceText().getText();
        getEditButton().click();
        getIconStudent().click();
        getStudentClassInput().click();
        wait.until(ExpectedConditions.visibilityOf(getStudentClassInput10()));
        getStudentClassInput10().click();
        getSaveButton().click();
        wait.until(ExpectedConditions.visibilityOf(getOkButton()));
        getOkButton().click();
        getTestingIcon().click();
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(getPriceText(), oldPrice)));
        assert !oldPrice.equals(getPriceText());
        assert getResultText().getText().equals(oldResultText);

    }

    public void editStatusOfTestResult(int gradeNumber) {
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        //getTestingIcon().click();
        wait.until(ExpectedConditions.visibilityOf(getResultText()));
        String oldResult = getResultText().getText();
        getEditButton().click();
        for (WebElement i : getListOfCheckBox()) {
            i.click();
        }
        for (WebElement subject: listOfSubjects) {
                subject.isEnabled();
            for (WebElement dropdown : listOfGrades) {
                dropdown.click();
                for (WebElement grade : dropdownMenu) {
                    if (grade.getText().equals(String.valueOf(gradeNumber))) {
                        grade.click();
                    }
                }
            }
        }
        getSaveButton().click();
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(getResultText(), oldResult)));
        if (gradeNumber >= 3)
            assert getResultText().getText().equals("Аттестован");
        else
            assert getResultText().getText().equals("Не аттестован");
    }

    public void createContract() {
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        String oldStatus = getRequestStatusText().getText();
        String contractData = DateUtils.getStringRepresentation(LocalDate.now(),"M/d/yy");
        getButtonCreateContract().click();
        wait.until(ExpectedConditions.visibilityOf(getInputContractData()));
        getInputContractData().sendKeys(contractData);
        getButtonCreateContractOK().click();
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(getRequestStatusText(), oldStatus)));
        assert getRequestStatusText().getText().equals("Договор");
    }

    public void compareDiagTestListFromRequest(String studentClassText) {
        List<WebElement> subjectListDb = getSubjectList();
        assert subjectListDb.size() == ChildTestInformationStep2Values.diagTestsList.size();
        for (int i = 0; i < subjectListDb.size(); i++) {
            assert subjectListDb.get(i).getText().equals(ChildTestInformationStep2Values.diagTestsList.get(i));
        }
        if (ChildTestInformationStep2Values.priceTest != null) {
            assert SeleniumUtils.getNumbersFromString(getPriceText().getText())
                    .equals(SeleniumUtils.getNumbersFromString(ChildTestInformationStep2Values.priceTest));
        }
        if (!studentClassText.equals("1")) {
            assert getResultText().getText().equals("Задолженность");
        }
        else {
            assert getResultText().getText().equals("Не требуется");
        }
    }

    public void addCommentAndCheckStatusOfResultTesting() throws InterruptedException {
        String oldResultText = getResultText().getText();
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        wait.until(ExpectedConditions.visibilityOf(getEditButton()));
        getEditButton().click();
        getComment().sendKeys("Напишем комментарий и проверим, что Статус результата тестирования не изменился");
        getSaveButton().click();
        Thread.sleep(200);
        assert getResultText().getText().equals(oldResultText);

    }
}



