package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class GenericUtils {

    public WebDriver driver;

    public GenericUtils(WebDriver driver){
        this.driver=driver;
    }


    public void DriverW(By locator) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e){
            Assert.fail("Unable to find the locator");
        }

    }
}
