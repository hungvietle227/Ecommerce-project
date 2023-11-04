package BAITAP;

import POM.RegisterPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

/*

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In mobile products list , click on �Add To Compare� for 2 mobiles (Sony Xperia & Iphone)

4. Click on �COMPARE� button. A popup window opens

5. Verify the pop-up window and check that the products are reflected in it

Heading "COMPARE PRODUCTS" with selected products in it.

6. Close the Popup Windows

*/

public class TestCase6 {
    @Test
    public void tc06() {
        // Set the path to the ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

//        // Create a new instance of the ChromeDriver
//        WebDriver driver = new ChromeDriver();
        // 1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();


        // Step 1: Go to the website
        driver.get("http://live.techpanda.org/");

        // Step 2: Click on "MOBILE" menu
        WebElement accountMenu = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a"));
        accountMenu.click();

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.clickMyAccountLink();

        for (String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }

        registerPage.clickCreateAccountLink();

        for (String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }

        registerPage.enterFirstName("Hung");
        registerPage.enterLastName("Le");
        registerPage.enterEmail("hungtest@gmail.com");
        registerPage.enterPassword("123456789");
        registerPage.enterConfirmPassword("123456789");
        registerPage.clickRegister();

        WebElement tvMenu = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[2]/a"));
        tvMenu.click();

        WebElement AddToWishList = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a"));
        AddToWishList.click();

        WebElement ShareWishList = driver.findElement(By.xpath("//*[@id=\"wishlist-view-form\"]/div/div/button[1]"));
        ShareWishList.click();

        By emailAddress = By.xpath("//*[@id=\"email_address\"]");
        WebElement emailAdressElement = driver.findElement(emailAddress);
        emailAdressElement.clear();
        emailAdressElement.sendKeys("hung1@gmail.com");

        By msg = By.xpath("//*[@id=\"message\"]");
        WebElement messageElement = driver.findElement(msg);
        messageElement.clear();
        messageElement.sendKeys("Good");

        WebElement share = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button"));
        share.click();
        for (String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
        // Close the browser
        driver.quit();
    }
}