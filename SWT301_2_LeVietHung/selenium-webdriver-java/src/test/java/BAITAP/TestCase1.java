package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

/*

Test Steps

Step 1. Go to http://live.techpanda.org/

Step 2. Verify Title of the page

Step 3. Click on -> MOBILE -> menu

Step 4. In the list of all mobile , select SORT BY -> dropdown as name

Step 5. Verify all products are sorted by name

*/
@Test
public class TestCase1 {
    public static void testCase1(){
        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //2. Open target page - Home Page
            driver.get("http://live.techpanda.org/");
            //3. Find Title in web element
            String titleOrigin = "THIS IS DEMO SITE FOR";
            By titleName = By.tagName("h2");
            WebElement title = driver.findElement(titleName);
            String innerText = title.getText().trim();

            //5. Check validate
            System.out.println(innerText);
            assertEquals("valid",titleOrigin, innerText);
//            //6.Click on -> MOBILE -> menu
            WebElement joinMobile = driver.findElement(By.cssSelector("a[href = 'http://live.techpanda.org/index.php/mobile.html']"));
            joinMobile.click();
//            //7. In the list of all mobile , select SORT BY -> dropdown as name
            WebElement selectElement = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"));
            Select select = new Select(selectElement);
            select.selectByIndex(1);
            //5. Verify all products are sorted by name
            TakesScreenshot screenshot =((TakesScreenshot)driver);
            File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
            try{
                FileHandler.copy(srcFile, new File("E:\\SWT301\\selenium-webdriver-java\\src\\test\\java\\Picture\\TestCase1.png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}
