package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.itfriendly.core.BaseSeleniumPage;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;
import java.util.UUID;

import static org.itfriendly.constants.Constatnt.TimeoutVariables.IMPLISITY_WAIT;
import static org.itfriendly.constants.Constatnt.TimeoutVariables.PAGELOAD_WAIT;

/**
 * это базовый класс, который настраивает и запускает всё.
 */

abstract public class BaseSeleniumTest {
    public static final String OS_NAME_FOR_GIT = System.getProperty("os.name");
    private static final String ENV_BROWSER_NAME = "ENV_BROWSER_NAME";
    protected WebDriver driver;
    private Boolean isTraceEnabled = true;

    @BeforeClass
    public void setUp() {
        /**
         * тут проверка на операционку - под гитом она линукс и если ос - линукс то мы применяем логику
         * прогона тестов как для гита.
         * */
        if (OS_NAME_FOR_GIT.equals("Linux")) {
            Properties properties = new Properties();
          properties.setProperty(ENV_BROWSER_NAME, System.getenv(ENV_BROWSER_NAME));
            /**Тут мы береём переменную - ENV_BROWSER_NAME: (например - "FIREFOX") из файла CIforItFriendly.yml
             * и передаём её в метод startBrowser, который применит драйвера для хрома или фаерфокса
             * */
            //TODO для вывода и перепроверки, потом убрать )))
            String options = properties.getProperty(ENV_BROWSER_NAME);
            System.out.println(options + "  ENV_BROWSER_NAME OPTION");
            startBrowser(options);
        } else {
            WebDriverManager.chromedriver().setup();
          //TODO add new ChromeOptions().addArguments("--headless") to run
           driver = new ChromeDriver(new ChromeOptions().addArguments("--headless","--window-size=1920,1080"));

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGELOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLISITY_WAIT));
        BaseSeleniumPage.setDriver(driver);
    }

    /**
     * тут логика и дравера для разных браузеров - хрому хромье, лисе - лисье )))
     * вызывается в методе setUp()
     */
    public void startBrowser(String Browser) {
        if (Browser.equals("CHROME")) {
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
    }


    @AfterClass
    public void tearDown() {

        if (ENV_BROWSER_NAME.equals("CHROME")) {
            driver.close();
            driver.quit();
        } else {
            driver.close();
        }
    }


    @AfterMethod
    public void attachFilesToFailedTest(ITestResult result) throws IOException {
        if (!result.isSuccess()) {
            String uuid = UUID.randomUUID().toString();
           Allure.getLifecycle().addAttachment(
                    uuid+"screenshot", "image/png", "png"
                    , ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            Path tracePath = Paths.get("target/surefire-reports/emailable-report.html");
            System.out.println(tracePath + " tracepath");
            Allure.addAttachment("source.html", "text/html", String.valueOf(tracePath));
           // String traceFileName = String.format("target/%s_trace.zip", uuid);

//
//            String traceFileName = String.format("target/%s_trace.zip", uuid);
//                Path tracePath = Paths.get(traceFileName);




        }
    }

//    protected void afterMethod(Method method, ITestResult testResult) {
//        if (!testResult.isSuccess()) takeScreenshot(driver, method.getName(), this.getClass().getName());
//    }

    static void takeScreenshot (WebDriver driver, String methodName, String className) {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(String.format("screenshots/%s.%s.png", className, methodName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


