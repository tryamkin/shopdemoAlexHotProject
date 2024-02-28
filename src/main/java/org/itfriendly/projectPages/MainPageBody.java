package org.itfriendly.projectPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.itfriendly.constants.Constatnt.Urls.SHOP_DEMO_URL;

public class MainPageBody extends MainPage {
    @FindBy(xpath = "//*[@class='react-multiple-carousel__arrow react-multiple-carousel__arrow--right']")
    private WebElement arrowRightClick;

    @FindBy(xpath = "//li[@class='react-multi-carousel-item react-multi-carousel-item--active carousel-slider-item']")
    private WebElement blueSuperSaleBannerApears;

    public void openPage() {
        driver.get(SHOP_DEMO_URL);
    }

    public boolean isNextBannerArrowClickable() {
        waitForElementVisibility(arrowRightClick);
        return isClickableArrow(arrowRightClick);

    }

    private boolean isClickableArrow(WebElement element) {

        return element.isEnabled() && element.isDisplayed();
    }

    public void clickOnArrow() {
        waitForElementVisibility(arrowRightClick);
        arrowRightClick.click();

    }

    public WebElement nextBannerApeared() {
        return blueSuperSaleBannerApears;
    }
}

