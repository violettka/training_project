 import io.qameta.allure.Attachment;
 import io.qameta.allure.Description;
 import io.qameta.allure.junit4.DisplayName;
 import org.junit.*;
 import org.junit.rules.TestWatcher;
 import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import request.*;
import utils.DateUtils;
import utils.GenerateRandomNumber;
import utils.ScreenshotUtils;
import utils.SeleniumUtils;
import values.ChildTestInformationStep1Values;
import values.ChildTestInformationStep2Values;

 import java.net.URISyntaxException;
import java.nio.file.Paths;

public class AllStepsTest {

    private static WebDriver driver;
    private WebDriverWait wait;
    private String fileToUploadPath = Paths.get(getClass().getClassLoader().getResource("uploadFile.pdf").toURI()).toString();
    private ChildInformationPage1 childInformationPage1;
    private ChildDocumentsPage3 childDocumentsPage3;
    private ChildTestInformationStep2 childTestInformationStep2;
    private ParentInfoStep4Page parentInfoStep4Page;
    private ParentDocumentsStep5Page parentDocumentsStep5Page;

    public AllStepsTest() throws URISyntaxException { }

    public void initFromOtherTestClass(WebDriver driver) {
        AllStepsTest.driver = driver;
        wait = SeleniumUtils.getDriverWait();
        childInformationPage1 = PageFactory.initElements(driver, ChildInformationPage1.class);
        childDocumentsPage3 = PageFactory.initElements(driver, ChildDocumentsPage3.class);
        childTestInformationStep2 = PageFactory.initElements(driver, ChildTestInformationStep2.class);
        parentInfoStep4Page = PageFactory.initElements(driver, ParentInfoStep4Page.class);
        parentDocumentsStep5Page = PageFactory.initElements(driver, ParentDocumentsStep5Page.class);
    }

    @Before
    public void setUp() throws InterruptedException {
        driver = SeleniumUtils.getDriver();
        wait = SeleniumUtils.getDriverWait();
        SeleniumUtils.initializeAndAuthorize(driver);
        childInformationPage1 = PageFactory.initElements(driver, ChildInformationPage1.class);
        childDocumentsPage3 = PageFactory.initElements(driver, ChildDocumentsPage3.class);
        childTestInformationStep2 = PageFactory.initElements(driver, ChildTestInformationStep2.class);
        parentInfoStep4Page = PageFactory.initElements(driver, ParentInfoStep4Page.class);
        parentDocumentsStep5Page = PageFactory.initElements(driver, ParentDocumentsStep5Page.class);
    }

    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, org.junit.runner.Description description) {
            makeScreenshotOnFailure();
            ScreenshotUtils.saveScreenshotLocally(driver, description);
        }

        @Attachment("Screenshot on failure")
        public byte[] makeScreenshotOnFailure() {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }

        @Override
        protected void finished(org.junit.runner.Description description) {
            if (driver != null)
                driver.quit();
        }
    };

    //  1. Проверка логики заполнения полей для 1 класса, Гражданство РФ, регистрация Москва, не многодетная семья
    @Test
    @Description("Проверка логики заполнения полей для 1 класса, Гражданство РФ, регистрация Москва, не многодетная семья")
    public void checkChildDocumentsFirstClassRFMoscow() throws InterruptedException {
        childInformationPage1.stepOneFirstClass(
                driver,
                "Васильева",
                "Василиса",
                "Васильевна",
                "Женский",
                "РФ",
                childInformationPage1.calculateEducationalYear(),
                "1",
                "г. Москва",
                "ул Московкая, 54",
                "Нет",
                "ул Красноармейская, 57");
        childInformationPage1.getButtonGeneralInfo().click();
        wait.until(ExpectedConditions.visibilityOf(childDocumentsPage3.getTitleStep3()));
        assert childDocumentsPage3.getTitleStep3().getText().equals("Документы ребёнка");
        childDocumentsPage3.childDocuments(
                "68465166",
                "14022014",
                "Test");
        childDocumentsPage3.childDocumentsHomeBook();
        childDocumentsPage3.getButtonNextStep().click();
        wait.until(ExpectedConditions.visibilityOf(childDocumentsPage3.getTitleStep4()));
        assert childDocumentsPage3.getTitleStep4().getText().equals("О родителе / законном представителе");
        parentInfoStep4Page.parentInfoYesNoMultiChild(
                "Демидов",
                "Дмитрий",
                "Олегович",
                "14011980",
                "Мужской",
                "РФ",
                "testmail.distantisotm@mail.ru",
                "4657686",
                "Комсомольская, 11",
                "Нет",
                "Родитель");
        parentInfoStep4Page.getButtonStep4().click();
        wait.until(ExpectedConditions.visibilityOf(parentDocumentsStep5Page.getTitleParentDocStep5()));
        assert parentDocumentsStep5Page.getTitleParentDocStep5().getText().equals("Документы родителя/законного представителя");
        parentDocumentsStep5Page.parentDocuments(
                "135131",
                "УФМС России",
                "13012009",
                "sdfghj");
        parentDocumentsStep5Page.getParentPasswordFile1().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getParentPasswordFile2().sendKeys(fileToUploadPath);

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        ScreenshotUtils.saveScreenshot(scrShot.getScreenshotAs(OutputType.BYTES));

        parentDocumentsStep5Page.getButtonParentDocsNextStep().click();
    }

    //  2. Проверка логики заполнения полей для 1 класса, Гражданство Иностранное, регистрация Другое,
    // Многодетная семья
    @Test
    public void checkChildDocumentsFirstClass() throws InterruptedException {
        childInformationPage1.stepOneFirstClass(
                driver,
                "Васильева",
                "Василиса",
                "Васильевна",
                "Женский",
                "РФ",
                childInformationPage1.calculateEducationalYear(),
                "1",
                "Другое",
                "ул Московкая, 54",
                "Нет",
                "ул Красноармейская, 57");
        childInformationPage1.getButtonGeneralInfo().click();
        wait.until(ExpectedConditions.visibilityOf(childDocumentsPage3.getTitleStep3()));
        assert childDocumentsPage3.getTitleStep3().getText().equals("Документы ребёнка");
        childDocumentsPage3.childDocuments(
                "68465166",
                "14022014",
                "Test");
        childDocumentsPage3.getButtonNextStep().click();
        wait.until(ExpectedConditions.visibilityOf(childDocumentsPage3.getTitleStep4()));
        assert childDocumentsPage3.getTitleStep4().getText().equals("О родителе / законном представителе");
        parentInfoStep4Page.parentInfoYesNoMultiChild(
                "Test",
                "Qwer",
                "Ertrt",
                "15011980",
                "Мужской",
                "РФ",
                "testmail.distantisotm@mail.ru",
                "4657686",
                "eryyi",
                "Да",
                "Попечитель");
        parentDocumentsStep5Page.getMultiChildFile().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getRepresentativeCertFile().sendKeys(fileToUploadPath);
        parentInfoStep4Page.getButtonStep4().click();
        wait.until(ExpectedConditions.visibilityOf(parentDocumentsStep5Page.getTitleParentDocStep5()));
        assert parentDocumentsStep5Page.getTitleParentDocStep5().getText().equals("Документы родителя/законного представителя");
        parentDocumentsStep5Page.parentDocuments(
                "135131",
                "qwerty",
                "13012009",
                "sdfghj");
        parentDocumentsStep5Page.getParentPasswordFile1().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getParentPasswordFile2().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getButtonParentDocsNextStep().click();
    }

    private void stepOneSecondSeventhClassesPersonalDocument(
            String lastName, String firstName,
            String gender, String citizenship,
            String educationalYear, String classNumber,
            String document, String registration, String address,
            String actualAddressConsider)
            throws InterruptedException {
        childInformationPage1.getLastName().sendKeys(lastName);
        assert childInformationPage1.getLastName().getAttribute("value").equals(lastName);
        childInformationPage1.getFirstName().sendKeys(firstName);
        childInformationPage1.getSelectGender().click();
        childInformationPage1.selectDropdownElement(gender);
        childInformationPage1.getCitizenshipChild().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement(citizenship);
        childInformationPage1.getSelectYear().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement(educationalYear);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String educationalStartDate = js.executeScript("return document.getElementById('learning_start_date').value;").toString();
        assert childInformationPage1.getBirthdayDate().isEnabled();
        childInformationPage1.getBirthdayDate().sendKeys(DateUtils.calculateMinimumBirthDate(educationalStartDate));
        childInformationPage1.getWhichClass().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement(classNumber);
        childInformationPage1.getPersonalDocument().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement(document);
        childInformationPage1.getSelectRegistration().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement(registration);
        childInformationPage1.getAddressRegistration().sendKeys(address);
        childInformationPage1.getSelectActualAddress().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement(actualAddressConsider);
        childInformationPage1.getButtonGeneralInfo().click();
        assert childTestInformationStep2.getTextTitleStep2().getText().equals("План вступительного тестирования");
        childTestInformationStep2.getButtonSubjectListTab().click();
        Thread.sleep(500);
        assert childDocumentsPage3.getTitleStep3().getText().equals("Документы ребёнка");
    }

    //  3. Проверка логики заполнения полей для 2 - 7 классов. Условия: Гражданство РФ, С отметкой о переходе в текущий класс, рег В Москве
    @Test
    public void checkSecondClassesPersonalDocument() throws InterruptedException {
        stepOneSecondSeventhClassesPersonalDocument(
                "Васильева",
                "Василиса",
                "Женский",
                "РФ",
                childInformationPage1.calculateEducationalYear(),
                "2",
                "С отметкой о переводе в текущий класс",
                "г. Москва",
                "ул Московкая, 54",
                "Да");
        childDocumentsPage3.childDocuments(
                "68465166",
                "14022014",
                "Test");
        childDocumentsPage3.childDocumentsHomeBook();
        childDocumentsPage3.getAttachScoreBoardFileInput().sendKeys(fileToUploadPath);
        childDocumentsPage3.getButtonNextStep().click();
        Thread.sleep(500);
        assert childDocumentsPage3.getTitleStep4().getText().equals("О родителе / законном представителе");
        parentInfoStep4Page.parentInfoYesNoMultiChild(
                "Test",
                "Qwer",
                "Ertrt",
                "16021984",
                "Мужской",
                "РФ",
                "testmail.distantisotm@mail.ru",
                "4657686",
                "eryyi",
                "Нет",
                "Опекун");
        parentInfoStep4Page.getButtonStep4().click();
        Thread.sleep(500);
        assert parentDocumentsStep5Page.getTitleParentDocStep5().getText().equals("Документы родителя/законного представителя");
        parentDocumentsStep5Page.parentDocuments(
                "135131",
                "qwerty",
                "13012009",
                "sdfghj");
        parentDocumentsStep5Page.getParentPasswordFile1().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getParentPasswordFile2().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getButtonParentDocsNextStep().click();
    }

    private void stepOneSecondSeventhClassesWithoutPersonalDocument(
            String lastName, String firstName,
            String gender, String citizenship,
            String educationalYear,
            String classNumber, String secondLanguage, String selectIsSecondLanguageFirstYear,
            String registration, String address,
            String actualAddressConsider)
            throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElements(childInformationPage1.getLastName()));
        String generatedLastName = GenerateRandomNumber.generateRandomNumber();
        childInformationPage1.getLastName().sendKeys(generatedLastName);
        assert childInformationPage1.getLastName().getAttribute("value").equals(generatedLastName);
        childInformationPage1.getFirstName().sendKeys(firstName);
        childInformationPage1.getSelectGender().click();
        childInformationPage1.selectDropdownElement(gender);
        childInformationPage1.getCitizenshipChild().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((childInformationPage1.getDropdownMenu())));
        childInformationPage1.selectDropdownElement(citizenship);
        childInformationPage1.getSelectYear().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((childInformationPage1.getDropdownMenu())));
        childInformationPage1.selectDropdownElement(educationalYear);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String educationalStartDate = js.executeScript("return document.getElementById('learning_start_date').value;").toString();
        ChildTestInformationStep1Values.educationalStartDate = educationalStartDate;
        assert childInformationPage1.getBirthdayDate().isEnabled();
        childInformationPage1.getBirthdayDate().click();
        SeleniumUtils.typeInField(childInformationPage1.getBirthdayDate(), DateUtils.calculateMinimumBirthDate(educationalStartDate));
        childInformationPage1.getWhichClass().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((childInformationPage1.getDropdownMenu())));
        childInformationPage1.selectDropdownElement(classNumber);
        childInformationPage1.getSelectSecondLanguage().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((childInformationPage1.getDropdownMenu())));
        childInformationPage1.selectDropdownElement(secondLanguage);
        childInformationPage1.getSelectIsSecondLanguageFirstYear().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((childInformationPage1.getDropdownMenu())));
        childInformationPage1.selectDropdownElement(selectIsSecondLanguageFirstYear);
        childInformationPage1.getPersonalDocument().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((childInformationPage1.getDropdownMenu())));
        childInformationPage1.selectDropdownElement("Отсутствует личное дело или отметка о переводе в текущий класс");
        Thread.sleep(500);
        childInformationPage1.getButtonConfirmStadiedYes().click();
        childInformationPage1.getSelectRegistration().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((childInformationPage1.getDropdownMenu())));
        childInformationPage1.selectDropdownElement(registration);
        childInformationPage1.getAddressRegistration().sendKeys(address);
        childInformationPage1.getSelectActualAddress().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((childInformationPage1.getDropdownMenu())));
        childInformationPage1.selectDropdownElement(actualAddressConsider);
        childInformationPage1.getButtonGeneralInfo().click();
        childTestInformationStep2.saveDiagTestListValues("План диагностического тестирования");
        ChildTestInformationStep2Values.priceTest = childTestInformationStep2.getPrice().getText();

        childTestInformationStep2.getButtonSubjectListTab().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((childDocumentsPage3.getTitleStep3())));
        assert childDocumentsPage3.getTitleStep3().getText().equals("Документы ребёнка");
    }

    //  4. Проверка логики заполнения полей для 2 - 7 классов. Условия: Гражданство Иностранное,Отсутствует личное дело, рег Москва
    @Test
    public void checkSeventhClassesWithoutPersonalDocument() throws InterruptedException {
        stepOneSecondSeventhClassesWithoutPersonalDocument(
                "Васильева",
                "Екатерина",
                "Женский",
                "Иностранное",
                childInformationPage1.calculateEducationalYear(),
                "7",
                "Немецкий язык",
                "Нет",
                "Московская обл.",
                "ул Московкая, 55",
                "Да");
        Thread.sleep(500);
        childDocumentsPage3.childDocuments(
                "68465166",
                "14022014",
                "Test");
        Thread.sleep(500);
        childDocumentsPage3.getButtonNextStep().click();
        Thread.sleep(500);
        assert childDocumentsPage3.getTitleStep4().getText().equals("О родителе / законном представителе");
        parentInfoStep4Page.parentInfoYesNoMultiChild(
                "Test",
                "Qwer",
                "Ertrt",
                "16031979",
                "Мужской",
                "РФ",
                "testmail.distantisotm@mail.ru",
                "4657686",
                "eryyi",
                "Да",
                "Представитель органа опеки и попечительства");
        parentDocumentsStep5Page.getMultiChildFile().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getRepresentativeCertFile().sendKeys(fileToUploadPath);
        parentInfoStep4Page.getButtonStep4().click();
        Thread.sleep(500);
        assert parentDocumentsStep5Page.getTitleParentDocStep5().getText().equals("Документы родителя/законного представителя");
        parentDocumentsStep5Page.parentDocuments(
                "135131",
                "qwerty",
                "13012009",
                "sdfghj");
        parentDocumentsStep5Page.getParentPasswordFile1().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getParentPasswordFile2().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getButtonParentDocsNextStep().click();
    }

    private void stepOne89Classes(
            String lastName, String firstName,
            String gender, String citizenship,
            String educationalYear,
            String classNumber, String secondLanguage, String selectIsSecondLanguageFirstYear,
            String registration, String address,
            String actualAddressConsider, String writeActualAddress)
            throws InterruptedException {
        String generatedLastName = GenerateRandomNumber.generateRandomNumber();
        childInformationPage1.getLastName().sendKeys(generatedLastName);
        assert childInformationPage1.getLastName().getAttribute("value").equals(generatedLastName);
        childInformationPage1.getFirstName().sendKeys(firstName);
        childInformationPage1.getSelectGender().click();
        childInformationPage1.selectDropdownElement(gender);
        childInformationPage1.getCitizenshipChild().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((childInformationPage1.getDropdownMenu())));
        childInformationPage1.selectDropdownElement(citizenship);
        childInformationPage1.getSelectYear().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((childInformationPage1.getDropdownMenu())));
        childInformationPage1.selectDropdownElement(educationalYear);
        assert childInformationPage1.getBirthdayDate().isEnabled();
        ChildTestInformationStep1Values.setBirthDateYears(15);
        SeleniumUtils.typeInField(childInformationPage1.getBirthdayDate(), ChildTestInformationStep1Values.getChildBirthDateString());
        childInformationPage1.getWhichClass().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((childInformationPage1.getDropdownMenu())));
        childInformationPage1.selectDropdownElement(classNumber);
        childInformationPage1.getSelectSecondLanguage().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((childInformationPage1.getDropdownMenu())));
        childInformationPage1.selectDropdownElement(secondLanguage);
        childInformationPage1.getSelectIsSecondLanguageFirstYear().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((childInformationPage1.getDropdownMenu())));
        childInformationPage1.selectDropdownElement(selectIsSecondLanguageFirstYear);
        childInformationPage1.getPersonalDocument().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((childInformationPage1.getDropdownMenu())));
        childInformationPage1.selectDropdownElement("Отсутствует личное дело или отметка о переводе в текущий класс");
        Thread.sleep(500);
        childInformationPage1.getButtonConfirmStadiedYes().click();
        childInformationPage1.getSelectRegistration().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement(registration);
        childInformationPage1.getAddressRegistration().sendKeys(address);
        childInformationPage1.getSelectActualAddress().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((childInformationPage1.getDropdownMenu())));
        childInformationPage1.selectDropdownElement(actualAddressConsider);
        childInformationPage1.getWriteActualAddress().sendKeys(writeActualAddress);
        childInformationPage1.getButtonGeneralInfo().click();

        childTestInformationStep2.saveDiagTestListValues("План диагностического тестирования");
        ChildTestInformationStep2Values.priceTest = childTestInformationStep2.getPrice().getText();

        childTestInformationStep2.getButtonSubjectListTab().click();
        Thread.sleep(500);
        assert childDocumentsPage3.getTitleStep3().getText().equals("Документы ребёнка");
    }

// 5. Проверка паспотрных данных

    @Test
    public void check8ClassPassword() throws InterruptedException {
        stepOne89Classes("Васильева",
                "Василиса",
                "Женский",
                "РФ",
                childInformationPage1.calculateEducationalYear(),
                "8",
                "Немецкий язык",
                "Да",
                "г. Москва",
                "ул Московкая, 54",
                "Нет",
                "Berlin, 75");
        childDocumentsPage3.childDocuments(
                "68465166",
                "14022014",
                "Test");
        childDocumentsPage3.childPassword("26516516",
                "Qwerty",
                "12012006");
        childDocumentsPage3.childDocumentsHomeBook();
//        childDocumentsPage3.getAttachScoreBoardFileInput().sendKeys(fileToUploadPath);
        childDocumentsPage3.getButtonNextStep().click();
        wait.until(ExpectedConditions.visibilityOfAllElements(childDocumentsPage3.getTitleStep4()));
        assert childDocumentsPage3.getTitleStep4().getText().equals("О родителе / законном представителе");
        parentInfoStep4Page.parentInfoYesNoMultiChild(
                "Test",
                "Qwer",
                "Ertrt",
                "19051987",
                "Мужской",
                "РФ",
                "testmail.distantisotm@mail.ru",
                "4657686",
                "eryyi",
                "Да",
                "Родитель");
        parentDocumentsStep5Page.getMultiChildFile().sendKeys(fileToUploadPath);
        parentInfoStep4Page.getButtonStep4().click();
        Thread.sleep(500);
        assert parentDocumentsStep5Page.getTitleParentDocStep5().getText().equals("Документы родителя/законного представителя");
        parentDocumentsStep5Page.parentDocuments(
                "135131",
                "qwerty",
                "13012009",
                "sdfghj");
        parentDocumentsStep5Page.getParentPasswordFile1().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getParentPasswordFile2().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getButtonParentDocsNextStep().click();
    }

    //6.  9 класс, проверка СНИЛС
    @Test
    public void check9ClassSNILS() throws InterruptedException {
        stepOne89Classes("Васильев",
                "Дмитрий",
                "Мужской",
                "Иностранное",
                childInformationPage1.calculateEducationalYear(),
                "9",
                "Немецкий язык",
                "Да",
                "Другое",
                "ул Московкая, 54",
                "Нет",
                "Berlin, 75");
        Thread.sleep(1000);
        childDocumentsPage3.childDocuments(
                "68465166",
                "14022014",
                "Test");
        Thread.sleep(500);
        childDocumentsPage3.childForeignPassword(
                "26516516",
                "Qwerty",
                "12012006");
        Thread.sleep(900);
        childDocumentsPage3.snilsChild(
                "143-546-543 45",
                "15012020",
                fileToUploadPath);
        childDocumentsPage3.getButtonNextStep().click();
        wait.until(ExpectedConditions.visibilityOf(childDocumentsPage3.getTitleStep4()));
        assert childDocumentsPage3.getTitleStep4().getText().equals("О родителе / законном представителе");
        parentInfoStep4Page.parentInfoYesNoMultiChild(
                "Test",
                "Qwer",
                "Ertrt",
                "25051985",
                "Мужской",
                "РФ",
                "qwe@qer.qw",
                "4657686",
                "eryyi",
                "Да",
                "Попечитель");
        parentDocumentsStep5Page.getMultiChildFile().sendKeys(fileToUploadPath);
        parentInfoStep4Page.getButtonStep4().click();
        wait.until(ExpectedConditions.visibilityOf(parentDocumentsStep5Page.getTitleParentDocStep5()));
        assert parentDocumentsStep5Page.getTitleParentDocStep5().getText().equals("Документы родителя/законного представителя");
        parentDocumentsStep5Page.parentDocuments(
                "135131",
                "qwerty",
                "13012009",
                "sdfghj");
        parentDocumentsStep5Page.getParentPasswordFile1().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getParentPasswordFile2().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getRepresentativeCertFile().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getButtonParentDocsNextStep().click();
    }

    //7. 11 класс, проверка Аттестата
    @Test
    @DisplayName("Check 11 class")
    @Description("11 class, RF, Actual Address Consider, has Personal Document, Multichaild, more than 5, Attestat, SNILS, Password")
    public void check11Class() throws InterruptedException {
        childInformationPage1.toFillInfo10_11Class(
                "Иванов",
                "Максим",
                "Мужской",
                "РФ",
                childInformationPage1.calculateEducationalYear(),
                "11",
                "г. Москва",
                "ул Московкая, 54",
                "Да");
        assert childTestInformationStep2.getTextTitleStep2().getText().equals("План вступительного тестирования");
        ChildTestInformationStep2Values.setDiagTestList(childTestInformationStep2.getDiagTestsList());
        childTestInformationStep2.getButtonSubjectListTab().click();
        wait.until(ExpectedConditions.visibilityOf(childDocumentsPage3.getTitleStep3()));
        assert childDocumentsPage3.getTitleStep3().getText().equals("Документы ребёнка");
        wait.until(ExpectedConditions.visibilityOf(childDocumentsPage3.getBirthCertNum()));
        childDocumentsPage3.childDocuments(
                "68465166",
                "14022014",
                "Test");
        wait.until(ExpectedConditions.visibilityOf(childDocumentsPage3.getInputStudentPassportNum()));
        childDocumentsPage3.childPassword("26516516",
                "Qwerty",
                "12012006");
        wait.until(ExpectedConditions.visibilityOf(childDocumentsPage3.getHomeBookDate()));
        childDocumentsPage3.childDocumentsHomeBook();
        wait.until(ExpectedConditions.visibilityOf(childDocumentsPage3.getSnilsNum()));
        childDocumentsPage3.snilsChild(
                "143-546-543 45",
                "15012020",
                fileToUploadPath);
        childDocumentsPage3.getGeneralEduCertFile().sendKeys(fileToUploadPath);
        childDocumentsPage3.getAttachScoreBoardFileInput().sendKeys(fileToUploadPath);
        childDocumentsPage3.getButtonNextStep().click();
        wait.until(ExpectedConditions.visibilityOf(childDocumentsPage3.getTitleStep4()));
        assert childDocumentsPage3.getTitleStep4().getText().equals("О родителе / законном представителе");
        parentInfoStep4Page.parentInfoMultiChildMoreFive(
                "Test",
                "Qwer",
                "",
                "17071977",
                "Женский",
                "РФ",
                "parents.distantisotm@gmail.com",
                "4657686",
                "eryyi",
                "Да",
                "Да",
                "Опекун");
        parentDocumentsStep5Page.getMultiChildFile().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getRepresentativeCertFile().sendKeys(fileToUploadPath);
        parentInfoStep4Page.getButtonStep4().click();
        wait.until(ExpectedConditions.visibilityOf(parentDocumentsStep5Page.getTitleParentDocStep5()));
        assert parentDocumentsStep5Page.getTitleParentDocStep5().getText().equals("Документы родителя/законного представителя");
        parentDocumentsStep5Page.parentDocuments(
                "135131",
                "qwerty",
                "13012009",
                "sdfghj");
        parentDocumentsStep5Page.getParentPasswordFile1().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getParentPasswordFile2().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getButtonParentDocsNextStep().click();
    }

    @Test
    @DisplayName("Check 10 class")
    @Description("")
    public void fullSteps10Class () throws InterruptedException {
        childInformationPage1.check10ClassStep1(
                "Марина",
                "Сергеевна",
                "Женский",
                "Иностранное",
                childInformationPage1.calculateEducationalYear(),
                "10",
                "Французский язык",
                "Нет",
                "г. Москва",
                "ул Московкая, 54",
                "Нет",
                "ул Московкая, 55");

        childTestInformationStep2.saveDiagTestListValues("План вступительного тестирования");
        childTestInformationStep2.getButtonSubjectListTab().click();

        wait.until(ExpectedConditions.visibilityOf(childDocumentsPage3.getTitleStep3()));
        assert childDocumentsPage3.getTitleStep3().getText().equals("Документы ребёнка");
        wait.until(ExpectedConditions.visibilityOf(childDocumentsPage3.getBirthCertNum()));
        childDocumentsPage3.childDocuments(
                "68465166",
                "14022014",
                "Test");
        wait.until(ExpectedConditions.visibilityOf(childDocumentsPage3.getInputStudentPassportNum()));
        childDocumentsPage3.childForeignPassword("26516516",
                "Qwerty",
                "12012006");
        wait.until(ExpectedConditions.visibilityOf(childDocumentsPage3.getHomeBookDate()));
        childDocumentsPage3.childDocumentsHomeBook();
        wait.until(ExpectedConditions.visibilityOf(childDocumentsPage3.getSnilsNum()));
        childDocumentsPage3.snilsChild(
                "143-546-543 45",
                "15012020",
                fileToUploadPath);
        childDocumentsPage3.getGeneralEduCertFile().sendKeys(fileToUploadPath);
        childDocumentsPage3.getAttachScoreBoardFileInput().sendKeys(fileToUploadPath);
        childDocumentsPage3.getButtonNextStep().click();
        wait.until(ExpectedConditions.visibilityOf(childDocumentsPage3.getTitleStep4()));
        assert childDocumentsPage3.getTitleStep4().getText().equals("О родителе / законном представителе");
        parentInfoStep4Page.parentInfoNoMultiChildForeignerSecondStudent("Test",
                "Qwer",
                "Ertrt",
                "17071977",
                "Женский",
                "Иностранное",
                "qwe@qer.qw",
                "4657686",
                "eryyi",
                "Нет",
                "Родитель",
                "Да",
                "Test",
                "4");
        parentInfoStep4Page.getButtonStep4().click();
        wait.until(ExpectedConditions.visibilityOf(parentDocumentsStep5Page.getTitleParentDocStep5()));
        assert parentDocumentsStep5Page.getTitleParentDocStep5().getText().equals("Документы родителя/законного представителя");
        parentDocumentsStep5Page.parentDocuments(
                "135131",
                "qwerty",
                "13012009",
                "sdfghj");
        parentDocumentsStep5Page.getParentPasswordFile1().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getParentPasswordFile2().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getParentPassportTranslationFile().sendKeys(fileToUploadPath);
        parentDocumentsStep5Page.getButtonParentDocsNextStep().click();
    }

}

