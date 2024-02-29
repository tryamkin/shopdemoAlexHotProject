package tests;

import core.BaseSeleniumTest;
import org.itfriendly.projectPages.MainPageBody;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KaterynaSpecialOfferBannerTest extends BaseSeleniumTest {


    @Test
    public void clickOnBannersArrowtestTest() {

        System.out.println("clickOnBannersArrowtestTest() run" );
        MainPageBody offerBanner = new MainPageBody();
        offerBanner.openPage();
        offerBanner.clickOnArrow();
        System.out.println("Last check  offerBanner.isNextBannerArrowClickable() -  " + offerBanner.isNextBannerArrowClickable());
        Assert.assertTrue(offerBanner.isNextBannerArrowClickable());
    }

}
