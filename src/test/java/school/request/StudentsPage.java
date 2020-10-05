package school.request;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GenerateRandomNumber;
import utils.SeleniumUtils;
import values.ApplicationGeneralInfoValues;

import java.util.List;

public class StudentsPage {
    @FindBy(xpath = "//div[contains(@id, 'StudentsTable')]//input[contains(@id, 'BasicSearch-I')]")
    private WebElement search;
    @FindBy(xpath = "//div[contains(@id, 'StudentsTable')]//div[contains(@id, 'BasicSearch-search')]")
    private WebElement clickSearch;
    @FindBy(xpath = "//td[contains(@id,'StudentsTable-rows-row0-col0')]//div[@class='sapMFlexItemAlignAuto sapMFlexBoxBGTransparent sapMFlexItem']/span[@data-sap-ui]")
    private WebElement openStudent;
    @FindBy(xpath = "//td[contains(@id,'StudentsTable-rows-row0-col1')]/div[@class='sapUiTableCellInner']/span[@id = '__text3-__clone1']")
    private WebElement status;
    @FindBy(xpath = "//button[@id='__button5']")
    private WebElement studenStatusIcon;
    @FindBy(xpath = "//button[@id='__xmlview1--ResetFilterBtn']")
    private WebElement buttonResetFilters;
    @FindBy(xpath = "//div[contains(@id, 'StudentStatusFilter-0-selectMulti-CbBg')]")
    private WebElement checkBoxEnroll; //Зачислен
    @FindBy(xpath = "//div[contains (@id, 'StudentStatusFilter-2-selectMulti-CbBg')]")
    private WebElement checkBoxNew; //Новый студент
    @FindBy(xpath = "//button[@id='__button10']")
    private WebElement buttonOk;
    @FindBy(xpath = "//td[contains(@id, 'StudentsTable-rows-row0-col0')]//button[contains(@id, 'button')]")
    private WebElement buttonStudentInfoOpen;
    @FindBy(xpath = "//span[@id='__button14-content']/bdi")
    private WebElement buttonEdit;
    @FindBy(xpath = "//input[@id='EnrollDialogFragment--EnrollDocNumberInput-inner']")
    private WebElement enrollDocNumText;
    @FindBy(xpath = "//span[contains(@id, 'ChangeStatusBtn-internalBtn-inner')]")
    private WebElement buttonChangeStatus;
    //@FindBy(xpath = "//div[@id='__xmlview1--SetDeductBtn-unifiedmenu-txt']")
    @FindBy(xpath = "//div[@id='__menu2']/ul/li")
    private WebElement buttonExpel;   //скрытая кнопка отчислить ученика
    @FindBy(xpath = "//div[contains (@id, 'SetEnrolledBtn-unifiedmenu-txt')]")
    private WebElement buttonEnroll;   //скрытая кнопка зачислить ученика
    @FindBy(xpath = "//div[contains (@id, 'SetInWorkBtn-unifiedmenu-txt')]")
    private WebElement buttonInWorking;   //скрытая кнопка в работе
    @FindBy(xpath = "//input[@id='EnrollDialogFragment--EnrollDocNumberInput-inner']")
    private WebElement inputEnrollDocNumber;
    @FindBy(xpath = "//input[@id='EnrollDialogFragment--EnrollDocDateInput-inner']")
    private WebElement inputEnrollDate;
    @FindBy(xpath = "//input[@id='DeductDialogFragment--DeductionDatePicker-inner']")
    private WebElement inputExpelDate;
    @FindBy(xpath = "//bdi[@id='DeductDialogFragment--DeductButton-BDI-content']")
    private WebElement deductButtonDialogFragment; //кнопка отчисления в диалоговом окне
    @FindBy(xpath = "//bdi[@id='EnrollDialogFragment--EnrollBtn-BDI-content']")
    private WebElement enrollButtonDialogFragment; //кнопка зачисления в диалоговом окне

    @FindBy(xpath = "//button[@id='__button15']")
    private WebElement buttonSaveChanges;
    @FindBy(xpath = "//span[@id='__xmlview2--StatusText-text']")
    private WebElement textStudentStatus;


//ФИО и остальные сведения об ученике
    @FindBy(xpath = "//span[contains(@id,'StudentSurenameText')]")
    private WebElement studentSurenameText;
    @FindBy(xpath = "//span[contains(@id,'StudentNameText')]")
    private WebElement studentNameText;
    @FindBy(xpath = "//span[contains(@id,'StudentMiddleNameText')]")
    private WebElement studentMiddleNameText;
    @FindBy(xpath = "//span[contains(@id,'StudentGenderText')]")
    private WebElement studentGenderText;
    @FindBy(xpath = "//span[contains(@id,'StudentBirthDateText')]")
    private WebElement studentBirthDateText;
    @FindBy(xpath = "//span[contains(@id,'StudentCitizenshipText')]")
    private WebElement studentCitizenshipText;
    @FindBy(xpath = "//span[contains(@id,'StudentBirthdayCertNumText')]")
    private WebElement studentBirthdayCertNumText;
    @FindBy(xpath = "//span[contains(@id,'StudentBirthdayCertDateText')]")
    private WebElement studentBirthdayDateNumText;
    @FindBy(xpath = "//span[contains(@id,'StudentBirthdateIssuerText')]")
    private WebElement studentBirthdayIssuerText;


    //информация о родителе
    @FindBy(xpath = "//span[contains(@id,'FioParentText')]")
    private WebElement fioParentText;
    @FindBy(xpath = "//span[contains(@id,'ParentGenderText')]")
    private WebElement parentGenderText;
    @FindBy(xpath = "//span[contains(@id,'ParentBirthDateText')]")
    private WebElement parentBirthDateText;
    @FindBy(xpath = "//span[contains(@id,'RepresentativeStatusText')]")
    private WebElement parentRepresentativeStatusText;
    @FindBy(xpath = "//span[contains(@id,'ParentCitezenshipText')]")
    private WebElement parentCitezenshipText;
    @FindBy(xpath = "//span[contains(@id,'ParentPhoneText')]")
    private WebElement parentPhoneText;
    @FindBy(xpath = "//a[contains(@id,'EmailParentText')]")
    private WebElement parentEmailText;
    @FindBy(xpath = "//span[contains(@id,'PostAddressText')]")
    private WebElement parentPostAddress;
    @FindBy(xpath = "//span[contains(@id,'ParentPassportNumText')]")
    private WebElement parentPassportNum;
    @FindBy(xpath = "//span[contains(@id,'ParentPassportRegText')]")
    private WebElement parentPassportRegNum;



    @FindBy(xpath = "//div[contains(@id, 'StudentStatusFilter')]/div[@class= 'sapMFFLITitle']")
    private List <WebElement> studenStatusTextList;
    @FindBy(xpath = "//uL[contains(@id, 'StudentStatusFilter-listUl')]//input[@type='CheckBox']")
    private List <WebElement> studenStatusCheckBoxList;

    public WebElement getSearch() {
        return search;
    }

    public WebElement getClickSearch() {
        return clickSearch;
    }

    public WebElement getOpenStudent() {
        return openStudent;
    }

    public WebElement getStatus() {
        return status;
    }

    public WebElement getStudenStatusIcon() {
        return studenStatusIcon;
    }

    public WebElement getButtonResetFilters() {
        return buttonResetFilters;
    }

    public WebElement getCheckBoxEnroll() {
        return checkBoxEnroll;
    }

    public WebElement getButtonOk() {
        return buttonOk;
    }

    public WebElement getButtonEdit() {
        return buttonEdit;
    }

    public WebElement getEnrollDocNumText() {
        return enrollDocNumText;
    }

    public WebElement getCheckBoxNew() {
        return checkBoxNew;
    }

    public WebElement getButtonChangeStatus() {
        return buttonChangeStatus;
    }

    public WebElement getButtonExpel() {
        return buttonExpel;
    }

    public WebElement getInputExpelDate() {
        return inputExpelDate;
    }

    public WebElement getDeductButtonDialogFragment() {
        return deductButtonDialogFragment;
    }

    public WebElement getButtonSaveChanges() {
        return buttonSaveChanges;
    }

    public WebElement getTextStudentStatus() {
        return textStudentStatus;
    }

    public WebElement getStudentSurenameText() {
        return studentSurenameText;
    }

    public WebElement getStudentNameText() {
        return studentNameText;
    }

    public WebElement getStudentMiddleNameText() {
        return studentMiddleNameText;
    }

    public WebElement getStudentGenderText() {
        return studentGenderText;
    }

    public WebElement getStudentBirthDateText() {
        return studentBirthDateText;
    }

    public WebElement getStudentCitizenshipText() {
        return studentCitizenshipText;
    }

    public WebElement getButtonEnroll() {
        return buttonEnroll;
    }

    public WebElement getButtonInWorking() {
        return buttonInWorking;
    }

    public WebElement getInputEnrollDocNumber() {
        return inputEnrollDocNumber;
    }

    public WebElement getInputEnrollDate() {
        return inputEnrollDate;
    }

    public WebElement getEnrollButtonDialogFragment() {
        return enrollButtonDialogFragment;
    }

    public WebElement getStudentBirthdayCertNumText() {
        return studentBirthdayCertNumText;
    }

    public WebElement getStudentBirthdayDateNumText() {
        return studentBirthdayDateNumText;
    }

    public WebElement getStudentBirthdayIssuerText() {
        return studentBirthdayIssuerText;
    }

    public WebElement getFioParentText() {
        return fioParentText;
    }

    public WebElement getParentGenderText() {
        return parentGenderText;
    }

    public WebElement getParentBirthDateText() {
        return parentBirthDateText;
    }

    public WebElement getParentRepresentativeStatusText() {
        return parentRepresentativeStatusText;
    }

    public WebElement getParentCitezenshipText() {
        return parentCitezenshipText;
    }

    public WebElement getParentPhoneText() {
        return parentPhoneText;
    }

    public WebElement getParentEmailText() {
        return parentEmailText;
    }

    public WebElement getParentPostAddress() {
        return parentPostAddress;
    }

    public WebElement getParentPassportNum() {
        return parentPassportNum;
    }

    public WebElement getParentPassportRegNum() {
        return parentPassportRegNum;
    }

    public List<WebElement> getStudenStatusTextList() {
        return studenStatusTextList;
    }
    public List<WebElement> getStudenStatusCheckBoxList() {
        return studenStatusCheckBoxList;
    }

    public WebElement getButtonStudentInfoOpen() {
        return buttonStudentInfoOpen;
    }

    public void checkNewContractExist(){
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        wait.until(ExpectedConditions.visibilityOf(getSearch()));
        SeleniumUtils.typeInField(getSearch(), GenerateRandomNumber.getRandomNumber());
        getClickSearch().click();
        wait.until(ExpectedConditions.textToBePresentInElement(getOpenStudent(), GenerateRandomNumber.getRandomNumber()));
        assert getOpenStudent().getText().contains(GenerateRandomNumber.getRandomNumber());
       // assert getStatus().getText().equals("Новый");
    }

    public void deductEnrollStudent() throws InterruptedException {
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        wait.until(ExpectedConditions.visibilityOf(getButtonResetFilters()));
        getStudenStatusIcon().click();
        wait.until(ExpectedConditions.visibilityOfAllElements(getStudenStatusTextList()));
        getCheckBoxEnroll().click();
        getButtonOk().click();
        //wait.until(ExpectedConditions.visibilityOfAllElements(getButtonStudentInfoOpen()));
        Thread.sleep(200);
        getButtonStudentInfoOpen().click();
//        String enrollNum = getEnrollDocNumText().getText();
        getButtonChangeStatus().click();
        wait.until(ExpectedConditions.visibilityOf(buttonExpel));
        getButtonExpel().click();
        wait.until(ExpectedConditions.visibilityOf(inputExpelDate));
        getInputExpelDate().sendKeys("9/22/20");
        getDeductButtonDialogFragment().click();
        getButtonSaveChanges().click();
        assert textStudentStatus.getText().equals("Отчислен");
    }

    public void enrollNewStudent() throws InterruptedException {
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        wait.until(ExpectedConditions.visibilityOf(getButtonResetFilters()));
        getStudenStatusIcon().click();
        wait.until(ExpectedConditions.visibilityOfAllElements(getStudenStatusTextList()));
        getCheckBoxNew().click();
        getButtonOk().click();
        //wait.until(ExpectedConditions.visibilityOfAllElements(getButtonStudentInfoOpen()));
        Thread.sleep(200);
        getButtonStudentInfoOpen().click();
        Thread.sleep(200);
        getButtonChangeStatus().click();
        getButtonChangeStatus().click();
        wait.until(ExpectedConditions.visibilityOf(getButtonEnroll()));
        getButtonEnroll().click();
        wait.until(ExpectedConditions.visibilityOf(inputEnrollDocNumber));
        getEnrollDocNumText().sendKeys(GenerateRandomNumber.generateRandomNumber());
        getInputEnrollDate().sendKeys("9/22/20");
        getEnrollButtonDialogFragment().click();
        getEnrollButtonDialogFragment().click();
        getButtonSaveChanges().click();
        assert textStudentStatus.getText().equals("Зачислен");
    }

    public void enrollAndDeductNewStudent() throws InterruptedException {
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        getButtonStudentInfoOpen().click();
        Thread.sleep(600);
       // assert getStudentSurenameText().getText().equals(GenerateRandomNumber.getRandomNumber());
        assert getStudentNameText().getText().equals(ApplicationGeneralInfoValues.studentName);
        assert getStudentMiddleNameText().getText().equals(ApplicationGeneralInfoValues.studentMiddleName);
        assert getStudentGenderText().getText().equals("Женский");
        assert studentBirthDateText.getText().contains("01.04.2014");
        assert getStudentCitizenshipText().getText().equals("РФ");
        assert getParentPhoneText().getText().equals(null);
        assert getStudentBirthdayCertNumText().getText().equals("68465166");
        assert getStudentBirthDateText().getText().equals("14.02.2014");
        assert getStudentBirthdayIssuerText().getText().equals("Test");
        assert getFioParentText().getText().equals("Демидов Дмитрий Олегович");
        assert getParentGenderText().getText().equals("Мужской");
        assert getParentBirthDateText().getText().equals("14.01.1980");
        assert getParentRepresentativeStatusText().equals("Родитель");
        assert getParentCitezenshipText().getText().equals("РФ");
        assert getParentPassportNum().getText().equals("135131 Выдан УФМС России, 13.01.2009");
        assert getParentPassportRegNum().getText().equals("sdfghj");
        assert getParentPhoneText().getText().equals("4657686");
        assert getParentEmailText().getText().equals("testmail.distantisotm@mail.ru");
        assert getParentPostAddress().getText().equals("Комсомольская, 11");


        getButtonChangeStatus().click();
        wait.until(ExpectedConditions.visibilityOf(getButtonEnroll()));
        getButtonEnroll().click();
        wait.until(ExpectedConditions.visibilityOf(inputEnrollDocNumber));
        getEnrollDocNumText().sendKeys(GenerateRandomNumber.generateRandomNumber());
        getInputEnrollDate().sendKeys("9/22/20");
        getEnrollButtonDialogFragment().click();
        getEnrollButtonDialogFragment().click();
        getButtonSaveChanges().click();
        assert textStudentStatus.getText().equals("Зачислен");
    }
}
