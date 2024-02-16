package tests;

import core.BaseSeleniumTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.itfriendly.projectPages.MainPage;


public class TryamMainPageTest extends BaseSeleniumTest {

    @Test
    public void openPageTest(){
        MainPage mainPage = new MainPage();
        mainPage.openPage();
        Assert.assertEquals(mainPage.logoName(),"MERN Store");
    }

    @Test
    public void LinkSectionNumberOfElementsTest(){
        MainPage mainPage = new MainPage();
        mainPage.openPage();
        Assert.assertEquals(mainPage.listElementsSize(),3);
        Assert.assertEquals(mainPage.listElements(0),"Contact Us");
        Assert.assertEquals(mainPage.listElements(1),"Sell With Us");
        Assert.assertEquals(mainPage.listElements(2),"Shipping");

    }
}
