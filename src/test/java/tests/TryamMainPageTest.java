package tests;

import core.BaseSeleniumTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.itfriendly.projectPages.MainPage;


public class TryamMainPageTest extends BaseSeleniumTest {

    @Test
    public void openPage(){
        MainPage mainPage = new MainPage();
        mainPage.openPage();
        Assert.assertEquals(mainPage.logoName(),"MERN Store");
    }

    @Test
    public void openPage1(){
        MainPage mainPage = new MainPage();
        mainPage.openPage();
        Assert.assertEquals(mainPage.logoName(),"MERN Store");
    }
}
