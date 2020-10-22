import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import school.StudentsPage;
import utils.ScreenshotUtils;
import utils.SeleniumUtils;

import java.net.URISyntaxException;

public class StudentsEnrollExpel {

    private WebDriver driver;
    private WebDriverWait wait;
    private StudentsPage studentsPage;

    @Before
    public void setUp() throws InterruptedException, URISyntaxException {
        driver = SeleniumUtils.getDriver();
        wait = SeleniumUtils.getDriverWait();
        SeleniumUtils.initializeAndAuthorize(driver);
        studentsPage = PageFactory.initElements(driver, StudentsPage.class);
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
//            if (ru.isotm.distant.driver != null)
//                ru.isotm.distant.driver.quit();
        }
    };

    @Test
    @Description()
    public void checkDeductEnrollStudent() throws InterruptedException {
        driver.get("https://193.187.173.70:1395/#/students");
        studentsPage.deductEnrollStudent();
    }

    @Test
    @Description()
    public void checkEnrollNewStudent() throws InterruptedException {
        driver.get("https://193.187.173.70:1395/#/students");
        studentsPage.enrollNewStudent();
    }

}
