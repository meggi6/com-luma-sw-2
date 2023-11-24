package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *  Write down the following test into ‘RegisterTest’ class
 *  1. verifyThatSignInPageDisplay * click on the ‘Create an Account’ link
 *  * Verify the text ‘Create New Customer Account’
 *  2. userSholdRegisterAccountSuccessfully * click on the ‘Create an Account’ link
 *  * Enter First name * Enter Last name * Click on checkbox Sign Up for Newsletter
 *  * Enter Emai * Enter Password * Enter Confirm Password * Click on Create an Account button
 *  * Verify the text 'Thank you for registering with Main Website Store.’
 *  * Click on down aero neare Welcome * Click on Sign Out link * Verify the text ‘You are signed out’
 */
public class RegisterTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    //Before annotation run in the beginning of all tests
    @Before
    //Browser set-up method
    public void setUp() {

        openBrowser(baseUrl);
    }

    //After annotation method run at the end of all tests
    @After
    //Browser closing method
    public void tearDown() {

        closeBrowser();
    }

    //Test annotation for executing the method
    @Test
    public void verifyThatSignInPageDisplay() {
        //Find create account link element and click on it
        WebElement createAccountLinkElement = driver.findElement(By.xpath("//div[@class='panel header']//a [text() = 'Create an Account']"));
        createAccountLinkElement.click();
        //Expected text according to requirement
        String expectedText = "Create New Customer Account";
        //Find Secure Area text element and get it's text
        WebElement createAccountTextElement = driver.findElement(By.xpath("//span[contains(@data-ui-id, 'page-title-wrapper') and contains(text(), 'Create New Customer Account')]"));
        String actualText = createAccountTextElement.getText();
        //Verify expected and actual text
        Assert.assertEquals("Text is not matching", expectedText, actualText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //Find create account link element and click on it
        WebElement createAccountLinkElement = driver.findElement(By.xpath("//div[@class='panel header']//a [text() = 'Create an Account']"));
        createAccountLinkElement.click();
        //Find first name field element and enter first name
        WebElement firstNameElement = driver.findElement(By.xpath("//input[@id= 'firstname' or @name='firstname']"));
        firstNameElement.sendKeys("Rahul");
        //Find last name field element and enter last name
        WebElement lastNameElement = driver.findElement(By.xpath("//input[contains(@id, 'stn') and starts-with(@name, 'last')]"));
        lastNameElement.sendKeys("Kumar");
        //Find email field element and enter email id
        WebElement emailFieldElement = driver.findElement(By.xpath("//input[starts-with(@id, 'email') and contains(@name, 'mai')]"));
        emailFieldElement.sendKeys("Rahulkumar123@gmail.com");
        //Find password field element and enter password
        WebElement passwordFieldElement = driver.findElement(By.xpath("//input[@id = 'password']"));
        passwordFieldElement.sendKeys("Anil@123");
        //Find confirm password field element and enter confirm password
        WebElement confirmPasswordFieldElement = driver.findElement(By.name("password_confirmation"));
        confirmPasswordFieldElement.sendKeys("Anil@123");
        //Find create account button element and click on it
        WebElement createAccountButtonElement = driver.findElement(By.xpath("//button[@class='action submit primary']"));
        createAccountButtonElement.click();

        //Expected text according to requirement
        String expectedWelcomeText = "Thank you for registering with Main Website Store.";
        //Find welcome text element and get it's text
        WebElement welcomeTextElement = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)' and text()='Thank you for registering with Main Website Store.']"));
        String actualWelcomeText = welcomeTextElement.getText();
        //Verify expected and actual text
        Assert.assertEquals("Register text is not matching", expectedWelcomeText, actualWelcomeText);

        //Find button near welcome element and click on it
        WebElement buttonNearWelcomeElement = driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']"));
        buttonNearWelcomeElement.click();
        //Find sign-out link element and click on it
        WebElement signOutLinkElement = driver.findElement(By.xpath("//div[@aria-hidden='false']//a[contains(text(), 'Sign Out ')]"));
        signOutLinkElement.click();

        String expectedSignOutText = "You are signed out";
        //Find sign-out text element and get it's text
        WebElement signOutTextElement = driver.findElement(By.xpath("//span[@class='base']"));
        String actuaLSignOutText = signOutTextElement.getText();
        //Verify expected and actual text
        Assert.assertEquals("text is not matched", expectedSignOutText, actuaLSignOutText);
    }
}