package org.itfriendly.projectPages;

import org.itfriendly.core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

import static org.itfriendly.constants.Constatnt.Urls.SHOP_DEMO_URL;


public class MainPageFooterSubscription extends BaseSeleniumPage {
    @FindBy(xpath = "//*[@class=\"logo\"]")
    private WebElement logo;
    @FindBy(xpath = "//h3[text()='Newsletter']")
    private WebElement subscriptionSectionName;
    @FindBy(xpath = "//p[text()='Sign Up for Our Newsletter']")
    private WebElement subscriptionInputFieldName;
    @FindBy(xpath = "//input[contains(@placeholder,'Please Enter Your Email')]")
    private WebElement subscriptionPlaceholderName;
    @FindBy(xpath = "//span[text()='Subscribe']")
    private WebElement subscriptionButtonName;
    @FindBy(xpath = "//input[contains(@placeholder,'Please Enter Your Email')]")
    private WebElement subscriptionInputField;
    @FindBy(xpath ="//span[@class='invalid-message' and contains(text(),'Email format is invalid.')]")
    private WebElement errorMessageForInvalidEmail;
    @FindBy(xpath ="//span[@class='invalid-message' and contains(text(),'Email is required.')]")
    private WebElement emptyEmailSubscription;

    private String errorMessageElement = "Email is already subscribed.";
    //How to catch the pop-up or message window in Chrome:
    //Open devTools (F12).
    //Select the "Sources" tab.
    //While the element you want is displayed, press F8 (or Ctrl+/). This will break script execution and "freeze" the DOM exactly as it is displayed.
    //From this point, use Ctrl+Shift+C to select the element.
    @FindBy(xpath = "//h4[text()='You have successfully subscribed to the newsletter']")
    private WebElement successMessageSubscription;
    //constructor - done
    public MainPageFooterSubscription() {
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(SHOP_DEMO_URL);
    }

    public String subscriptionSectionName() {
        waitForElementVisibility(subscriptionSectionName);
        return subscriptionSectionName.getText();
    }
    public String subscriptionInputFieldName() {
        waitForElementVisibility(subscriptionInputFieldName);
        return subscriptionInputFieldName.getText();
    }

    public String subscriptionPlaceholderName() {
        waitForElementVisibility(subscriptionPlaceholderName);
        return subscriptionPlaceholderName.getAttribute("placeholder");
    }

    public String subscriptionButtonName(){
        waitForElementVisibility(subscriptionButtonName);
        return subscriptionButtonName.getText();
    }
    public boolean isSubscriptionButtonClickable() {
        waitForElementVisibility(subscriptionButtonName);
        return isClickable(subscriptionButtonName);
    }

    private boolean isClickable(WebElement element) {
        return element.isEnabled() && element.isDisplayed();
    }

    public WebElement getSubscriptionInputField() {
        return subscriptionInputField;
    }
    public void clickSubscriptionButton() {
        waitForElementVisibility(subscriptionButtonName);
        subscriptionButtonName.click();
    }

    public String isSubscriptionSuccessful() {
        waitForElementVisibility(successMessageSubscription);
        return successMessageSubscription.getText();
    }


    public static String generateRandomEmail() {
        String[] domains = {"example.com", "test.com"};
        String username = generateRandomString(8); // Change the length as needed
                String domain = domains[new Random().nextInt(domains.length)];
        return username + "@" + domain;
    }

    private static String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            randomString.append(characters.charAt(random.nextInt(characters.length())));
        }

        return randomString.toString();
    }

    public static String generateRandomInvalidEmail() {
        String[] invalidEmails = {
                "invalidemail@",
                "missingdomain@.com",
                "missingusername@domain.com",
                "toomany@@symbols.com",
                "spaces in email@example.com"
        };

        return invalidEmails[new Random().nextInt(invalidEmails.length)];
    }

    public String invalidEmailSubscription(){
        waitForElementVisibility(errorMessageForInvalidEmail);
        return errorMessageForInvalidEmail.getText();
    }

    public String emptyEmailSubscription() {
        waitForElementVisibility(emptyEmailSubscription);
        return emptyEmailSubscription.getText();
    }

    public String getErrorMessageElement() {
        return errorMessageElement;
    }

}


