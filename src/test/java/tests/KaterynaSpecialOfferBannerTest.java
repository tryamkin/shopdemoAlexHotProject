package tests;

import core.BaseSeleniumTest;
import org.itfriendly.projectPages.MainPageBody;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KaterynaSpecialOfferBannerTest extends BaseSeleniumTest {


    @Test
    public void clickOnBannersArrowtest() {
        MainPageBody clickOnOfferBanner = new MainPageBody();
        clickOnOfferBanner.openPage();
        clickOnOfferBanner.clickOnArrow();
        Assert.assertTrue(clickOnOfferBanner.isNextBannerArrowClickable());

    }
    @Test
    public void checkIsClickRedirectstest(){
        MainPageBody blueBanner = new MainPageBody();
        blueBanner.openPage();
        blueBanner.clickOnArrow();
        blueBanner.nextBannerApeared().isDisplayed();

Assert.assertTrue( blueBanner.nextBannerApeared().isDisplayed());


    }

}
