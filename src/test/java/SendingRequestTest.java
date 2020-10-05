import documents.*;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import request.SubmitPage6;
import school.request.*;
import utils.*;
import utils.enums.TestingType;
import values.ChildTestInformationStep1Values;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URISyntaxException;

public class SendingRequestTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private AllStepsTest allStepsTest;
    private SubmitPage6 submitPage6;
    private RequestsPage requestsPage;
    private TestingPage testingPage;
    private ContractsPage contractsPage;
    private StudentsPage studentsPage;
    private InvoicesPage invoicesPage;
    private JsonReader jsonReader;

    public SendingRequestTest() throws URISyntaxException { }

    @Before
    public void setUp() throws InterruptedException, URISyntaxException {
        driver = SeleniumUtils.getDriver();
        wait = SeleniumUtils.getDriverWait();
        SeleniumUtils.initializeAndAuthorize(driver);
        allStepsTest = new AllStepsTest();
        allStepsTest.initFromOtherTestClass(driver);
        submitPage6 = PageFactory.initElements(driver, SubmitPage6.class);
        requestsPage = PageFactory.initElements(driver, RequestsPage.class);
        testingPage = PageFactory.initElements(driver, TestingPage.class);
        contractsPage = PageFactory.initElements(driver, ContractsPage.class);
        studentsPage = PageFactory.initElements(driver, StudentsPage.class);
        invoicesPage = PageFactory.initElements(driver, InvoicesPage.class);
        jsonReader = PageFactory.initElements(driver, JsonReader.class);
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
//            if (driver != null)
//                driver.quit();
        }
    };


    @Test
    @Description("Проверка логики заполнения полей для 1 класса," +
            "с параметрами: Гражданство РФ, регистрация Москва, не многодетная семья" +
            "Отправка заявки, проверка Темы и Тела письма, проверка появления заявки в Базе, создание договора")
    public void sendRequest1Class() throws InterruptedException, IOException, MessagingException {
        allStepsTest.checkChildDocumentsFirstClassRFMoscow();
        submitPage6.sendRequest(driver, "тест");
        driver.get("https://193.187.173.70:1395/#/online_requests");        
        try {
            wait.until(ExpectedConditions.visibilityOf(requestsPage.getSearch()));
        }
        catch(StaleElementReferenceException ex) { // issue with staleness of element. retry implemented
            wait.until(ExpectedConditions.visibilityOf(requestsPage.getSearch()));
        }
        requestsPage.getSearch().sendKeys(GenerateRandomNumber.getRandomNumber());
        Thread.sleep(1000);
        requestsPage.getClickSearch().click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.textToBePresentInElement(requestsPage.getOpenRequest(), GenerateRandomNumber.getRandomNumber()));
        requestsPage.getOpenRequest().click();
        String studentClass = "1";
        requestsPage.checkRequestPage("Василиса",
                "Васильевна",
                "Женский",
                DateUtils.calculateMinimumBirthDateWithDots(ChildTestInformationStep1Values.educationalStartDate),
                "РФ",
                studentClass,
                "Нет",
                "",
                "",
                "г.Москва",
                "ул Московкая, 54",
                "ул Красноармейская, 57",
                "68465166",
                "14.02.2014",
                "Test",
                "",
                "",
                "",
                "",
                "",
                "Демидов",
                "Дмитрий",
                "Олегович",
                "Мужской",
                "РФ",
                "Нет",
                "",
                "",
                "4657686",
                "testmail.distantisotm@mail.ru",
                "Комсомольская, 11",
                "135131",
                "УФМС России",
                "13.01.2009",
                "sdfghj",
                "Родитель",
                "14.01.1980");
        testingPage.compareDiagTestListFromRequest(studentClass);
        assert requestsPage.getRequestStatusText().getText().equals("Новая");

        requestsPage.checkDocsStatuses(SendRequest1ClassDocs.values());
        testingPage.createContract();
        driver.get("https://193.187.173.70:1395/#/contracts");
        contractsPage.checkNewContractExist();
        driver.get("https://193.187.173.70:1395/#/invoices");
        invoicesPage.checkNewContractExist();
        driver.get("https://193.187.173.70:1395/#/students");
        studentsPage.checkNewContractExist();
        studentsPage.enrollAndDeductNewStudent();


        TestMail.check("Василиса Васильевна, 1 класс", null, null, null, null);

    }

    @Test
    @Description("Проверка логики заполнения полей для 7 класса. " +
            "Параметры: Гражданство Иностранное,Отсутствует личное дело, г Москва" +
            "Проверка почты, сравнение списков предметов из Заявки с Базой и в письмом, редактирование класса")
    public void sendRequest7ClassWithoutPersonalDocument() throws InterruptedException, IOException, MessagingException {
         allStepsTest.checkSeventhClassesWithoutPersonalDocument();
        submitPage6.sendRequest(driver, "тест");
        driver.get("https://193.187.173.70:1395/#/online_requests");        
        try {
            wait.until(ExpectedConditions.visibilityOf(requestsPage.getSearch()));
        }
        catch(StaleElementReferenceException ex) { // issue with staleness of element. retry implemented
            wait.until(ExpectedConditions.visibilityOf(requestsPage.getSearch()));
        }
        requestsPage.getSearch().sendKeys(GenerateRandomNumber.getRandomNumber());
        requestsPage.getClickSearch().click();
        wait.until(ExpectedConditions.textToBePresentInElement(requestsPage.getOpenRequest(), GenerateRandomNumber.getRandomNumber()));
        requestsPage.getOpenRequest().click();
        String studentClass = "7";
        requestsPage.checkRequestPage("Екатерина",
                "",
                "Женский",
                DateUtils.calculateMinimumBirthDateWithDots(ChildTestInformationStep1Values.educationalStartDate),
                "Иностранное",
                studentClass,
                "Нет",
                "Немецкий",
                "Нет",
                "Московская обл.",
                "ул Московкая, 55",
                "Совпадает с регистрацией",
                "68465166",
                "14.02.2014",
                "Test",
                "",
                "",
                "",
                "",
                "",
                "Test",
                "Qwer",
                "Ertrt",
                "Мужской",
                "РФ",
                "Опекунство",
                "",
                "",
                "4657686",
                "testmail.distantisotm@mail.ru",
                "eryyi",
                "135131",
                "qwerty",
                "13.01.2009",
                "sdfghj",
                "Представитель органа опеки и попечительства",
                "16.03.1979");
        testingPage.compareDiagTestListFromRequest(studentClass);
        assert requestsPage.getRequestStatusText().getText().equals("Новая");

        requestsPage.checkDocsStatuses(SendRequest7ClassWithoutPersonalDocumentDocs.values());
        testingPage.editClass();
        testingPage.addCommentAndCheckStatusOfResultTesting();
        assert SeleniumUtils.getNumbersFromString(testingPage.getPriceText().getText())
                .equals(jsonReader.getJsonElement("https://193.187.173.70:1395/school/64", "//body/pre", "testing_price_9_11"));
        TestMail.check("Екатерина, 7 класс",
                TestingType.DIAG_TESTING,
                "Справка",
                "Вопросы по работе с личным кабинетом учащегося",
                null);
    }

    @Test
    @DisplayName("Check 11 class")
    @Description("11 class, RF, Actual Address Consider, has Personal Document, Multichaild, more than 5," +
            "Attestat, SNILS, Passport, проверка смены статуса при сдачи теста")
    public void sendRequest11Class() throws InterruptedException, IOException, MessagingException {
        allStepsTest.check11Class();
        submitPage6.sendRequest(driver, "тест");
        driver.get("https://193.187.173.70:1395/#/online_requests");        
        try {
            wait.until(ExpectedConditions.visibilityOf(requestsPage.getSearch()));
        }
        catch(StaleElementReferenceException ex) { // issue with staleness of element. retry implemented
            wait.until(ExpectedConditions.visibilityOf(requestsPage.getSearch()));
        }
        requestsPage.getSearch().sendKeys(GenerateRandomNumber.getRandomNumber());
        Thread.sleep(1000);
        requestsPage.getClickSearch().click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.textToBePresentInElement(requestsPage.getOpenRequest(), GenerateRandomNumber.getRandomNumber()));
        requestsPage.getOpenRequest().click();
        String studentClass = "11";
        requestsPage.checkRequestPage("Максим",
                "Иванов",
                "Мужской",
                ChildTestInformationStep1Values.getChildBirthDateStringRequestPage(),
                "РФ",
                studentClass,
                "Да",
                "",
                "",
                "г.Москва",
                "ул Московкая, 54",
                "Совпадает с регистрацией",
                "68465166",
                "14.02.2014",
                "Test",
                "26516516",
                "Qwerty",
                "12.01.2006",
                "143-546-543 45",
                "15.01.2020",
                "Test",
                "Qwer",
                "",
                "Женский",
                "РФ",
                "Опекунство",
                "",
                "",
                "4657686",
                "parents.distantisotm@gmail.com",
                "eryyi",
                "135131",
                "qwerty",
                "13.01.2009",
                "sdfghj",
                "Опекун",
                "17.07.1977");
        testingPage.compareDiagTestListFromRequest(studentClass);
        assert requestsPage.getRequestStatusText().getText().equals("Новая");
        testingPage.addCommentAndCheckStatusOfResultTesting();
        testingPage.editStatusOfTestResult(3);

        requestsPage.checkDocsStatuses(Сheck11ClassDocs.values());

        testingPage.createContract();
        driver.get("https://193.187.173.70:1395/#/contracts");
        contractsPage.checkNewContractExist();
        driver.get("https://193.187.173.70:1395/#/students");
        studentsPage.checkNewContractExist();
        driver.get("https://193.187.173.70:1395/#/invoices");
        invoicesPage.checkNewContractExist();
        TestMail.check("Максим Иванов, 11 класс",
                TestingType.ENTRANCE_TESTING,
                "Справка",
                "Вопросы по работе с личным кабинетом учащегося",
                "https://onlinetestpad.com");
    }

    @Test
    @DisplayName("Check 9 class")
    @Description("9 class, Foreign, Actual Address NOT Consider, without Personal Document," +
            "No Multichaild, SNILS, редактирование школы")

    public void sendRequest9Class() throws InterruptedException, IOException, MessagingException {

        allStepsTest.check9ClassSNILS();
        submitPage6.sendRequest(driver, "тест 9 класс");
        driver.get("https://193.187.173.70:1395/#/online_requests");
        try {
            wait.until(ExpectedConditions.visibilityOf(requestsPage.getSearch()));
        }
        catch(StaleElementReferenceException ex) { // issue with staleness of element. retry implemented
            wait.until(ExpectedConditions.visibilityOf(requestsPage.getSearch()));
        }
        requestsPage.getSearch().sendKeys(GenerateRandomNumber.getRandomNumber());
        requestsPage.getClickSearch().click();
        wait.until(ExpectedConditions.textToBePresentInElement(requestsPage.getOpenRequest(), GenerateRandomNumber.getRandomNumber()));
        requestsPage.getOpenRequest().click();
        String studentClass = "9";
        requestsPage.checkRequestPage("Дмитрий",
                "",
                "Мужской",
                ChildTestInformationStep1Values.getChildBirthDateStringRequestPage(),
                "Иностранное",
                studentClass,
                "Нет",
                "Немецкий",
                "Да",
                "Другое",
                "ул Московкая, 54",
                "Berlin, 75",
                "68465166",
                "14.02.2014",
                "Test",
                "26516516",
                "Qwerty",
                "12.01.2006",
                "143-546-543 45",
                "15.01.2020",
                "Test",
                "Qwer",
                "Ertrt",
                "Мужской",
                "РФ",
                "Опекунство",
                "",
                "",
                "4657686",
                "qwe@qer.qw",
                "eryyi",
                "135131",
                "qwerty",
                "13.01.2009",
                "sdfghj",
                "Попечитель",
                "25.05.1985");
        testingPage.compareDiagTestListFromRequest(studentClass);
        assert requestsPage.getRequestStatusText().getText().equals("Новая");

        requestsPage.checkDocsStatuses(SendRequest9ClassDocs.values());
        testingPage.editSchool();
        testingPage.addCommentAndCheckStatusOfResultTesting();
        assert SeleniumUtils.getNumbersFromString(testingPage.getPriceText().getText())
                .equals(jsonReader.getJsonElement("https://193.187.173.70:1395/school/21", "//body/pre", "testing_price_7_8"));
        TestMail.check("Дмитрий, 9 класс",
                TestingType.DIAG_TESTING,
                "Справка",
                "Вопросы по работе с личным кабинетом учащегося",
                null);
    }

    @Test
    @DisplayName("Check 10 class")
    @Description("10 class, Foreign, Actual Address Consider," +
            "No Multichaild, SNILS,иностранный пасспорт с переводом, второй ребенок учится в школе")

    public void sendRequest10Class() throws InterruptedException, IOException, MessagingException {
        allStepsTest.fullSteps10Class();
        submitPage6.sendRequest(driver, "тест 10 класс");
        driver.get("https://193.187.173.70:1395/#/online_requests");
        try {
            wait.until(ExpectedConditions.visibilityOf(requestsPage.getSearch()));
        }
        catch(StaleElementReferenceException ex) { // issue with staleness of element. retry implemented
            wait.until(ExpectedConditions.visibilityOf(requestsPage.getSearch()));
        }
        requestsPage.getSearch().sendKeys(GenerateRandomNumber.getRandomNumber());
        Thread.sleep(200);
        requestsPage.getClickSearch().click();
        wait.until(ExpectedConditions.textToBePresentInElement(requestsPage.getOpenRequest(), GenerateRandomNumber.getRandomNumber()));
        requestsPage.getOpenRequest().click();
        String studentClass = "10";
        requestsPage.checkRequestPage("Марина",
                "Сергеевна",
                "Женский",
                ChildTestInformationStep1Values.getChildBirthDateStringRequestPage(),
                "Иностранное",
                studentClass,
                "Да",
                "Французский",
                "Нет",
                "г.Москва",
                "ул Московкая, 54",
                "ул Московкая, 55",
                "68465166",
                "14.02.2014",
                "Test",
                "26516516",
                "Qwerty",
                "12.01.2006",
                "143-546-543 45",
                "15.01.2020",
                "Test",
                "Qwer",
                "Ertrt",
                "Женский",
                "Иностранное",
                "Второй ребенок из одной семьи",
                "Test",
                "4",
                "4657686",
                "qwe@qer.qw",
                "eryyi",
                "135131",
                "qwerty",
                "13.01.2009",
                "sdfghj",
                "Родитель",
                "17.07.1977");
        testingPage.compareDiagTestListFromRequest(studentClass);
        assert requestsPage.getRequestStatusText().getText().equals("Новая");
        testingPage.addCommentAndCheckStatusOfResultTesting();

        testingPage.editStatusOfTestResult(2);
        requestsPage.checkDocsStatuses(SendRequest10ClassDocs.values());
        testingPage.createContract();
        driver.get("https://193.187.173.70:1395/#/contracts");
        contractsPage.checkNewContractExist();
        driver.get("https://193.187.173.70:1395/#/students");
        studentsPage.checkNewContractExist();
        driver.get("https://193.187.173.70:1395/#/invoices");
        invoicesPage.checkNewContractExist();

        TestMail.check("Марина Сергеевна, 10 класс",
                TestingType.ENTRANCE_TESTING,
                "Справка",
                "Вопросы по работе с личным кабинетом учащегося",
                "https://onlinetestpad.com");

    }

}