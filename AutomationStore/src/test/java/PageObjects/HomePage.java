package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    public WebDriver driver;
    private static final Logger log =  LogManager.getLogger(HomePage.class);

    public HomePage (WebDriver driver){
        this.driver=driver;
    }

    private By homepg= By.xpath("//*[@id=\"customer_menu_top\"]/li/a/div");
    private By productpg=By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[6]/a");
    private By byproduct=By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/ul/li[1]/div/a");
    private By skincare=By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[4]/a");
    private By Apparel=By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[2]/a");
    public By getHomepg() {
        return homepg;
    }

    public void Verify_HomePage(){
        try{
            driver.findElement(homepg).getText().contains("shaiz");
        }catch (Exception e){
            Assert.fail("unable to verify homepg");
            log.error("unable to verify homepg");
        }
    }

    public void Navigate_Product_Page(){
        try{
            driver.findElement(productpg).click();
            driver.findElement(byproduct).click();
        }catch (Exception e){
            Assert.fail("Unable to navigate to product page");
            log.error("Unable to navigate to product page");
        }
    }

    public void Navigate_Men_Product_Page(){
        try{
            driver.findElement(productpg).click();
        }catch (Exception e){
            Assert.fail("Unable to navigate to product page");
            log.error("Unable to navigate to product page");
        }
    }

    public void Navigate_SkinCare_Page(){
        try{
            driver.findElement(skincare).click();
        }catch (Exception e){
            Assert.fail("Unable to navigate to skin care");
            log.error("Unable to navigate to skin care");
        }
    }

    public void Navigate_Apparel(){
        try{
            driver.findElement(Apparel).click();
        }catch (Exception e){
            Assert.fail("Unable to navigate to skin care");
            log.error("Unable to navigate to skin care");
        }
    }
}
