package tests;

import core.BaseSeleniumTest;
import org.itfriendly.projectPages.MainPageBody;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class KaterynaSpecialOfferBannerTest extends BaseSeleniumTest {

    @Ignore
    @Test
    public void clickOnBannersArrowtest() {
        MainPageBody offerBanner = new MainPageBody();
        offerBanner.openPage();
        offerBanner.clickOnArrow();
        System.out.println("Last check  offerBanner.isNextBannerArrowClickable() -  " + offerBanner.isNextBannerArrowClickable());
        Assert.assertTrue(offerBanner.isNextBannerArrowClickable());
    }

}
