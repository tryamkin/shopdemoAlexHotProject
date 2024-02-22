package org.itfriendly.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

enum Browser {
    CHROME("CHROME"),
    FIREFOX("FIREFOX");


    private final String name;

    Browser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    // Add more browsers as needed
}

public class Config {
    /**
     * Указываем имя браузера тут
     * CHROME
     * FIREFOX
     * ETC ...
     */
    public static final String BROWSER_NAME = Browser.CHROME.getName();
    /*
     for github action, он стартует на линуксе, и эта строка определяет операционку и далее хром запускается с ключём --headless (с запуском на вируальном мониторе)
     */
    public static final String OS_NAME_FOR_GIT = System.getProperty("os.name");


    /*
    Тут у нас выбор браузера для гита
     */
    public static WebDriver gitRunConfig(WebDriver driver, String browser) {
        switch (browser) {
            case "CHROME":
                WebDriverManager.chromedriver().driverVersion("121").setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless", "--no-sandbox",
                        "--disable-gpu", "--disable-dev-shm-usage",
                        "--window-size=1920,1080", "--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                System.out.println("Chrome");

                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsf = new FirefoxOptions();
                optionsf.addArguments("--headless");
                driver = new FirefoxDriver(optionsf);
                System.out.println("Firefox");
                break;
            default:
                System.out.println("Wrong browser name" + BROWSER_NAME);
        }
        return driver;
    }

    /**
     * Тут локальный запуск метода с выбором браузера и передачи в драйвер параметров
     *
     *
     */
    public static WebDriver chooseDriver(WebDriver driver, String browser) {

        switch (browser) {
            case "CHROME":
                WebDriverManager.chromedriver().driverVersion("121").setup();
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Wrong browser name" + BROWSER_NAME);
        }

        driver.manage().window().maximize();
        return driver;
    }

}


