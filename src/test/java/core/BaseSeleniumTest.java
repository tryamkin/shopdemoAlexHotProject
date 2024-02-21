package core;

import org.itfriendly.core.BaseSeleniumPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import static org.itfriendly.common.Config.*;
import static org.itfriendly.constants.Constatnt.TimeoutVariables.IMPLISITY_WAIT;
import static org.itfriendly.constants.Constatnt.TimeoutVariables.PAGELOAD_WAIT;

/**
 * это базовый класс, который настраивает и запускает всё.
 */

abstract public class BaseSeleniumTest {
    protected WebDriver driver;


    @BeforeClass
    public void setUp() {

        /**
         * Тут мы проверяем - если операционка линукс - то применяем настройки для гита. Основная это ключ (--headless)
         * которая запускает тесты на виртуальном мониторе
         */
//        if (OS_NAME_FOR_GIT.equals("Linux")) {
//            driver = gitRunConfig(driver, BROWSER_NAME);
//        } else {
//            driver = chooseDriver(driver, BROWSER_NAME);
//        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGELOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLISITY_WAIT));
        BaseSeleniumPage.setDriver(driver);

    }



    @AfterClass
    public void tearDown() {
        switch (BROWSER_NAME) {
            case "CHROME" -> {
                driver.close();
                driver.quit();
            }
            case "FIREFOX" -> driver.quit();
        }
    }
}
