package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    public WebDriver driver;
    private static final Logger log =  LogManager.getLogger(LoginPage.class);

    public LoginPage (WebDriver driver){
        this.driver=driver;
    }



    private By loginpg=By.xpath("//*[@id=\"customer_menu_top\"]/li/a");
    private By username=By.xpath("//*[@id=\"loginFrm_loginname\"]");
    private By password=By.xpath("//*[@id=\"loginFrm_password\"]");
    private By loginbtn=By.xpath("//*[@id=\"loginFrm\"]/fieldset/button");

    public By getLoginpg() {
        return loginpg;
    }

    public void VerifyLoginPage(){
        log.info("checking loginpage");
        Assert.assertTrue(driver.findElement(loginpg).isDisplayed());
        driver.findElement(loginpg).click();
    }

    public void EnterUsername(String usr){
        try{
            driver.findElement(username).sendKeys(usr);
            log.info("entering uname");
        } catch (Exception e){
            Assert.fail("Unable to send username");
            log.error("unable to send user name");
        }
    }

    public void EnterPassword(String pwd){
        try{
            driver.findElement(password).sendKeys(pwd);
            log.info("entered password");
        } catch (Exception e){
            Assert.fail("Unable to send password");
            log.error("unable to send password");
        }
    }

    public void ClickLoginButton(){
        try{
            driver.findElement(loginbtn).click();
            log.info("clicked on login button");
        } catch (Exception e){
            Assert.fail("Unable to click login button");
            log.error("unable to click login button");
        }
    }
}
