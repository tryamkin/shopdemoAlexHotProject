package tests;

import core.BaseSeleniumTest;
import org.itfriendly.projectPages.MainPageBody;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KaterynaSpecialOfferBannerTest extends BaseSeleniumTest {


    @Test
    public void clickOnBannersArrow() {
        MainPageBody offerBanner = new MainPageBody();
        offerBanner.openPage();
        offerBanner.clickOnArrow();
        Assert.assertTrue(offerBanner.isNextBannerArrowClickable());

    }

}
