package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *  Write down the following test into ‘LoginTest’ class
 * 1. userShouldLoginSuccessfullyWithValid Credentials()
 * * Click on ‘Sign In’ link * Enter valid Email
 * * Enter valid Password * Click on ‘Sign In’ button
 * * Verify the ‘Welcome’ text is display
 *
 * 2. verifyTheErrorMessageWithInvalidCredentials * Click on ‘Sign In’ link
 * * Enter valid Email * Enter valid Password * Click on ‘Sign In’ button
 * * Verify the error message ‘The account sign-in was incorrect or your account is disabled temporarily.
 * Please wait and try again later.’
 *
 * 3. userShouldLogOutSuccessfully * Click on ‘Sign In’ link * Enter valid Email * Enter valid Password
 * * Click on ‘Sign In’ button * Verify the ‘Welcome’ text is display * Click on down aero neare Welcome
 * * Click on Sign Out link * Verify the text ‘You are signed out’
 */
public class LoginTest extends BaseTest{
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
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Find sign in link element and click on it
        WebElement signInLink = driver.findElement(By.xpath("//div[@class='panel header']//li[@class='authorization-link']//a"));
        signInLink.click();
        //Find email field element and enter email id
        WebElement emailFieldElement = driver.findElement(By.id("email"));
        emailFieldElement.sendKeys("Rahulkumar123@gmail.com");
        //Find password field element and enter password
        WebElement passwordFieldElement = driver.findElement(By.id("pass"));
        passwordFieldElement.sendKeys("Anil@123");
        //Find sign-in button element and click on it
        WebElement signInButtonElement = driver.findElement(By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']"));
        signInButtonElement.click();

        //Expected text according to requirement
        String expectedText = "Welcome";
        //Find welcome text element and get it's text
        WebElement welcomeText = driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in' and contains(text(),'Welcome')]"));
        String actualText = welcomeText.getText();
        //Verify expected and actual text
        Assert.assertEquals("text is not matched", expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials(){
        WebElement signInLink = driver.findElement(By.xpath("//div[@class='panel header']//li[@class='authorization-link']//a"));
        signInLink.click();
        //Find email field element and enter invalid email id
        WebElement emailFieldElement = driver.findElement(By.id("email"));
        emailFieldElement.sendKeys("kumar123@gmail.com");
        //Find password field element and enter invalid password
        WebElement passwordFieldElement = driver.findElement(By.id("pass"));
        passwordFieldElement.sendKeys("Anil@123");
        //Find sign-in button element and click on it
        WebElement signInButtonElement = driver.findElement(By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']"));
        signInButtonElement.click();

        //Expected text according to requirement
        String expectedText = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        //Find error text element and get it's text
        WebElement errorText = driver.findElement(By.xpath("//div[@class='message-error error message']"));
        String actualText = errorText.getText();
        //Verify expected and actual text
        Assert.assertEquals("text is not matched", expectedText, actualText);
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //Find sign in link element and click on it
        WebElement signInLink = driver.findElement(By.xpath("//div[@class='panel header']//li[@class='authorization-link']//a"));
        signInLink.click();
        //Find email field element and enter email id
        WebElement emailFieldElement = driver.findElement(By.id("email"));
        emailFieldElement.sendKeys("Rahulkumar123@gmail.com");
        //Find password field element and enter password
        WebElement passwordFieldElement = driver.findElement(By.id("pass"));
        passwordFieldElement.sendKeys("Anil@123");
        //Find sign-in button element and click on it
        WebElement signInButtonElement = driver.findElement(By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']"));
        signInButtonElement.click();

        //Expected text according to requirement
        String expectedText = "Welcome";
        //Find welcome text element and get it's text
        WebElement welcomeText = driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in' and contains(text(),'Welcome')]"));
        String actualText = welcomeText.getText();
        //Verify expected and actual text
        Assert.assertEquals("text is not matched", expectedText, actualText);

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
        Assert.assertEquals("text is not matched", expectedText, actualText);

    }
}
