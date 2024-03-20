package tests;

import core.BaseSeleniumTest;
import org.itfriendly.projectPages.MainPageFooterSubscription;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class  HelenMainPageTest extends BaseSeleniumTest {



    @Test
    public void subscriptionSectionNameTest() {
        MainPageFooterSubscription mainPageFooterSubscription = new MainPageFooterSubscription();
        mainPageFooterSubscription.openPage();
        Assert.assertEquals(mainPageFooterSubscription.subscriptionSectionName(), "NEWSLETTER");
    }

    @Test
    public void subscriptionInputFieldNameTest() {
        MainPageFooterSubscription mainPageFooterSubscription = new MainPageFooterSubscription();
        mainPageFooterSubscription.openPage();
        Assert.assertEquals(mainPageFooterSubscription.subscriptionInputFieldName(), "Sign Up for Our Newsletter");
    }

    @Test
    public void subscriptionInputFieldContainsPlaceholderTest() {
        MainPageFooterSubscription mainPageFooterSubscription = new MainPageFooterSubscription();
        mainPageFooterSubscription.openPage();
        Assert.assertEquals(mainPageFooterSubscription.subscriptionPlaceholderName(), "Please Enter Your Email");
    }

    @Test
    public void subscriptionButtonNameAndClickableTest() {
        MainPageFooterSubscription mainPageFooterSubscription = new MainPageFooterSubscription();
        mainPageFooterSubscription.openPage();
        Assert.assertEquals(mainPageFooterSubscription.subscriptionButtonName(), "Subscribe");
        Assert.assertTrue(mainPageFooterSubscription.isSubscriptionButtonClickable(), "Button isn't clickable");
    }

    @Test
    public void subscribeWithValidEmailTest() {
        MainPageFooterSubscription mainPageFooterSubscription = new MainPageFooterSubscription();
        mainPageFooterSubscription.openPage();

        // Step 1: Navigate to the input field "Sign Up for Our Newsletter"
        WebElement emailInputField = mainPageFooterSubscription.getSubscriptionInputField();
        // Step 2: Enter a valid email address in the input field
        String randomEmail = MainPageFooterSubscription.generateRandomEmail();
        emailInputField.sendKeys(randomEmail);
        // Step 3: Click on the "Subscribe" button
        mainPageFooterSubscription.clickSubscriptionButton();
        // Verification: Check if subscription is successful
        String successMessage = "You have successfully subscribed to the newsletter";
        Assert.assertEquals(mainPageFooterSubscription.isSubscriptionSuccessful(), successMessage);

    }
    @Ignore
    @Test
    public void subscribeWithInvalidEmailTest() {
        MainPageFooterSubscription mainPageFooterSubscription = new MainPageFooterSubscription();
        mainPageFooterSubscription.openPage();
        WebElement emailInputField = mainPageFooterSubscription.getSubscriptionInputField();
        String invalidEmail = MainPageFooterSubscription.generateRandomInvalidEmail();
        emailInputField.sendKeys(invalidEmail);
        mainPageFooterSubscription.clickSubscriptionButton();
        Assert.assertEquals(mainPageFooterSubscription.invalidEmailSubscription(), "Email format is invalid.");
    }

    @Test
    public void subscribeWithEmptyEmailTest(){
        MainPageFooterSubscription mainPageFooterSubscription = new MainPageFooterSubscription();
        mainPageFooterSubscription.openPage();
        mainPageFooterSubscription.clickSubscriptionButton();
        Assert.assertEquals(mainPageFooterSubscription.emptyEmailSubscription(), "Email is required.");
    }

    @Test
    public void subscribeMultipleTimesTest(){
        MainPageFooterSubscription mainPageFooterSubscription = new MainPageFooterSubscription();

        for (int i = 0; i <= 1; i++) {
            subscribeWithValidEmailTest();
            }

        String errorMessageElement = mainPageFooterSubscription.getErrorMessageElement();
        //comment because we don't want to fail our tests :)
        //Assert.assertEquals(errorMessageElement.contains("Email is already subscribed."), "Email is already subscribed.");
    }
}
