package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * .Write down the following test into ‘SaleTest’ class
 * 1. verifyTheTotalItemsDisplayedOnTheWomens JacketsPage() * Click on ‘Sale’ Menu tab
 * * Click on ‘Jackets’ link on left side under WOMEN’S DEAL Category * Verify the text ‘Jackets’ is displayed
 * * Count the Total Item Displayed on Page and print the name of all items into console.
 * * Verify total 12 Items displayed on page
 */
public class SaleTest extends BaseTest {
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
    public void verifyTheTotalItemsDisplayedOnTheWomenJacketsPage(){
        //Find sale link element on menu tab and click on it
        WebElement saleLinkElement = driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/sale.html']"));
        saleLinkElement.click();
        //Find jackets link element and click on it
        WebElement jacketsLinkElement = driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html' and text()='Jackets']"));
        jacketsLinkElement.click();

        //Expected text according to requirement
        String expectedText = "Jackets";
        //Find Jackets text element and get it's text
        WebElement jacketsTextElement = driver.findElement(By.xpath("//span[@data-ui-id='page-title-wrapper']"));
        String actualText = jacketsTextElement.getText();
        //Verify expected and actual text
        Assert.assertEquals("Text is not matching", expectedText, actualText);

        //Expected no of items as per requirement
        int expectedItems = 12;
        //find total no of items Displayed Element and get its size
        List<WebElement> totalItemDisplayedElement = driver.findElements(By.className("product-image-photo"));
        int actualItems = totalItemDisplayedElement.size();
        //Printing no. of items displayed
        System.out.println("Total number of items are: " + totalItemDisplayedElement.size());
        //Verify actual total no of items to expected
        Assert.assertEquals("items are not equal", expectedItems, actualItems);
        //find products name elements
        List<WebElement> itemNames = driver.findElements(By.xpath("//ol[@class='products list items product-items']//li//div[1]//strong//a"));

        //Printing text of product elements on console
        System.out.println("Product names: ");
        for (WebElement names: itemNames) {
            System.out.println(names.getText());
        }
    }
}
