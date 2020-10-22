package request;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumUtils;

import java.util.List;

public class ParentInfoStep4Page {

    @FindBy (xpath = "//input[@id='parent_surename']")
    private WebElement parentSurename;
    @FindBy (xpath = "//input[@id='parent_name']")
    private WebElement parentName;
    @FindBy (xpath = "//input[@id='parent_middle_name']")
    private WebElement parentMiddleName;
    @FindBy (xpath = "//input[@id='parent_birth_date']")
    private WebElement parentBirthDate;
    @FindBy (xpath = "//input[@id='parent_gender']//../following-sibling::div//i")
    private WebElement parentGender;
    @FindBy (xpath = "//input[@id='parent_citezenship']//../following-sibling::div//i")
    private WebElement parentCitezenship;
    @FindBy (xpath = "//input[@id='parent_email']")
    private WebElement parentEmail;
    @FindBy (xpath = "//input[@id='parent_phone']")
    private WebElement parentPhone;
    @FindBy (xpath = "//textarea[@id='post_address']")
    private WebElement parentPostAddress;
    @FindBy (xpath = "//input[@id='multi_child']//../following-sibling::div//i")
    private WebElement multiChild;
    @FindBy (xpath = "//input[@id='multi_child_gte_five']//../following-sibling::div//i")
    private WebElement multiChildGteFive;

    @FindBy (xpath = "//input[@id='representative_status_id']//../following-sibling::div//i")
    private WebElement representativeStatus;

    @FindBy (xpath = "//div[@id='parent_info_tab']//button[@class='next_step_btn v-btn v-btn--contained theme--light v-size--default isotm']//i")
    private WebElement battonStep4;

    @FindBy (xpath = "//input[@id='is_second_student_in_school']//../following-sibling::div//i")
    private WebElement isSecondStudentInSchool;
    @FindBy (xpath = "//input[@id='second_student_fio']")
    private WebElement secondStudentFIO;
    @FindBy (xpath = "//input[@id='second_student_class_id']//../following-sibling::div//i")
    private WebElement secondStudentClassButton;


    @FindBy(xpath = "//div[@class='v-menu__content theme--light menuable__content__active']//div[@class='v-list-item__content']")
    private List<WebElement> dropdownMenu;

    public WebElement getParentSurname() {
        return parentSurename;
    }

    public WebElement getParentName() {
        return parentName;
    }

    public WebElement getParentMiddleName() {
        return parentMiddleName;
    }

    public WebElement getParentGender() {
        return parentGender;
    }

    public WebElement getParentCitezenship() {
        return parentCitezenship;
    }

    public WebElement getParentEmail() {
        return parentEmail;
    }

    public WebElement getParentPhone() {
        return parentPhone;
    }

    public WebElement getParentPostAddress() {
        return parentPostAddress;
    }

    public WebElement getMultiChild() {
        return multiChild;
    }

    public WebElement getMultiChildGteFive() {
        return multiChildGteFive;
    }

    public WebElement getParentBirthDate() {
        return parentBirthDate;
    }

    public WebElement getRepresentativeStatus() {
        return representativeStatus;
    }

    public WebElement getIsSecondStudentInSchool() {
        return isSecondStudentInSchool;
    }

    public WebElement getSecondStudentFIO() {
        return secondStudentFIO;
    }

    public WebElement getSecondStudentClassButton() {
        return secondStudentClassButton;
    }

    public List<WebElement> getDropdownMenu() {
        return dropdownMenu;
    }
    public WebElement getButtonStep4() {
        return battonStep4;
    }

    public void selectDropdownElement(String element) {
        for (WebElement webElement : dropdownMenu) {
            if (webElement.getText().equals(element)) {
                webElement.click();
            }
        }
    }

    public void parentInfoYesNoMultiChild(String parentSurname, String parentName, String parentMiddleNameName, String parentBirthDate,
                                          String parentGender, String parentCitezenship, String parentEmail,
                                          String parentPhone, String parentPostAddress, String multiChild,
                                          String representativeStatus) throws InterruptedException {
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        getParentSurname().sendKeys(parentSurname);
        getParentName().sendKeys(parentName);
        getParentMiddleName().sendKeys(parentMiddleNameName);
        SeleniumUtils.typeInField(getParentBirthDate(),parentBirthDate);
        getParentGender().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(parentGender);
        getParentCitezenship().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(parentCitezenship);
        getParentEmail().sendKeys(parentEmail);
        SeleniumUtils.typeInField(getParentPhone(),parentPhone);
        getParentPostAddress().sendKeys(parentPostAddress);
        getMultiChild().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(multiChild);
        getRepresentativeStatus().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(representativeStatus);

    } public void parentInfoMultiChildMoreFive(String parentSurname, String parentName, String parentMiddleNameName, String parentBirthDate,
                                       String parentGender, String parentCitezenship, String parentEmail,
                                       String parentPhone, String parentPostAddress, String multiChild,
                                               String multiChildMoreFive, String representativeStatus) throws InterruptedException {
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        getParentSurname().sendKeys(parentSurname);
        getParentName().sendKeys(parentName);
        getParentMiddleName().sendKeys(parentMiddleNameName);
        SeleniumUtils.typeInField(getParentBirthDate(),parentBirthDate);
        getParentGender().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(parentGender);
        getParentCitezenship().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(parentCitezenship);
        getParentEmail().sendKeys(parentEmail);
        SeleniumUtils.typeInField(getParentPhone(),parentPhone);
        getParentPostAddress().sendKeys(parentPostAddress);
        getMultiChild().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(multiChild);
        getMultiChildGteFive().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(multiChildMoreFive);
        getRepresentativeStatus().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(representativeStatus);
    }

    public void parentInfoNoMultiChildForeignerSecondStudent(
            String parentSurname, String parentName, String parentMiddleNameName, String parentBirthDate,
            String parentGender, String parentCitezenship, String parentEmail,
            String parentPhone, String parentPostAddress, String multiChild,
            String representativeStatus, String isSecondStudentInSchool,
            String secondStudentFIO, String secondStudentClassNumber) throws InterruptedException {
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        getParentSurname().sendKeys(parentSurname);
        getParentName().sendKeys(parentName);
        getParentMiddleName().sendKeys(parentMiddleNameName);
        SeleniumUtils.typeInField(getParentBirthDate(), parentBirthDate);
        getParentGender().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(parentGender);
        getParentCitezenship().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(parentCitezenship);
        getParentEmail().sendKeys(parentEmail);
        SeleniumUtils.typeInField(getParentPhone(), parentPhone);
        getParentPostAddress().sendKeys(parentPostAddress);
        getMultiChild().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(multiChild);
        getRepresentativeStatus().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(representativeStatus);
        getIsSecondStudentInSchool().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(isSecondStudentInSchool);
        getSecondStudentFIO().sendKeys(secondStudentFIO);
        getSecondStudentClassButton().click();
        wait.until(ExpectedConditions.visibilityOfAllElements((dropdownMenu)));
        selectDropdownElement(secondStudentClassNumber);

    }
}
