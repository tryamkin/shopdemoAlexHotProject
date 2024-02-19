package tests;

import core.BaseSeleniumTest;
import org.itfriendly.projectPages.SellWhithUsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.itfriendly.projectPages.MainPage;

import static org.itfriendly.constants.Constatnt.LinksSectionNames.*;
import static org.itfriendly.constants.Constatnt.Urls.SHOP_DEMO_URL;


public class TryamMainPageTest extends BaseSeleniumTest {

    @Test
    public void openPageTest(){
        MainPage mainPage = new MainPage(SHOP_DEMO_URL);
        Assert.assertEquals(mainPage.logoName(),"MERN Store");
    }

    @Test
    public void linkSectionNumberOfElementsTest(){
        MainPage mainPage = new MainPage(SHOP_DEMO_URL);
        Assert.assertEquals(mainPage.listElementsSize(),3);
        Assert.assertEquals(mainPage.listElements(0),"Contact Us");
        Assert.assertEquals(mainPage.listElements(1),"Sell With Us");
        Assert.assertEquals(mainPage.listElements(2),"Shipping");
    }

    @Test
    public void contackUsLinkTest(){
      MainPage mainPage = new MainPage(SHOP_DEMO_URL);
      Assert.assertTrue(mainPage.checkLinkIsLinkAndClicable(mainPage.getContuctUsLink()));
      Assert.assertTrue(mainPage.checkOpenedLinkBodyAtribute(mainPage.getContuctUsLink())
              .toLowerCase()
              .contains(CONTACT));
    }

    @Test
    public void sellWithUsLinkTest() {
        Assert.assertTrue(new MainPage(SHOP_DEMO_URL).checkLinkIsLinkAndClicableV2(SELLWITHUS));
    }
    @Test
    public void sellWithUsLinkTestV2() {
       Assert.assertTrue( new MainPage(SHOP_DEMO_URL).checkPageBody().bodyName().toLowerCase().contains("sell") );
    }

    @Test
    public void shippingUrlTest(){
        MainPage mainPage = new MainPage(SHOP_DEMO_URL);
        Assert.assertTrue(mainPage.checkLinkIsLinkAndClicableV2(SHIPPING));
        Assert.assertFalse(mainPage.checkOpenedLinkBodyAtribute(mainPage.getSellWithUsLink())
                .toLowerCase()
                .contains(SHIPPING));
    }
}
