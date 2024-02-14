package tests;

import core.BaseSeleniumTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.itfriendly.projectPages.MainPage;

public class MainPageTest extends BaseSeleniumTest {

    @Test
    public void openPage(){
        MainPage mainPage = new MainPage();
        mainPage.openPage();
        Assert.assertEquals(mainPage.logoName(),"MERN Store");

    }
}
