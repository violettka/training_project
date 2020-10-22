package ru.isotm.distant;

import org.junit.Before;
import org.junit.Test;
import ru.isotm.distant.driver.ChromeWebDriver;

import static com.codeborne.selenide.Selenide.open;
import static ru.isotm.distant.pages.BasePage.basicURL;

/**
 * StepsBaseTest
 * Base class for test steps implementation.
 *
 */
public class BaseTest {


    @Before
    public void buildDriver() {
       ChromeWebDriver.setChromeDriver();
        initPageObjects();
    }

    @Test
    public void sendOnlineRequest(){
        open(basicURL + "/request-online");

    }

    private void initPageObjects() {

    }
}
