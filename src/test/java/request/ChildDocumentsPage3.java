package request;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DateUtils;
import utils.SeleniumUtils;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.time.LocalDate;

public class ChildDocumentsPage3 {

    @FindBy(xpath = "//input[@id ='birth_cert_num']")
    private WebElement birthCertNum;
    @FindBy(xpath = "//input[@id ='birth_cert_date']")
    private WebElement birthCertDate;
    @FindBy(xpath = "//input[@id='birth_cert_issuer']")
    private WebElement birthCertIssuer;
    @FindBy(xpath = "//div[@id=\"birth_cert_file\"]//i[text()='attach_file']")
    private WebElement attachBirthCertButton;
    @FindBy(xpath = "//div[@id=\"birth_cert_file\"]//input[@type='file']")
    private WebElement attachBirthCertInput;
    @FindBy(xpath = "//div[@id=\"birth_cert_translation_file\"]//input[@type='file']")
    private WebElement attachBirthCertTranslationInput;
    @FindBy(xpath = "//input[@id=\"home_book_date\"]")
    private WebElement homeBookDate;
    @FindBy(xpath = "//div[@id=\"home_book_file\"]//input[@type='file']")
    private WebElement attachHomeBookInput;
    @FindBy(xpath = "//div[@id=\"score_board_file\"]//input[@type='file']")
    private WebElement attachScoreBoardFileInput;
    @FindBy(xpath = "//div[@id=\"student_documents_tab\"]//h1")
    private WebElement titleStep3;
    @FindBy(xpath = "//input[@id='student_passport_num']")
    private WebElement inputStudentPassportNum;
    @FindBy(xpath = "//input[@id='student_passport_issuer']")
    private WebElement inputStudentPassportIssuer;
    @FindBy(xpath = "//input[@id='student_passport_date']")
    private WebElement inputStudentPassportDate;
    @FindBy(xpath = "//div[@id='student_passport_file_1']//input[@type='file']")
    private WebElement attachStudentPassportFile1;
    @FindBy(xpath = "//div[@id='student_passport_file_2']//input[@type='file']")
    private WebElement attachStudentPassportFile2;
    @FindBy(xpath = "//div[@id='student_passport_translation_file']//input[@type='file']")
    private WebElement attachStudentTranslationPassportFile;

    @FindBy(xpath = "//input[@id='snils_num']")
    private WebElement snilsNum;
    @FindBy(xpath = "//input[@id='snils_date']")
    private WebElement snilsDate;
    @FindBy(xpath = "//div[@id='snils_file']//input[@type='file']")
    private WebElement snilsFile;

    @FindBy(xpath = "//div[@id='general_edu_cert_file']//input[@type='file']")
    private WebElement generalEduCertFile;

    @FindBy(xpath = "//div[@id='student_documents_tab']//button[@class='next_step_btn v-btn v-btn--contained theme--light v-size--default isotm']/span/i")
    private WebElement buttonNextStep;
    @FindBy(xpath = "//h1[text()='О родителе / законном представителе']")
    private WebElement titleStep4;

    public ChildDocumentsPage3() throws URISyntaxException {
    }


    public WebElement getBirthCertNum() {
        return birthCertNum;
    }

    public WebElement getBirthCertDate() {
        return birthCertDate;
    }

    public WebElement getAttachBirthCertButton() {
        return attachBirthCertButton;
    }

    public WebElement getHomeBookDate() {
        return homeBookDate;
    }

    public WebElement getTitleStep3() {
        return titleStep3;
    }

    public WebElement getAttachBirthCertInput() {
        return attachBirthCertInput;
    }

    public WebElement getAttachBirthCertTranslationInput() {
        return attachBirthCertTranslationInput;
    }

    public WebElement getAttachScoreBoardFileInput() {
        return attachScoreBoardFileInput;
    }

    public WebElement getAttachHomeBookInput() {
        return attachHomeBookInput;
    }

    public WebElement getInputStudentPassportNum() {
        return inputStudentPassportNum;
    }

    public WebElement getInputStudentPassportIssuer() {
        return inputStudentPassportIssuer;
    }

    public WebElement getInputStudentPassportDate() {
        return inputStudentPassportDate;
    }

    public WebElement getAttachStudentPassportFile1() {
        return attachStudentPassportFile1;
    }

    public WebElement getAttachStudentPassportFile2() {
        return attachStudentPassportFile2;
    }

    public WebElement getButtonNextStep() {
        return buttonNextStep;
    }

    public WebElement getTitleStep4() {
        return titleStep4;
    }

    public WebElement getSnilsNum() {
        return snilsNum;
    }

    public WebElement getSnilsDate() {
        return snilsDate;
    }

    public WebElement getSnilsFile() {
        return snilsFile;
    }

    public WebElement getGeneralEduCertFile() {
        return generalEduCertFile;
    }

    public WebElement getAttachStudentTranslationPassportFile() {
        return attachStudentTranslationPassportFile;
    }

    public WebElement getBirthCertIssuer() {
        return birthCertIssuer;
    }

    private String fileToUploadPath = Paths.get(getClass().getClassLoader().getResource("uploadFile.pdf").toURI()).toString();

    public String calculateHomeBookDate() { //Выписка из домовой книги не позднее 1 месяца
        LocalDate today = LocalDate.now();
        return DateUtils.getStringRepresentation(today.minusDays(28), "ddMMyyyy");
    }

    public void snilsChild(String snilsNum, String snilsDate, String fileToUploadPath) throws InterruptedException {
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        wait.until(ExpectedConditions.visibilityOfAllElements((getSnilsNum())));
        SeleniumUtils.typeInField(getSnilsNum(),snilsNum);
        getSnilsDate().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((getSnilsDate())));
        SeleniumUtils.typeInField(getSnilsDate(),snilsDate);
        getSnilsFile().sendKeys(fileToUploadPath);
    }

    // Документы ребенка - свидетельство о рождении
    public void childDocuments(String cerNumber, String certDate, String birthCertIssuer) throws InterruptedException {
        SeleniumUtils.typeInField(getBirthCertNum(),cerNumber);
        getBirthCertDate().click();
        getBirthCertIssuer().sendKeys(birthCertIssuer);
        SeleniumUtils.typeInField(getBirthCertDate(),certDate);
        getAttachBirthCertInput().sendKeys(fileToUploadPath);
        getAttachBirthCertTranslationInput().sendKeys(fileToUploadPath);
    }

    // Домовая книга
    public void childDocumentsHomeBook() throws InterruptedException {
        //getHomeBookDate().sendKeys(calculateHomeBookDate());
        SeleniumUtils.typeInField(getHomeBookDate(),calculateHomeBookDate());
        getAttachHomeBookInput().sendKeys(fileToUploadPath);
    }

    // Паспорт ребенка
    public void childPassword(String passportNum, String passportIssuer, String passportDate)
            throws InterruptedException {
        SeleniumUtils.typeInField(getInputStudentPassportNum(),passportNum);
        getInputStudentPassportIssuer().sendKeys(passportIssuer);
        getInputStudentPassportDate().click();
        Thread.sleep(500);
        SeleniumUtils.typeInField(getInputStudentPassportDate(),passportDate);
        getAttachStudentPassportFile1().sendKeys(fileToUploadPath);
        getAttachStudentPassportFile2().sendKeys(fileToUploadPath);
    }
    // Иностранный паспорт ребенка
    public void childForeignPassword(String passportNum, String passportIssuer, String passportDate)
            throws InterruptedException {
        SeleniumUtils.typeInField(getInputStudentPassportNum(),passportNum);
        getInputStudentPassportIssuer().sendKeys(passportIssuer);
        getInputStudentPassportDate().click();
        Thread.sleep(500);
        //getInputStudentPassportDate().sendKeys(passportDate);
        SeleniumUtils.typeInField(getInputStudentPassportDate(),passportDate);
        getAttachStudentPassportFile1().sendKeys(fileToUploadPath);
        getAttachStudentPassportFile2().sendKeys(fileToUploadPath);
        getAttachStudentTranslationPassportFile().sendKeys(fileToUploadPath);
    }

}
