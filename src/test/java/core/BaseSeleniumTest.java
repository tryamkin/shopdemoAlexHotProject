package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.itfriendly.core.BaseSeleniumPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
    private static final Boolean ENV_CHROME = true;
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        if (OS_NAME_FOR_GIT.equals("Linux")) {
            if (ENV_CHROME) {
                driver = new ChromeDriver(new ChromeOptions().addArguments(
                        "--headless", "--window-size=1920,1080"));
            } else {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driver = new FirefoxDriver(options);
            }
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGELOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLISITY_WAIT));
        BaseSeleniumPage.setDriver(driver);

    }


    @AfterClass
    public void tearDown() {
        if (ENV_CHROME){
        driver.close();
        driver.quit();}
        else {
            driver.close();
        }
    }
}
