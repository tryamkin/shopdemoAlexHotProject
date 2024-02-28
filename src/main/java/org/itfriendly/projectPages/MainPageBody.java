package org.itfriendly.projectPages;

import org.itfriendly.core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.itfriendly.constants.Constatnt.Urls.SHOP_DEMO_URL;

public class MainPageBody extends BaseSeleniumPage {

    public MainPageBody() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@aria-label='Go to next slide'][1]")
    private WebElement blueSuperSaleBanner;

    public void openPage() {
        driver.get(SHOP_DEMO_URL);
    }

    public boolean isNextBannerArrowClickable() {
        waitForElementVisibility(blueSuperSaleBanner);
        return isClickableArrow(blueSuperSaleBanner);
    }

    private boolean isClickableArrow(WebElement element) {
        System.out.println("isEnabled() blueSuperSaleBanner - " + element.isEnabled() );
        System.out.println("isDisplayed() blueSuperSaleBanner -  " + element.isDisplayed());
        return element.isEnabled() && element.isDisplayed();
    }
    public void clickOnArrow(){
        waitForElementVisibility(blueSuperSaleBanner);
        blueSuperSaleBanner.click();
        System.out.println("Click on blueSuperSaleBanner" );

    }
}