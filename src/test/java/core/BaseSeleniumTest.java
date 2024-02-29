package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.itfriendly.core.BaseSeleniumPage;
import org.openqa.selenium.Capabilities;
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
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {


        if (OS_NAME_FOR_GIT.equals("Linux")) {
            if (ENV_CRHOME()) {
                driver = new ChromeDriver(new ChromeOptions().addArguments(
                        "--headless", "--window-size=1920,1080"));
                System.out.println("RUN ON CHROME");
                Capabilities capabilities = ((ChromeDriver) driver).getCapabilities();
                System.out.println("Browser Name - " + capabilities.getBrowserName());
                System.out.println("Browser version - " + capabilities.getBrowserVersion());
            } else {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driver = new FirefoxDriver(options);
                System.out.println("RUN ON FIREFOX");
                Capabilities capabilities = ((FirefoxDriver) driver).getCapabilities();
                System.out.println("Browser Name - " + capabilities.getBrowserName());
                System.out.println("Browser version - " + capabilities.getBrowserVersion());
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

    static boolean ENV_CRHOME() {
        System.out.println("Run on CHROME " + System.getenv("ENV_CHROME"));
        return System.getenv("ENV_CHROME") != null;
    }

    @AfterClass
    public void tearDown() {
        if (ENV_CRHOME()){
        driver.close();
        driver.quit();}
        else {
            driver.close();
        }
    }
}
