package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.itfriendly.core.BaseSeleniumPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import static org.itfriendly.constants.Constatnt.TimeoutVariables.IMPLISITY_WAIT;
import static org.itfriendly.constants.Constatnt.TimeoutVariables.PAGELOAD_WAIT;

/**
 * это базовый класс, который настраивает и запускает всё.
 */

abstract public class BaseSeleniumTest {
   public static final String OS_NAME_FOR_GIT = System.getProperty("os.name");


    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        if (OS_NAME_FOR_GIT.equals("Linux")){
            ChromeOptions options = new ChromeOptions().addArguments("--headless");
            driver = new ChromeDriver(options);
            driver = new FirefoxDriver();

        }
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().driverVersion("122").setup();
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
