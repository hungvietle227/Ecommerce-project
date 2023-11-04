package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

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

public class TestCase5 {
    @Test
    public void tc05() {
        // Set the path to the ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

//        // Create a new instance of the ChromeDriver
//        WebDriver driver = new ChromeDriver();
        // 1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();


        // Step 1: Go to the website
        driver.get("http://live.techpanda.org/");

        // Step 2: Click on "MOBILE" menu
        WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
        mobileMenu.click();

        // Step 3: Click on "ADD TO CART" for Sony Xperia mobile
        WebElement AddToCompare = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a"));
        AddToCompare.click();

        WebElement AddToCompare2 = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a"));
        AddToCompare2.click();

        WebElement btnCompare = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div[3]/div[1]/div[2]/div/button"));
        btnCompare.click();
        //get validate Title and close
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            String SonyTitle = "Sony Xperia";
            WebElement Sony = driver.findElement(By.cssSelector("a[title='Sony Xperia']"));
            String title1 = Sony.getAttribute("title");
            WebElement aElement = driver.findElement(By.cssSelector("a[title='IPhone']"));
            String title2 = aElement.getAttribute("title");
            assertEquals(SonyTitle, title1);
            assertEquals("IPhone", title2);
            driver.close();
        }
        // Close the browser
        driver.quit();
    }
}