package tests;

import core.BaseSeleniumTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.itfriendly.projectPages.MainPage;

import static org.itfriendly.constants.Constatnt.LinkSectionsElement.*;
import static org.itfriendly.constants.Constatnt.LinksSectionNames.*;
import static org.itfriendly.constants.Constatnt.NamesOfManePage.LOGONAME;
import static org.itfriendly.constants.Constatnt.Urls.SHOP_DEMO_URL;


public class TryamMainPageTest extends BaseSeleniumTest {

    @Test
    public void openPageTest(){
        driver.get(SHOP_DEMO_URL);
        MainPage mainPage = new MainPage();
        Assert.assertEquals(mainPage.logoName(),LOGONAME);
    }
@Ignore
    @Test
    public void linkSectionNumberOfElementsTest(){
        MainPage mainPage = new MainPage();
        Assert.assertEquals(mainPage.listElementsSize(),COUNT_ELEMENTS);
        Assert.assertEquals(mainPage.listElements(0),CONTACT_ELEMENT_NAME);
        Assert.assertEquals(mainPage.listElements(1),SELLWITHUS_ELEMENT_NAME);
        Assert.assertEquals(mainPage.listElements(2),SHIPPING_ELEMENT_NAME);
    }
    @Ignore
    @Test
    public void contackUsLinkTest(){
      MainPage mainPage = new MainPage();
      Assert.assertTrue(mainPage.checkLinkIsLinkAndClicable(mainPage.getContuctUsLink()));
      Assert.assertTrue(mainPage.checkOpenedLinkBodyAtribute(mainPage.getContuctUsLink())
              .toLowerCase()
              .contains(CONTACT));
    }
    @Ignore
    @Test
    public void sellWithUsLinkTest() {
        Assert.assertTrue(new MainPage()
                .checkLinkIsLinkAndClicableV2(SELLWITHUS));
    }
    @Ignore
    @Test
    public void sellWithUsLinkTestV2() {
       Assert.assertTrue(new MainPage()
               .checkPageBody()
               .bodyName()
               .toLowerCase()
               .contains("sell") );
    }
    @Ignore
    @Test
    public void shippingUrlTest(){
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.checkLinkIsLinkAndClicableV2(SHIPPING));
        Assert.assertFalse(mainPage.checkOpenedLinkBodyAtribute(mainPage.getSellWithUsLink())
                .toLowerCase()
                .contains(SHIPPING));
    }
}
