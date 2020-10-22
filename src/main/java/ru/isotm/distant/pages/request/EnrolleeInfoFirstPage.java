package request;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.isotm.distant.pages.BasePage;
import utils.DateUtils;
import utils.GenerateRandomNumber;
import utils.SeleniumUtils;
import values.ApplicationGeneralInfoValues;
import values.ChildTestInformationStep1Values;
import values.ChildTestInformationStep2Values;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class EnrolleeInfoFirstPage extends BasePage {

    public EnrolleeInfoFirstPage(){ }

    public static final By lastName = By.id("student_surename");


    @FindBy(xpath = "//input[@id='student_name']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='student_middle_name']")
    private WebElement fatherName;
    @FindBy(xpath = "//label[@for='student_gender']//..//i")
    private WebElement selectGender;
    @FindBy(xpath = "//input[@id='student_birth_date']")
    private WebElement birthdayDate;
    @FindBy(xpath = "//input[@id='student_citezenship']//../following-sibling::div//i")
    private WebElement citizenshipChild;
    @FindBy(xpath = "//input[@id='contract_year']")
    private WebElement yearToGoToSchool;
    @FindBy(xpath = "//input[@id='contract_year']//../div")
    private WebElement yearToGoToSchoolText;
    @FindBy(xpath = "//input[@id=\"contract_year\"]//../following-sibling::div//i")
    private WebElement selectYear;
    @FindBy(xpath = "//input[@id='learning_start_date']")
    private WebElement startDate;
    @FindBy(xpath = "//input[@id='class_number']//../following-sibling::div//i")
    private WebElement whichClass;
    @FindBy(xpath = "//input[@id='is_studied']//../following-sibling::div//i")
    private WebElement personalDocument;
    @FindBy(xpath = "//input[@id=\"is_studied\"]/../div")
    private WebElement personalDocumentText;
    @FindBy(xpath = "//button[@id='confirm_studied_yes_btn']")
    private WebElement buttonConfirmStadiedYes;
    @FindBy(xpath = "//button[@id='confirm_studied_no_btn']")
    private WebElement buttonConfirmStadiedNo;
    @FindBy(xpath = "//input[@id='internet_lessons']")
    private WebElement internetLesson;
    @FindBy(xpath = "//input[@id='internet_lessons']//../following-sibling::div//i")
    private WebElement selectInternetLesson;
    @FindBy(xpath = "//input[@id='second_language']//../following-sibling::div//i")
    private WebElement selectSecondLanguage;
    @FindBy(xpath = "//input[@id='is_second_language_first_year']//../following-sibling::div//i")
    private WebElement selectIsSecondLanguageFirstYear;
    @FindBy(xpath = "//input[@id='perm_reg_type']//../following-sibling::div//i")
    private WebElement selectRegistration;
    @FindBy(xpath = "//textarea[@id='perm_reg_address']")
    private WebElement addressRegistration;
    @FindBy(xpath = "//input[@id='is_fact_reg_same']//../following-sibling::div//i")
    private WebElement selectActualAddress;
    @FindBy(xpath = "//textarea[@id='fact_address']")
    private WebElement writeActualAddress;
    @FindBy(xpath = "//div[@id='general_info_tab']//button/span/i")
    private WebElement buttonGeneralInfo;

    @FindBy(xpath = "//div[@class='v-messages theme--light error--text']//div[@class='v-messages__message']")
    private List<WebElement> listErrorMessages;

    @FindBy(xpath = "//div[@class='v-stepper__content'][2]")
    private WebElement block;

    @FindBy(xpath = "//div[@class='v-menu__content theme--light menuable__content__active']//div[@class='v-list-item__content']")
    private List<WebElement> dropdownMenu;


    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getFatherName() {
        return fatherName;
    }

    public WebElement getSelectGender() {
        return selectGender;
    }

    public WebElement getBirthdayDate() {
        return birthdayDate;
    }

    public WebElement getCitizenshipChild() {
        return citizenshipChild;
    }

    public WebElement getYearToGoToSchool() {
        return yearToGoToSchool;
    }

    public WebElement getSelectYear() {
        return selectYear;
    }

    public WebElement getStartDate() {
        return startDate;
    }

    public WebElement getWhichClass() {
        return whichClass;
    }

    public WebElement getPersonalDocument() {
        return personalDocument;
    }

    public WebElement getButtonConfirmStadiedNo() {
        return buttonConfirmStadiedNo;
    }

    public WebElement getButtonConfirmStadiedYes() {
        return buttonConfirmStadiedYes;
    }

    public WebElement getPersonalDocumentText() {
        return personalDocumentText;
    }

    public WebElement getInternetLesson() {
        return internetLesson;
    }

    public WebElement getSelectInternetLesson() {
        return selectInternetLesson;
    }

    public WebElement getAddressRegistration() {
        return addressRegistration;
    }

    public WebElement getSelectRegistration() {
        return selectRegistration;
    }

    public WebElement getSelectActualAddress() {
        return selectActualAddress;
    }

    public WebElement getWriteActualAddress() {
        return writeActualAddress;
    }

    public WebElement getSelectSecondLanguage() {
        return selectSecondLanguage;
    }

    public WebElement getSelectIsSecondLanguageFirstYear() {
        return selectIsSecondLanguageFirstYear;
    }

    public WebElement getYearToGoToSchoolText() {
        return yearToGoToSchoolText;
    }

    public WebElement getButtonGeneralInfo() {
        return buttonGeneralInfo;
    }

    public WebElement getBlock() {
        return block;
    }

    public List<WebElement> getDropdownMenu() {
        return dropdownMenu;
    }

    public List<WebElement> getListErrorMessages() {
        return listErrorMessages;
    }


    public static void fillInApplicationForm(){
        Faker faker = new Faker();
        $(lastName).setValue(faker.name().lastName());
        $(firstName).setValue()
    }

    public void selectDropdownElement(String element) {
        for (WebElement webElement : dropdownMenu) {
            if (webElement.getText().equals(element)) {
                webElement.click();
            }
        }
    }

    public void secondStepFillForm(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style = \"\";", block);
    }

    public String calculateEducationalYear() {
        LocalDate today = LocalDate.now();

        if (today.isBefore(today.withMonth(3).withDayOfMonth(31))) {
            return DateUtils.getStringRepresentation(today.minusYears(1), "YYYY") +
                    " - " +
                    DateUtils.getStringRepresentation(today, "YYYY");
        } else {
            return DateUtils.getStringRepresentation(today, "YYYY") +
                    " - " +
                    DateUtils.getStringRepresentation(today.plusYears(1), "YYYY");
        }
    }

    public String calculateStartOfEducationalYear() {
        LocalDate today = LocalDate.now();
        return DateUtils.getStringRepresentation(today.withMonth(9).withDayOfMonth(1), "dd.MM.yyyy");

    }


    public String calculateErrorBirthDate(String startDate) {
        LocalDate educationalYearStartDate = DateUtils.getDateRepresentation(startDate, "dd.MM.yyyy");
        return DateUtils.getStringRepresentation(educationalYearStartDate.minusYears(6).minusMonths(4), "ddMMyyyy");
    }

    public void checkErrorMessageExistSize(int sizeToCheck, String textToCheck) {
        List<WebElement> errorMessages = getListErrorMessages();
        assert errorMessages.size() == sizeToCheck;
        for (WebElement errorMessage : errorMessages) {
            assert errorMessage.getText().equals(textToCheck);
        }
    }

    public void toFillInfo10_11Class(
            String fatherName, String firstName,
            String gender, String citizenship,
            String educationalYear,
            String classNumber,
            String registration, String address,
            String actualAddressConsider)
            throws InterruptedException {
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        String generatedLastName = GenerateRandomNumber.generateRandomNumber();
        getLastName().sendKeys(generatedLastName);
        assert getLastName().getAttribute("value").equals(generatedLastName);
        getFatherName().sendKeys(fatherName);
        getFirstName().sendKeys(firstName);
        getSelectGender().click();
        selectDropdownElement(gender);
        getCitizenshipChild().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(citizenship);
        getSelectYear().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(educationalYear);
        assert getBirthdayDate().isEnabled();
        ChildTestInformationStep1Values.setBirthDateYears(15);
        SeleniumUtils.typeInField(getBirthdayDate(), ChildTestInformationStep1Values.getChildBirthDateString());
        getWhichClass().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(classNumber);
        getPersonalDocument().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement("С отметкой о переводе в текущий класс");
        getSelectRegistration().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(registration);
        getAddressRegistration().sendKeys(address);
        getSelectActualAddress().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(actualAddressConsider);
        getButtonGeneralInfo().click();
        Thread.sleep(500);
    }


    public void stepOneFirstClass(WebDriver driver,
                                  String lastName, String firstName,
                                  String fatherName,
                                  String gender, String citizenship,
                                  String educationalYear, String classNumber,
                                  String registration, String address,
                                  String actualAddressConsider, String writeActualAddress)
            throws InterruptedException {
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        String generatedLastName = GenerateRandomNumber.generateRandomNumber();
        getLastName().sendKeys(generatedLastName);
        assert getLastName().getAttribute("value").equals(generatedLastName);
        getFirstName().sendKeys(firstName);
        ApplicationGeneralInfoValues.studentName = firstName;
        getFatherName().sendKeys(fatherName);
        ApplicationGeneralInfoValues.studentMiddleName = fatherName;
        getSelectGender().click();
        selectDropdownElement(gender);
        getCitizenshipChild().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(citizenship);
        getSelectYear().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(educationalYear);
        Thread.sleep(200);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String educationalStartDate = js.executeScript("return document.getElementById('learning_start_date').value;").toString();
        ChildTestInformationStep1Values.educationalStartDate = educationalStartDate;
        assert getBirthdayDate().isEnabled();
        Thread.sleep(200);
        getBirthdayDate().click();
        SeleniumUtils.typeInField(getBirthdayDate(), DateUtils.calculateMinimumBirthDate(educationalStartDate));
        getWhichClass().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(classNumber);
        getSelectRegistration().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(registration);
        getAddressRegistration().sendKeys(address);
        getSelectActualAddress().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(actualAddressConsider);
        getWriteActualAddress().sendKeys(writeActualAddress);

        ChildTestInformationStep2Values.setDiagTestList(new ArrayList<>());
        ChildTestInformationStep2Values.priceTest = null;
    }
    public void check10ClassStep1(
            String firstName, String fatherName,
            String gender, String citizenship,
            String educationalYear,
            String classNumber, String secondLanguage, String selectIsSecondLanguageFirstYear,
            String registration, String address,
            String actualAddressConsider, String writeActualAddress)
            throws InterruptedException {
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        String generatedLastName = GenerateRandomNumber.generateRandomNumber();
        getLastName().sendKeys(generatedLastName);
        assert getLastName().getAttribute("value").equals(generatedLastName);
        getFirstName().sendKeys(firstName);
        getFatherName().sendKeys(fatherName);
        getSelectGender().click();
        selectDropdownElement(gender);
        getCitizenshipChild().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((getDropdownMenu())));
        selectDropdownElement(citizenship);
        getSelectYear().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((getDropdownMenu())));
        selectDropdownElement(educationalYear);
        assert getBirthdayDate().isEnabled();
        ChildTestInformationStep1Values.setBirthDateYears(15);
        SeleniumUtils.typeInField(getBirthdayDate(),ChildTestInformationStep1Values.getChildBirthDateString());
        getWhichClass().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((getDropdownMenu())));
        selectDropdownElement(classNumber);
        getSelectSecondLanguage().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((getDropdownMenu())));
        selectDropdownElement(secondLanguage);
        getSelectIsSecondLanguageFirstYear().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((getDropdownMenu())));
        selectDropdownElement(selectIsSecondLanguageFirstYear);
        getPersonalDocument().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((getDropdownMenu())));
        selectDropdownElement("С отметкой о переводе в текущий класс");
        Thread.sleep(500);
        getSelectRegistration().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((getDropdownMenu())));
        selectDropdownElement(registration);
        getAddressRegistration().sendKeys(address);
        getSelectActualAddress().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((getDropdownMenu())));
        selectDropdownElement(actualAddressConsider);
        getWriteActualAddress().sendKeys(writeActualAddress);
        getButtonGeneralInfo().click();
    }
}
