package org.itfriendly.core;

import org.itfriendly.constants.Constatnt;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


abstract public class BaseSeleniumPage {
        protected static WebDriver driver;

        public static void setDriver(WebDriver webDriver){
            driver = webDriver;
        }


        public void goToUrls(String url){
            driver.get(url);
        }

        public WebElement waitForElementVisibility(WebElement element) {
            new WebDriverWait(driver, Duration.ofSeconds(Constatnt.TimeoutVariables.EXPLISITY_WAIT)).until(ExpectedConditions.visibilityOf(element));
            return element;
        }
    }

