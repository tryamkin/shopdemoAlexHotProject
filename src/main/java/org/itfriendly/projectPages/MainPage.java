package org.itfriendly.projectPages;

import org.itfriendly.core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.itfriendly.constants.Constatnts.Urls.SHOP_DEMO_URL;

/*
тут надо описать элементы класса и методы страницы, которую будем гонять.
 */

public class MainPage extends BaseSeleniumPage {
    // constructor - must have
    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class=\"logo\"]")
    private WebElement logo;

    public void openPage(){
        driver.get(SHOP_DEMO_URL);
    }

    public String logoName(){
        //waiter
        waitForElementVisibility(logo);
        return logo.getText();
    }


}
