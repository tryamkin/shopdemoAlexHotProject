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
import static org.itfriendly.common.Config.BROWSER_NAME;
import static org.itfriendly.common.Config.OS_NAME_FOR_GIT;
import static org.itfriendly.constants.Constatnt.TimeoutVariables.IMPLISITY_WAIT;
import static org.itfriendly.constants.Constatnt.TimeoutVariables.PAGELOAD_WAIT;

abstract public class BaseSeleniumTest {
    protected WebDriver driver;


    @BeforeClass
    public void setUp() {


        if (!OS_NAME_FOR_GIT.equals("Linux")){
           switch (BROWSER_NAME) {
                case "CHROME" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                break;

                case "FIREFOX" :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                break;
                default:
                    System.out.println("Wrong browser name" + BROWSER_NAME);

            }
          }
        else if (BROWSER_NAME.equals("CHROME")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless","--no-sandbox",
                    "--disable-gpu","--disable-dev-shm-usage",
                    "--window-size=1920,1080","--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            System.out.println("Chrome");
            }
        else {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
            System.out.println("Firefox");
        }

        driver.manage().window().maximize();
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
