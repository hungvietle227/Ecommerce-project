package BAITAP;

import driver.driverFactory;
import element.ElementController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

import java.awt.*;
/*

Test Steps:

1. Goto http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)

4. Click on Sony Xperia mobile

5. Read the Sony Xperia mobile from detail page.

6. Compare Product value in list and details page should be equal ($100).

*/
@Test
public class TestCase2 {
    public static void testCase2() {
        //Step 1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 2. Open target page - Home Page
            driver.get("http://live.techpanda.org/");
            //Step 3.Click on �MOBILE� menu
            WebElement joinMobile = driver.findElement(By.cssSelector("a[href = 'http://live.techpanda.org/index.php/mobile.html']"));
            joinMobile.click();
            //Step 4.In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
            By phoneSelector = By.id("product-price-1");


            WebElement phone = driver.findElement(phoneSelector);
            String phonePrice = phone.getText();


            //Step 5: Click on Sony Xperia mobile
            By imageSelector = By.id("product-collection-image-1");


            WebElement image = driver.findElement(imageSelector);
            image.click();


            //Step 6: Read the Sony Xperia mobile from detail page.
            By phoneDetailSelector = By.id("product-price-1");


            WebElement actualPhone = driver.findElement(phoneDetailSelector);
            String realPrice = actualPhone.getText();


            //Step 7: Compare Product value in list and details page should be equal ($100).
                assertEquals("$100.00", phonePrice);
                assertEquals("$100.00", realPrice);
                System.out.println(phonePrice + realPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}