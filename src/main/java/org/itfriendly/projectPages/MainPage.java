package org.itfriendly.projectPages;

import org.itfriendly.core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.itfriendly.constants.Constatnt.Urls.SHOP_DEMO_URL;

public class MainPage extends BaseSeleniumPage {
    @FindBy(xpath = "//*[@class=\"logo\"]")
    private WebElement logo;
    //добавил секцию Линкс с 3мя элементами в Лист
    @FindBy(xpath = "//*[@id=\"root\"]/div/footer/div/div[1]/div[2]//li[@class=\"footer-link\"]")
    private List<WebElement> linkSession;

    // constructor - must have
    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(SHOP_DEMO_URL);
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
    //возврат количества элементов
    public int listElementsSize() {
        return linkSession.size();
    }


}
