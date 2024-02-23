package core;

import org.itfriendly.core.BaseSeleniumPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import static org.itfriendly.constants.Constatnt.TimeoutVariables.IMPLISITY_WAIT;
import static org.itfriendly.constants.Constatnt.TimeoutVariables.PAGELOAD_WAIT;

/**
 * это базовый класс, который настраивает и запускает всё.
 */

abstract public class BaseSeleniumTest {
   // public static final String OS_NAME_FOR_GIT = System.getProperty("os.name");
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {

      //  WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //    options.addArguments("--headless");
        options.addArguments("--no-sandbox",
                "--disable-gpu", "--disable-dev-shm-usage",
                "--window-size=1920,1080", "--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGELOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLISITY_WAIT));
        driver.manage().window().maximize();
        BaseSeleniumPage.setDriver(driver);

    }


    @AfterClass
    public void tearDown() {

        driver.close();
        driver.quit();
    }
}
