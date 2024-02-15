package org.itfriendly.common;

public class CommonActions {

    /**
     * тут мог бы быть метод проверяющий ОС на котором стартуют тесты, но он тут не пригодился.
     *
     * @return
     */
    public static boolean checkOsForGitHub() {
        // для запуска на GitHub CI
        System.out.println(Config.OS_NAME_FOR_GIT);
        if (Config.OS_NAME_FOR_GIT.contains("Linux")) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * это пока тут полежит =)
 */

// if (!OS_NAME_FOR_GIT.equals("Linux")) {
//            switch (BROWSER_NAME) {
//                case "CHROME":
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                    break;
//                case "FIREFOX":
//                    WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
//                    break;
//                default:
//                    System.out.println("Wrong browser name" + BROWSER_NAME);
//
//            }
//        } else if (BROWSER_NAME.equals("CHROME")) {
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless", "--no-sandbox",
//                    "--disable-gpu", "--disable-dev-shm-usage",
//                    "--window-size=1920,1080", "--remote-allow-origins=*");
//            driver = new ChromeDriver(options);
//            System.out.println("Chrome");
//        } else {
//            FirefoxOptions options = new FirefoxOptions();
//            options.addArguments("--headless");
//            driver = new FirefoxDriver(options);
//            System.out.println("Firefox");
//        }