package request;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumUtils;

public class ParentDocumentsStep5Page {

    @FindBy(xpath = "//div[@id=\"parent_docs_tab\"]//h1")
    private WebElement titleParentDocStep5;
    @FindBy(xpath = "//input[@id='parent_passport_num']")
    private WebElement parentPassportNum;
    @FindBy(xpath = "//input[@id='parent_passport_issuer']")
    private WebElement parentPassportIssuer;
    @FindBy(xpath = "//input[@id='parent_passport_date']")
    private WebElement parentPassportDate;
    @FindBy(xpath = "//textarea[@id='parent_perm_reg']")
    private WebElement parentPermReg;
    @FindBy(xpath = "//div[@id='parent_passport_file_1']//input[@type='file']")
    private WebElement parentPasswordFile1;
    @FindBy(xpath = "//div[@id='parent_passport_file_2']//input[@type='file']")
    private WebElement parentPasswordFile2;
    @FindBy(xpath = "//div[@id='multi_child_file']//input[@type='file']")
    private WebElement multiChildFile;
    @FindBy(xpath = "//div[@id='representative_cert_file']//input[@type='file']")
    private WebElement representativeCertFile;
    @FindBy(xpath = "//div[@id='parent_passport_translation_file']//input[@type='file']")
    private WebElement parentPassportTranslationFile;
    @FindBy(xpath = "//div[@id='parent_docs_tab']//button[@class='next_step_btn v-btn v-btn--contained theme--light v-size--default isotm']//i")
    private WebElement ButtonParentDocsNextStep;



    public WebElement getTitleParentDocStep5() {
        return titleParentDocStep5;
    }

    public WebElement getParentPassportNum() {
        return parentPassportNum;
    }

    public WebElement getParentPassportIssuer() {
        return parentPassportIssuer;
    }

    public WebElement getParentPassportDate() {
        return parentPassportDate;
    }

    public WebElement getParentPermReg() {
        return parentPermReg;
    }

    public WebElement getParentPasswordFile1() {
        return parentPasswordFile1;
    }

    public WebElement getParentPasswordFile2() {
        return parentPasswordFile2;
    }

    public WebElement getButtonParentDocsNextStep() {
        return ButtonParentDocsNextStep;
    }

    public WebElement getRepresentativeCertFile() {
        return representativeCertFile;
    }

    public WebElement getParentPassportTranslationFile() {
        return parentPassportTranslationFile;
    }

    public WebElement getMultiChildFile() {
        return multiChildFile;
    }

    public void parentDocuments (String parentPassportNum, String parentPassportIssuer, String parentPassportDate,
                                 String parentPermReg) throws InterruptedException {
        WebDriverWait wait = SeleniumUtils.getDriverWait();
        wait.until(ExpectedConditions.visibilityOfAllElements((getParentPassportNum())));
        getParentPassportNum().click();
       // getParentPassportNum().sendKeys(parentPassportNum);
        SeleniumUtils.typeInField(getParentPassportNum(),parentPassportNum);
        getParentPassportIssuer().sendKeys(parentPassportIssuer);
        getParentPassportDate().click();
        // getParentPassportDate().sendKeys(parentPassportDate);
        SeleniumUtils.typeInField(getParentPassportDate(),parentPassportDate);
        getParentPermReg().sendKeys(parentPermReg);

    }
}
