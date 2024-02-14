package exampples;
import core.BaseSeleniumTest;
import org.itfriendly.examples.google.CalcPage;
import org.itfriendly.examples.google.MainPage;
import org.itfriendly.examples.google.SearchPage;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class GooglePageTest extends BaseSeleniumTest {

    @Test()
    public void firstTest() {
        MainPage mainPage = new MainPage().
                openUrlPage();
        Assert.assertTrue(mainPage.getTitlePage().contains("Google"));
    }

    @Test(priority = 2)
    @Description("Second test open Browser")
    public void searchSomethingTest() {
        SearchPage searchPage = new MainPage().
                searchSomething("Selenium");
        Assert.assertTrue(searchPage.getUrlPage().contains("search"));

    }

    @Test
    public void open(){
        driver.get("https://google.com.ua");
    }

    @Test(priority = 3)
    public void searchTResultTest() {
        SearchPage searchResult = new MainPage().
                openUrlPage().
                searchSomething("Selenium");
        Assert.assertTrue(searchResult.setSearchResults() > 1000);

    }

    @Test
    public void calcTest() {
        CalcPage calcPage = new MainPage().
                openUrlPage().
                calc();
        Assert.assertEquals(calcPage.getAnswer(), 4);

    }

    @Test
    public void exampleSimpleTest(){
        driver.get("http://google.com.ua");
        driver.getTitle();
        WebElement inputField = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        inputField.click();
        inputField.sendKeys("Selenium");
        inputField.sendKeys(Keys.ENTER);
        driver.getTitle();
        Assert.assertTrue(driver.getCurrentUrl().contains("search"));


    }

}
