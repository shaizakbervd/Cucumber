package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.util.TimeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartPage {

    public WebDriver driver;

    private static final Logger log =  LogManager.getLogger(CartPage.class);

    public CartPage (WebDriver driver){
        this.driver=driver;
    }

    private By price= By.xpath("//*[@id=\"cart\"]/div/div[1]/table/tbody/tr[2]/td[4]");
    private By qty=By.xpath("//*[@id=\"cart_quantity75\"]");
    private By salediv=By.xpath("//*[@id=\"cart\"]/div/div[1]/table/tbody");
    private By tbody=By.xpath("//*[@id=\"cart\"]/div/div[1]/table/tbody/child::tr");
    String t_body="//*[@id=\"cart\"]/div/div[1]/table/tbody/child::tr";
    private By Add_cart=By.xpath("//*[@id=\"product\"]/fieldset/div[5]/ul/li/a");
    private By scn_4=By.xpath("//*[@id=\"cart\"]/div/div[1]/table/tbody/child::tr");
    int Count=2;
    List<String> lst=new ArrayList<>();

    public By getAdd_cart() {
        return Add_cart;
    }

    public void Add_Cart_Tshirts(){
        driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[6]/ul/li/a")).click();
    }

    public void Add_Cart(){
        try{
            driver.findElement(Add_cart).click();
        }catch (Exception e){
            Assert.fail("unable to add to cart");
        }
    }

    public void Verify_Price(String prices){
        try{
            driver.findElement(price).getText().contains(prices);
        }catch (Exception e){
            Assert.fail("unable to verify price");
            log.error("unable to verify price");
        }
    }
    public void Verify_Qty(String quant){
        try{
            driver.findElement(qty).getCssValue("value").contains(quant);
            driver.findElement(By.xpath("//*[@id=\"cart\"]/div/div[1]/table/tbody/tr[2]/td[7]/a")).click();
        }catch (Exception e){
            Assert.fail("unable to verify quantity");
            log.error("unable to verify quantity");
        }
    }

    public void Verify_sale_items(int val) throws InterruptedException {
        try{
            int size=driver.findElements(tbody).size();
            if(size-1==val){
                System.out.println("Verified items");
            }
        }catch (Exception e){
            Assert.fail("unable to verify");
        }

        for(int i=1; i<=val; i++){
            String new_body=t_body+"["+(2)+"]"+"/child::td[7]/child::a";
            lst.add(new_body);
        }
        for(int i=0; i<lst.size(); i++){
            driver.findElement(By.xpath(lst.get(i))).click();
            Thread.sleep(2);
        }
    }

    ///child::td[@class="align_left"][1]/child::a

    public void Verify_M_Products(String name){
        try{
            String tr=t_body+"["+2+"]";
            String title=tr+"/child::td[@class=\"align_left\"][1]/child::a";
            String prod_title=driver.findElement(By.xpath(title)).getText();
            String lastChar = String.valueOf(prod_title.charAt(prod_title.length() - 1));

            if (lastChar.equals(name)){
                System.out.println("verified");
            }
            driver.findElement(By.xpath(tr+"/child::td[7]/child::a")).click();
        }catch (Exception e){
            Assert.fail("could not verify");
        }
    }

    public void Verify_products(String total){
        try{
            List<WebElement> elem=driver.findElements(scn_4);
            int size=elem.size();
            if((size-1)==Integer.valueOf(total)){
                System.out.println("Items Verified");
            }
        }catch (Exception e){
            Assert.fail("could not find elements");
        }
    }

}
