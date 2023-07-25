package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.reporters.jq.Main;

import java.util.ArrayList;
import java.util.List;

public class MenProducts {

    public WebDriver driver;
    private int counter=0;
    private static final Logger log =  LogManager.getLogger(MenProducts.class);

    public MenProducts (WebDriver driver){
        this.driver=driver;
    }

    private By prodpg= By.xpath("//*[@id=\"maincontainer\"]/div/div/div/h1/span[1]");
    private By products=By.xpath("//a[@class=\"prdocutname\"]");
    private By Price=By.xpath("//a[@title=\"Add to Cart\"]");
    private By cart=By.xpath("//a[@title=\"Added to cart\"]");
    String MainDiv="//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/child::div";

    List<String> lst=new ArrayList<>();


    public By getProdpg() {
        return prodpg;
    }

    public void Verify_ProdPage(){
        try{
            driver.findElement(prodpg).getText().contains("BODY");
        }catch (Exception e){
            Assert.fail("unable to verify prod page");
            log.error("unable to verify prod page");
        }
    }

    public int Locate_Dove_Product(String prod){
        try{
            List<WebElement> div=driver.findElements(products);
            for(int i=0; i<div.size(); i++){
                counter++;
                if(div.get(i).getText().contains(prod)){
                    break;
                }
            }
        }catch (Exception e){
            Assert.fail("unable to locate product");
            log.error("unable to locate product");
        }
        return counter;
    }

    public void Get_Dove_Product() {
        try {
            List<WebElement> prices = driver.findElements(Price);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,350)", "");
            prices.get(counter - 2).click();
            driver.findElement(cart).click();
        } catch (Exception e) {
            Assert.fail("Unable to click on cart");
            log.error("Unable to click on cart");
        }
    }

    public void Select_end_M_products(String name){
        for(int i=1; i<5; i++){
            String prod_name= MainDiv+"["+i+"]";
            String prod_title=prod_name+"/child::div[1]/child::div/child::a";
            String title=driver.findElement(By.xpath(prod_title)).getText();

            String lastChar = String.valueOf(title.charAt(title.length() - 1));

            if (lastChar.equals(name)){
                System.out.println("found");
                lst.add(prod_name+"/child::div[2]/child::div[3]/child::a");
            }
        }
        driver.findElement(By.xpath(lst.get(0))).click();
    }


}
