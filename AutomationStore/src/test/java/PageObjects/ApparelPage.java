package PageObjects;

import io.cucumber.java.an.E;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ApparelPage {

    public WebDriver driver;
    private static final Logger log =  LogManager.getLogger(HomePage.class);

    private By tshirt_selec=By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/ul/li[2]");
    private By shoes_selec=By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/ul/li[1]/a");

    public ApparelPage (WebDriver driver){
        this.driver=driver;
    }

    public void Navigate_Tshirts(){
        try{
            driver.findElement((tshirt_selec)).click();
            log.info("tshirts page clicked");
        }catch (Exception e){
            Assert.fail("unable to click on tshirts");
            log.error("unable to click on tshirts");
        }
    }

    public void Navigate_Shoes(){
        try{
            driver.findElement(shoes_selec).click();
        }catch (Exception e){
            Assert.fail("couldnot locate shoes");
            log.error("couldnot locate shoes");
        }
    }
}
