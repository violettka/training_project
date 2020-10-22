import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import request.ChildTestInformationStep2;
import utils.DateUtils;

import java.time.LocalDate;
import java.time.Period;

public class ChildInformationPage1Test {

    private WebDriver driver;
    private WebDriverWait wait;

    private request.EnrolleeInfoFirstPage childInformationPage1;
    private ChildTestInformationStep2 childTestInformationStep2;

    private String errorRequiredMessage = "Поле обязательно к заполнению";
    private String errorBirthdayErrorMessage = "Прием в школу от 6 лет 4 месяцев";

//    @Before
//    public void setUp() throws InterruptedException {
//        driver = SeleniumUtils.getDriver();
//        wait = SeleniumUtils.getDriverWait();
//        SeleniumUtils.initializeAndAuthorize(driver);
//        childInformationPage1 = PageFactory.initElements(driver, EnrolleeInfoFirstPage.class);
//        childTestInformationStep2 = PageFactory.initElements(driver, ChildTestInformationStep2.class);
//    }

//    @Rule
//    public TestWatcher screenshotOnFailure = new TestWatcher() {
//        @Override
//        protected void failed(Throwable e, org.junit.runner.Description description) {
//            makeScreenshotOnFailure();
//            ScreenshotUtils.saveScreenshotLocally(driver, description);
//        }
//
//        @Attachment("Screenshot on failure")
//        public byte[] makeScreenshotOnFailure() {
//            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//        }
//
//        @Override
//        protected void finished(org.junit.runner.Description description) {
//            if (driver != null)
//                driver.quit();
//        }
//    };

    //  1. Проверка на полное заполнение полей всех полей формы на  текущий год
    @Test
    public void firstStepCheckDataChild() throws InterruptedException {
        LocalDate childBirthDate = LocalDate.now().minus(Period.ofYears(7));
        String childBirthDateString = DateUtils.getStringRepresentation(childBirthDate, "ddMMyyyy");
        firstStepDataChild(
                "Васильева",
                "Василиса",
                childBirthDateString,
                "Женский",
                "РФ",
                childInformationPage1.calculateEducationalYear(),
                "6",
                "Немецкий язык",
                "С отметкой о переводе в текущий класс",
                "г. Москва",
                "ул Московкая, 54",
                "Нет");
        childInformationPage1.getFatherName().sendKeys("Васильевна");
        childInformationPage1.getWriteActualAddress().sendKeys("Московская 53");
        childInformationPage1.getButtonGeneralInfo().click();
        //TODO: change below line into call of class method with XPath in class
        wait.until(ExpectedConditions.visibilityOfAllElements(childTestInformationStep2.getTextTitleStep2()));
        assert childTestInformationStep2.getTextTitleStep2().getText().equals("План вступительного тестирования");
    }

    private void firstStepDataChild(String lastName, String firstName,
                                    String birthdayDate, String gender, String citizenship,
                                    String educationalYear, String classNumber, String secondLanguage,
                                    String document, String registration, String address,
                                    String actualAddressConsider)
            throws InterruptedException {
        childInformationPage1.getLastName().sendKeys(lastName);
        assert childInformationPage1.getLastName().getAttribute("value").equals(lastName);
        childInformationPage1.getFirstName().sendKeys(firstName);
        childInformationPage1.getSelectGender().click();
        childInformationPage1.selectDropdownElement(gender);
        childInformationPage1.getBirthdayDate().sendKeys(birthdayDate);
        childInformationPage1.getCitizenshipChild().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement(citizenship);
        assert childInformationPage1.getYearToGoToSchool().isDisplayed();
        childInformationPage1.getSelectYear().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement(educationalYear);
//        childInformationPage1.getStartDate().sendKeys(DateUtils.getStringRepresentation(LocalDate.now(), "ddMMyyyy"));
        childInformationPage1.getWhichClass().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement(classNumber);
        childInformationPage1.getSelectSecondLanguage().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement(secondLanguage);
        childInformationPage1.getPersonalDocument().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement(document);
        // assert !childInformationPage1.getButtonConfirmStadiedYes().isEnabled();
       // assert !childInformationPage1.getButtonConfirmStadiedNo().isDisplayed();
        childInformationPage1.getSelectRegistration().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement(registration);
        childInformationPage1.getAddressRegistration().sendKeys(address);
        childInformationPage1.getSelectActualAddress().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement(actualAddressConsider);
    }

    //    2. Проверка на заполнение ОБЯЗАТЕЛЬНЫХ полей (Кроме Отчества и Адреса фактического проживания)
//    и нажатие кнопки "Далее" в следующем году
    @Test
    public void checkButtonGeneralInfoSecondStep() throws InterruptedException {
        LocalDate childBirthDate = LocalDate.now().minus(Period.ofYears(7));
        String childBirthDateString = DateUtils.getStringRepresentation(childBirthDate, "ddMMyyyy");

        firstStepDataChild(
                "Дмитрий",
                "Демидов",
                childBirthDateString,
                "Мужской",
                "Иностранное",
                childInformationPage1.calculateEducationalYear(),
                "7",
                "Французский язык",
                "С отметкой о переводе в текущий класс",
                "г. Москва",
                "ул Московкая, 54",
                "Да");
        childInformationPage1.getButtonGeneralInfo().click();
        try {
            childInformationPage1.getWriteActualAddress().isDisplayed();
            assert false;
        } catch (Exception exception) {
            assert exception instanceof NoSuchElementException;
        }
        assert childTestInformationStep2.getTextTitleStep2().getText().equals("План вступительного тестирования");
    }


    //  3. Проверка автоматического проставления Даты Начала обучения при выборе Следующего нового Учебного года.
//  Тест-кейс будет работать только c 1 января по 31 март
    @Test
    public void firstStepCheckAutoDateNextYear() throws InterruptedException {
        LocalDate today = LocalDate.now();
        if (today.isAfter(today.withMonth(3).withDayOfMonth(31))) {
            return; //Should be executed from 1.01 till 31.03
        }
        assert childInformationPage1.getYearToGoToSchool().isDisplayed();
        childInformationPage1.getSelectYear().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement(childInformationPage1.calculateEducationalYear());
        assert childInformationPage1.getYearToGoToSchoolText().getText().equals(childInformationPage1.calculateEducationalYear());
        assert childInformationPage1.getStartDate().isDisplayed();
        assert !childInformationPage1.getStartDate().isEnabled();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String educationalStartDate = js.executeScript("return document.getElementById('learning_start_date').value;").toString();
        assert childInformationPage1.calculateStartOfEducationalYear().equals(educationalStartDate);

        childInformationPage1.getBirthdayDate().sendKeys(DateUtils.calculateMinimumBirthDate(educationalStartDate));
    }

    //  4. Проверка на появление ошибки при введении некорректной даты рождения
    @Test
    public void firstStepCheckNotCorrectBirthdayDate() throws InterruptedException {
        childInformationPage1.getSelectYear().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement(childInformationPage1.calculateEducationalYear());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String educationalStartDate = js.executeScript("return document.getElementById('learning_start_date').value;").toString();
        assert childInformationPage1.getBirthdayDate().isEnabled();
        childInformationPage1.getBirthdayDate().sendKeys(childInformationPage1.calculateErrorBirthDate(educationalStartDate));
        childInformationPage1.getFatherName().click();
        childInformationPage1.checkErrorMessageExistSize(1, errorBirthdayErrorMessage);
    }

    //  5. Проверка на появление ошибки при введении некорректной даты рождения в следующем году
    @Test
    public void firstStepCheckNotCorrectBirthdayDateInNextYear() throws InterruptedException {
        LocalDate today = LocalDate.now();
        if (today.isAfter(today.withMonth(3).withDayOfMonth(31))) {
            return; //Should be executed from 1.01 till 31.03
        }
        childInformationPage1.getSelectYear().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement(childInformationPage1.calculateEducationalYear());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String educationalStartDate = js.executeScript("return document.getElementById('learning_start_date').value;").toString();
        assert childInformationPage1.getBirthdayDate().isEnabled();
        childInformationPage1.getBirthdayDate().sendKeys(childInformationPage1.calculateErrorBirthDate(educationalStartDate));
        childInformationPage1.checkErrorMessageExistSize(1, errorBirthdayErrorMessage);

    }

    //    6. Проверка информирования. Всплывающее окно
    private void firstStepPopUp() throws InterruptedException {
        Thread.sleep(500);
        childInformationPage1.getWhichClass().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement("8");
        assert childInformationPage1.getPersonalDocument().isDisplayed();
        childInformationPage1.getPersonalDocument().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement("Отсутствует личное дело или отметка о переводе в текущий класс");
        wait.until(ExpectedConditions.visibilityOf(childInformationPage1.getButtonConfirmStadiedYes()));
        assert childInformationPage1.getButtonConfirmStadiedYes().isDisplayed();
        assert childInformationPage1.getButtonConfirmStadiedNo().isDisplayed();
    }

    @Test
    public void firstStepCheckPopUpYes() throws InterruptedException {
        firstStepPopUp();
        childInformationPage1.getButtonConfirmStadiedYes().click();
        assert childInformationPage1.getPersonalDocumentText().getText().equals("Отсутствует личное дело или отметка о переводе в текущий класс");
    }

    @Test
    public void firstStepCheckPopUpNo() throws InterruptedException {
        firstStepPopUp();
        childInformationPage1.getButtonConfirmStadiedNo().click();
        assert childInformationPage1.getPersonalDocumentText().getText().equals("С отметкой о переводе в текущий класс");
    }

    //    7. Проверка, что поступлении в 1 класс поле Личное дело не отображается
    @Test
    public void firstStepPersonalDocumentNotDisplayed() throws InterruptedException {
        childInformationPage1.getWhichClass().click();
        Thread.sleep(500);
        childInformationPage1.selectDropdownElement("1");
        try {
            childInformationPage1.getPersonalDocumentText().isDisplayed();
            assert false;
        } catch (Exception exception) {
            assert exception instanceof NoSuchElementException;
        }
    }


    // 8. Проверка сообщения об ошибке, если фактический адрес не заполнен
    @Test
    public void checkErrorMessageActualAddressEmpty() throws InterruptedException {
        // Beginning of Initialization of all fields except of Actual Address
        LocalDate childBirthDate = LocalDate.now().minus(Period.ofYears(7));
        String childBirthDateString = DateUtils.getStringRepresentation(childBirthDate, "ddMMyyyy");
        firstStepDataChild(
                "Васильева",
                "Василиса",
                childBirthDateString,
                "Женский",
                "РФ",
                childInformationPage1.calculateEducationalYear(),
                "6",
                "Немецкий язык",
                "С отметкой о переводе в текущий класс",
                "г. Москва",
                "ул Московкая, 54",
                "Нет");
        // End of Initialization of all fields except of Actual Address

        childInformationPage1.getButtonGeneralInfo().click();
        childInformationPage1.checkErrorMessageExistSize(1, errorRequiredMessage);
    }

    @Test
    public void checkErrorRequiredMessages() {
        childInformationPage1.getButtonGeneralInfo().click();
        childInformationPage1.checkErrorMessageExistSize(9, errorRequiredMessage);
    }
}
