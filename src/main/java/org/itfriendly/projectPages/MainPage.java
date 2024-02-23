package org.itfriendly.projectPages;
import org.itfriendly.core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class MainPage extends BaseSeleniumPage {
    @FindBy(xpath = "//*[@class=\"logo\"]")
    private WebElement logo;
    //добавил секцию Линкс с 3мя элементами в Лист
    @FindBy(xpath = "//*[@id=\"root\"]/div/footer/div/div[1]/div[2]//li[@class=\"footer-link\"]")
    private List<WebElement> linkSession;


    // elements in Links section
    @FindBy(xpath = "//*[@id=\"root\"]/div/footer/div/div[1]/div[2]/div[2]/ul/li[1]/a")
    private WebElement contuctUsLink;
    @FindBy(xpath = "//*[@id=\"root\"]/div/footer/div/div[1]/div[2]/div[2]/ul/li[2]/a")
    private WebElement sellWithUsLink;
    @FindBy(xpath = "//body[1]/div[1]/div[1]/footer[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[3]/a[1]")
    private WebElement shippingLink;

    //для проеврки открытых страниц
    @FindBy(xpath = "//div[@class='wrapper']/div")
    private WebElement bodyAttribute;


    // constructor - must have
    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public MainPage openPage(String url){
        driver.get(url);
        return this;
    }

    public WebElement getContuctUsLink() {
        return contuctUsLink;
    }

    public WebElement getSellWithUsLink() {
        return sellWithUsLink;
    }

    public WebElement getShippingLink() {
        return shippingLink;
    }

    public String logoName() {
        //waiter
        waitForElementVisibility(logo);
        return logo.getText();
    }

    // перебор элементов в листе
    public String listElements(int element) {
        for (int i = 0; i < linkSession.size(); i++) {
            //  System.out.println(linkSession.get(i).getText());
        }
        return linkSession.get(element).getText();
    }

    //возврат количества элементов в секции ЛИНКС
    public int listElementsSize() {
        return linkSession.size();
    }

    /**
     * * @param link
     * public void checkLinkExample(WebElement link){
     * check is link contains "http"
     * System.out.println(link.getAttribute("href"));
     * check is link clickable
     * System.out.println(link.isEnabled());
     * }
     */

    public boolean checkLinkIsLinkAndClicable(WebElement link) {
        return link.isEnabled();
    }
    public boolean checkLinkIsLinkAndClicableV2(String name) {
        if (name.toLowerCase().contains("sell")){
          return  sellWithUsLink.isEnabled();
        } else if (name.toLowerCase().contains("ship")){
            return shippingLink.isEnabled();
        }else
        return contuctUsLink.isEnabled();
    }

    /**
     * * @param webElement - передаём из гетеров вебэлемент (например контакт)
     * public void openLinkExample(WebElement webElement) {
     * webElement.click();
     * т.к страницы открываютс в фрейме - тайтл и урл не эффективны, надо смотреть в боди.
     * System.out.println(driver.getTitle());
     * System.out.println(driver.getCurrentUrl());
     * проверка боди - есть ли в старинице атрибуты и как называются
     * System.out.println(bodyAttribute.getAttribute("class"));
     * System.out.println(bodyAttribute.getText());
     * }
     */


    public String checkOpenedLinkBodyAtribute(WebElement webElement) {
        webElement.click();
        System.out.println(bodyAttribute.getText());
        return bodyAttribute.getText();
    }

    public SellWhithUsPage checkPageBody(){
        sellWithUsLink.click();
        return new SellWhithUsPage();
    }
}
