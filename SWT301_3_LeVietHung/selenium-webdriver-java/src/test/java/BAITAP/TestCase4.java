package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class TestCase4 {
    @Test
    public void tc03() {
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
        WebElement addToCartBtn = driver.findElement(By.xpath("//button[@title='Add to Cart' and @class='button btn-cart']"));
        addToCartBtn.click();

        // Step 4: Change "QTY" value to 1000 and click "UPDATE" button
//           WebElement qtyInput = driver.findElement(By.cssSelector("input[name='qty']"));
        WebElement qtyInput = driver.findElement(By.cssSelector("input[title='Qty']"));
        qtyInput.clear();
        qtyInput.sendKeys("1000");

        WebElement updateBtn = driver.findElement(By.cssSelector("button[title='Update']"));
        updateBtn.click();

        // Step 5: Verify the error message
        WebElement errorMessage = driver.findElement(By.cssSelector(".error-msg"));
        String expectedErrorMessage = "The requested quantity for \"Sony Xperia\" is not available.";
        String actualErrorMessage = errorMessage.getText();

        if (actualErrorMessage.equals(expectedErrorMessage)) {
            System.out.println("Error message is displayed correctly: " + actualErrorMessage);
        } else {
            System.out.println("Error message is not displayed correctly. Expected: " + expectedErrorMessage);
        }

        // Step 6: Click on "EMPTY CART" link
        WebElement emptyCartLink = driver.findElement(By.linkText("EMPTY CART"));
        emptyCartLink.click();

        // Step 7: Verify cart is empty
        WebElement emptyCartMessage = driver.findElement(By.cssSelector(".cart-empty"));
        String expectedEmptyCartMessage = "SHOPPING CART IS EMPTY";
        String actualEmptyCartMessage = emptyCartMessage.getText();

        if (actualEmptyCartMessage.equals(expectedEmptyCartMessage)) {
            System.out.println("Cart is empty: " + actualEmptyCartMessage);
        } else {
            System.out.println("Cart is not empty. Expected: " + expectedEmptyCartMessage);
        }

        // Close the browser
        driver.quit();
    }
}