package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SkinCarePage {

    public WebDriver driver;

    private static final Logger log = LogManager.getLogger(CartPage.class);

    public SkinCarePage(WebDriver driver) {
        this.driver = driver;
    }

    String maindiv="//*[@id=\"maincontainer\"]/div/div/div/div/div[3]/child::div";
    String div1;
    String div2;
    String div3;
    List<String> lst=new ArrayList<>();


    public void Get_Sale_Items(){
        int Count=0;

        for(int i=1; i<=6; i++){
            String child_div=maindiv+"["+i+"]";
            String sale_div=child_div+"/div[@class=\"thumbnail\"]/child::span";
            try{
                if(driver.findElement(By.xpath(sale_div)).isDisplayed()){
                    System.out.println("sale item found");
                    lst.add(child_div);
                    Count++;
                }
            }catch (Exception e){
                System.out.println("");
            }
        }
        System.out.println("total sale items are "+Count);
    }

    public void Get_Out_of_Stock() {
        int Count = 0;
        for (int i = 0; i < lst.size(); i++) {
            String nostock_div = lst.get(i) + "/child::div[2]/child::div[3]/child::span[@class=\"nostock\"]";
            try {
                if (driver.findElement(By.xpath(nostock_div)).isDisplayed()) {
                    System.out.println("nostock item found in sale item");
                    lst.remove(i);
                    Count++;
                }
            } catch (Exception e) {
                System.out.println("");
            }
        }
        System.out.println("total no stock items are " + Count);
    }

    public int Add_items(){
        for(int i=0; i<lst.size(); i++){
            String items=lst.get(i)+"/child::div[2]/child::div[3]/child::a";
            driver.findElement(By.xpath(items)).click();
        }
        driver.findElement(By.xpath("//a[@title=\"Added to cart\"]")).click();
        return lst.size();
    }
}
