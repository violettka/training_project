package school.request;

import documents.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DateUtils;
import utils.GenerateRandomNumber;
import utils.SeleniumUtils;
import values.ChildTestInformationStep2Values;

import java.time.LocalDate;
import java.util.List;

public class RequestsPage {

    @FindBy(xpath = "//input[@id='isotm---OnlineRequestListView--BasicSearch-I']")
    private WebElement search;
    @FindBy(xpath = "//div[@id='isotm---OnlineRequestListView--BasicSearch-search']")
    private WebElement clickSearch;
    @FindBy(xpath = "//td[contains(@id, 'isotm---OnlineRequestListView--RequestsTable-rows-row0-col4')]//span[@data-sap-ui]")
    private WebElement openRequest;

    // информация о ребенке
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentSurenameText']")
    private WebElement studentSurenameText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentNameText']")
    private WebElement studentNameText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentMiddleNameText']")
    private WebElement studentMiddleText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentGenderText']")
    private WebElement studentGenderText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentBirthDateText']")
    private WebElement studentBirthDateText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentCitizenshipText']")
    private WebElement studentCitizenshipText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentPassportNumText']")
    private WebElement studentPassportNumText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentPassportIssuerText']")
    private WebElement studentPassportIssuerText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentPassportDateText']")
    private WebElement studentPassportDateText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentRegTypeText']")
    private WebElement studentRegTypeText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentPermRegText']")
    private WebElement studentPermRegText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentFactRegText']")
    private WebElement studentFactRegText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentHomeBookDateText']")
    private WebElement studentHomeBookDateText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--BirthCertNumText']")
    private WebElement birthCertNumText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--BirthCertDateText']")
    private WebElement birthCertDateText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentClassText']")
    private WebElement studentClassText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentLearningYearText']")
    private WebElement studentLearningYearText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentLearningStartDateText']")
    private WebElement studentLearningStartDateText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentStudiedText']")
    private WebElement studentStudiedText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentInternetLessonsText']")
    private WebElement studentInternetLessonsText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentSecondLangText']")
    private WebElement studentSecondLangText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentSecondLangFirstYear']")
    private WebElement firstYearEduSecondLangText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentSnilsNumText']")
    private WebElement studentSnilsNumText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--StudentSnilsDateText']")
    private WebElement studentSnilsDateNumText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--BirthCertIssuerText']")
    private WebElement birthCertIssuerText;

    //инфо о родителе
    @FindBy(xpath = "//span[@id='__filter1-icon']")
    private WebElement parentIcon;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--ParentSurenameText']")
    private WebElement parentSurenameText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--ParentNameText']")
    private WebElement parentNameText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--ParentMiddleNameText']")
    private WebElement parentMiddleNameText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--ParentGenderText']")
    private WebElement parentGenderText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--ParentCitezenshipText']")
    private WebElement parentCitezenshipText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--DiscountTypeText']")
    private WebElement discountTypeText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--SecondStudentFioText']")
    private WebElement secondStudentFioText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--SecondStudentClassText']")
    private WebElement secondStudentClassText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--ParentPassportNumText']")
    private WebElement parentPassportNumText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--ParentPassportIssuerText']")
    private WebElement parentPassportIssuerText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--ParentPassportDateText']")
    private WebElement parentPassportDateText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--ParentPassportRegText']")
    private WebElement parentPassportRegText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--PhoneText']")
    private WebElement parentPhoneText;
    @FindBy(xpath = "//a[@id='isotm---OnlineRequestDetailsView--EmailText']")
    private WebElement parentEmailText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--PostAddressText']")
    private WebElement parentPostAddressText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--RepresentativeStatusText']")
    private WebElement representativeStatusText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--ParentBirthDateText']")
    private WebElement parentBirthDateText;

    //документы
    @FindBy(xpath = "//span[@id='__filter2-icon']")
    private WebElement documentsIcon;

    //тестирование
    @FindBy(xpath = "//span[@id='__filter3-icon']")
    private WebElement testIcon;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--PaidText']")
    private WebElement paidText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--PaidDateText']")
    private WebElement paidDateText;
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--ResultText']")
    private WebElement resultText;

    //статус Заявки
    @FindBy(xpath = "//span[@id='isotm---OnlineRequestDetailsView--RequestStatusText-text']")
    private WebElement requestStatusText;

    //Документы
    @FindBy(xpath = "//td/span[contains (@class, 'sapMText') and contains (@class, 'sapUiSelectable ') and contains (@class, 'sapMTextMaxWidth')]")
    private List<WebElement> docsTitleList;
    @FindBy(xpath = "//td[@class='sapMListTblCell']/div[@class='sapMFlexBox sapMVBox sapMFlexBoxJustifyStart sapMFlexBoxAlignItemsStretch sapMFlexBoxWrapNoWrap sapMFlexBoxAlignContentStretch sapMFlexBoxBGTransparent']")
    private List<WebElement> docsStatusList;


    public WebElement getSearch() {
        return search;
    }

    public WebElement getClickSearch() {
        return clickSearch;
    }

    public WebElement getOpenRequest() {
        return openRequest;
    }


    public WebElement getStudentSurenameText() {
        return studentSurenameText;
    }

    public WebElement getStudentNameText() {
        return studentNameText;
    }

    public WebElement getStudentGenderText() {
        return studentGenderText;
    }

    public WebElement getStudentCitizenshipText() {
        return studentCitizenshipText;
    }

    public WebElement getStudentBirthDateText() {
        return studentBirthDateText;
    }

    public WebElement getStudentPassportNumText() {
        return studentPassportNumText;
    }

    public WebElement getStudentPassportIssuerText() {
        return studentPassportIssuerText;
    }

    public WebElement getStudentPassportDateText() {
        return studentPassportDateText;
    }

    public WebElement getStudentRegTypeText() {
        return studentRegTypeText;
    }

    public WebElement getStudentPermRegText() {
        return studentPermRegText;
    }

    public WebElement getStudentFactRegText() {
        return studentFactRegText;
    }

    public WebElement getStudentHomeBookDateText() {
        return studentHomeBookDateText;
    }

    public WebElement getBirthCertNumText() {
        return birthCertNumText;
    }

    public WebElement getBirthCertDateText() {
        return birthCertDateText;
    }

    public WebElement getStudentClassText() {
        return studentClassText;
    }

    public WebElement getStudentLearningYearText() {
        return studentLearningYearText;
    }

    public WebElement getStudentLearningStartDateText() {
        return studentLearningStartDateText;
    }

    public WebElement getStudentStudiedText() {
        return studentStudiedText;
    }

    public WebElement getStudentInternetLessonsText() {
        return studentInternetLessonsText;
    }

    public WebElement getStudentSecondLangText() {
        return studentSecondLangText;
    }

    public WebElement getFirstYearEduSecondLangText() {
        return firstYearEduSecondLangText;
    }

    public WebElement getStudentSnilsNumText() {
        return studentSnilsNumText;
    }

    public WebElement getStudentSnilsDateNumText() {
        return studentSnilsDateNumText;
    }

    public WebElement getStudentMiddleText() {
        return studentMiddleText;
    }

    public WebElement getParentIcon() {
        return parentIcon;
    }

    public WebElement getParentSurenameText() {
        return parentSurenameText;
    }

    public WebElement getParentNameText() {
        return parentNameText;
    }

    public WebElement getParentMiddleNameText() {
        return parentMiddleNameText;
    }

    public WebElement getParentGenderText() {
        return parentGenderText;
    }

    public WebElement getParentCitezenshipText() {
        return parentCitezenshipText;
    }

    public WebElement getDiscountTypeText() {
        return discountTypeText;
    }

    public WebElement getSecondStudentFioText() {
        return secondStudentFioText;
    }

    public WebElement getSecondStudentClassText() {
        return secondStudentClassText;
    }

    public WebElement getParentPassportNumText() {
        return parentPassportNumText;
    }

    public WebElement getParentPassportIssuerText() {
        return parentPassportIssuerText;
    }

    public WebElement getParentPassportDateText() {
        return parentPassportDateText;
    }

    public WebElement getParentPassportRegText() {
        return parentPassportRegText;
    }

    public WebElement getParentPhoneText() {
        return parentPhoneText;
    }

    public WebElement getParentEmailText() {
        return parentEmailText;
    }

    public WebElement getParentPostAddressText() {
        return parentPostAddressText;
    }

    public WebElement getDocumentsIcon() {
        return documentsIcon;
    }

    public WebElement getTestIcon() {
        return testIcon;
    }

    public WebElement getPaidText() {
        return paidText;
    }

    public WebElement getPaidDateText() {
        return paidDateText;
    }

    public WebElement getResultText() {
        return resultText;
    }

    public WebElement getRequestStatusText() {
        return requestStatusText;
    }

    public WebElement getRepresentativeStatusText() {
        return representativeStatusText;
    }

    public WebElement getBirthCertIssuerText() {
        return birthCertIssuerText;
    }

    public WebElement getParentBirthDateText() {
        return parentBirthDateText;
    }

    public List<WebElement> getDocsTitleList() {
        return docsTitleList;
    }

    public List<WebElement> getDocsStatusList() {
        return docsStatusList;
    }

    public String calculateHomeBookDate() { //Выписка из домовой книги не позднее 1 месяца
        LocalDate today = LocalDate.now();
        return DateUtils.getStringRepresentation(today.minusDays(28), "dd.MM.yyyy");
    }


    public void checkRequestPage(String studentNameText, String studentMiddleText, String studentGenderText, String studentBirthDateText,
                                 String studentCitizenshipText, String studentClassText, String studentStudiedText,
                                 String studentSecondLangText, String firstYearEduSecondLangText, String studentRegTypeText,
                                 String studentPermRegText, String studentFactRegText, String birthCertNumText, String birthCertDateText,
                                 String birthCertIssuerText, String studentPassportNumText, String studentPassportIssuerText, String studentPassportDateText,
                                 String studentSnilsNumText, String studentSnilsDateNumText, String parentSurenameText,
                                 String parentNameText, String parentMiddleNameText, String parentGenderText,
                                 String parentCitezenshipText, String discountTypeText, String secondStudentFioText,
                                 String secondStudentClassText, String parentPhoneText,
                                 String parentEmailText, String parentPostAddressText, String parentPassportNumText,
                                 String parentPassportIssuerText, String parentPassportDateText, String parentPassportRegText,
                                 String representativeStatusText, String parentBirthDateText) {
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        //общая информация
        assert wait.until(ExpectedConditions.textToBePresentInElement(getStudentNameText(), studentNameText));
        assert wait.until(ExpectedConditions.textToBePresentInElement(getStudentSurenameText(), GenerateRandomNumber.getRandomNumber()));
        assert getStudentMiddleText().getText().equals(studentMiddleText);
        assert getStudentGenderText().getText().equals(studentGenderText);
        assert getStudentBirthDateText().getText().contains(studentBirthDateText);
        assert getStudentCitizenshipText().getText().equals(studentCitizenshipText);
        //об обучении
        assert getStudentClassText().getText().equals(studentClassText);
        assert getStudentStudiedText().getText().equals(studentStudiedText);
        if (!studentClassText.equals("1") && !studentClassText.equals("11")) {
            assert getStudentSecondLangText().getText().equals(studentSecondLangText);
        }
        if (!studentClassText.equals("1") && !studentClassText.equals("11")) {
            assert getFirstYearEduSecondLangText().getText().equals(firstYearEduSecondLangText);
        }
        //регистрационные данные
        assert getStudentRegTypeText().getText().equals(studentRegTypeText);
        assert getStudentPermRegText().getText().equals(studentPermRegText);
        assert getStudentFactRegText().getText().equals(studentFactRegText);
        if (getStudentRegTypeText().equals("г.Москва")) {
            assert getStudentHomeBookDateText().getText().equals(calculateHomeBookDate());
        }
        //свидетельство о рождении
        assert getBirthCertNumText().getText().equals(birthCertNumText);
        assert getBirthCertDateText().getText().equals(birthCertDateText);
        assert getBirthCertIssuerText().getText().equals(birthCertIssuerText);
        //пасспорт
        assert getStudentPassportNumText().getText().equals(studentPassportNumText);
        assert getStudentPassportIssuerText().getText().equals(studentPassportIssuerText);
        assert getStudentPassportDateText().getText().equals(studentPassportDateText);
        //СНИЛС
        assert getStudentSnilsNumText().getText().equals(studentSnilsNumText);
        assert getStudentSnilsDateNumText().getText().equals(studentSnilsDateNumText);

        getParentIcon().click();
        assert wait.until(ExpectedConditions.textToBePresentInElement(getParentSurenameText(), parentSurenameText));
        assert getParentNameText().getText().equals(parentNameText);
        assert getParentMiddleNameText().getText().equals(parentMiddleNameText);
        assert getParentGenderText().getText().equals(parentGenderText);
        assert getParentCitezenshipText().getText().equals(parentCitezenshipText);
        assert getDiscountTypeText().getText().equals(discountTypeText);
        if (discountTypeText.equals("Второй ребенок из одной семьи")){
            assert getSecondStudentFioText().getText().equals(secondStudentFioText);
            assert getSecondStudentClassText().getText().equals(secondStudentClassText);
        }
        assert getParentPhoneText().getText().equals(parentPhoneText);
        assert getParentEmailText().getText().equals(parentEmailText);
        assert getParentPostAddressText().getText().equals(parentPostAddressText);
        assert getParentPassportNumText().getText().equals(parentPassportNumText);
        assert getParentPassportIssuerText().getText().equals(parentPassportIssuerText);
        assert getParentPassportDateText().getText().equals(parentPassportDateText);
        assert getParentPassportRegText().getText().equals(parentPassportRegText);
        assert getRepresentativeStatusText().getText().equals(representativeStatusText);
        assert getParentBirthDateText().getText().equals(parentBirthDateText);

        getTestIcon().click();
    }

    public void checkDocsStatuses(Enum[] docsStatuses) {
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        documentsIcon.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(docsTitleList));
        assert docsTitleList.size() == docsStatusList.size();
        for (int i = 0; i < docsTitleList.size(); i++) {
            System.out.println("Проверка статуса " + docsTitleList.get(i).getText());
            boolean foundStatus = false;
            for (Enum docStatus : docsStatuses) {
                SendRequest1ClassDocs class1Docs = null;
                SendRequest7ClassWithoutPersonalDocumentDocs class7Docs = null;
                SendRequest9ClassDocs class9Docs = null;
                Сheck11ClassDocs class11Docs = null;
                SendRequest10ClassDocs class10Docs = null;

                if(docStatus instanceof SendRequest1ClassDocs) class1Docs = (SendRequest1ClassDocs) docStatus;
                if(docStatus instanceof SendRequest7ClassWithoutPersonalDocumentDocs) class7Docs = (SendRequest7ClassWithoutPersonalDocumentDocs) docStatus;
                if(docStatus instanceof SendRequest9ClassDocs) class9Docs = (SendRequest9ClassDocs) docStatus;
                if(docStatus instanceof Сheck11ClassDocs) class11Docs = (Сheck11ClassDocs) docStatus;
                if(docStatus instanceof SendRequest10ClassDocs) class10Docs = (SendRequest10ClassDocs) docStatus;

                if (class1Docs != null && class1Docs.getName().equals(docsTitleList.get(i).getText())) {
                    foundStatus = class1Docs.getStatus().equals(docsStatusList.get(i).getText());
                }
                else if (class7Docs != null && class7Docs.getName().equals(docsTitleList.get(i).getText())) {
                    foundStatus = class7Docs.getStatus().equals(docsStatusList.get(i).getText());
                }
                else if (class9Docs != null && class9Docs.getName().equals(docsTitleList.get(i).getText())) {
                    foundStatus = class9Docs.getStatus().equals(docsStatusList.get(i).getText());
                }
                else if (class11Docs != null && class11Docs.getName().equals(docsTitleList.get(i).getText())) {
                    foundStatus = class11Docs.getStatus().equals(docsStatusList.get(i).getText());
                }
                else if (class10Docs !=null && class10Docs.getName().equals(docsTitleList.get(i).getText())) {
                    foundStatus = class10Docs.getStatus().equals(docsStatusList.get(i).getText());
                }
            }

            if (!foundStatus) {
                System.out.println(
                        "Статус для документа " +
                                docsTitleList.get(i).getText() +
                                " со статусом " +
                                docsStatusList.get(i).getText() +
                                " не соответствует требованиям.");
                assert false;
            }
        }
    }
}
