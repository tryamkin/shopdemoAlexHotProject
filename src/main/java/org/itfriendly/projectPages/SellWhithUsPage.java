package org.itfriendly.projectPages;

import org.itfriendly.core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SellWhithUsPage extends BaseSeleniumPage {
    public SellWhithUsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='wrapper']/div")
    private WebElement bodyAttribute;

    public String bodyName(){
       return bodyAttribute.getText();
    }
}
