package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TshirtsPage {

    public WebDriver driver;
    private static final Logger log = LogManager.getLogger(TshirtsPage.class);
    private String main_div = "//*[@id=\"maincontainer\"]/div/div/div/div/div[3]";
    List<String> lst = new ArrayList<>();

    public TshirtsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void Sort_Items(String filter) {
        Select dd = new Select(driver.findElement(By.cssSelector("select[id='sort']")));
        dd.selectByVisibleText(filter);
    }

    public void Get_TshirtsItems() {
        for (int i = 1; i <= 5; i++) {
            String childdiv = main_div + "/child::div[@class='col-md-3 col-sm-6 col-xs-12']" + "[" + i + "]";
            String nostock = childdiv + "/child::div[@class='thumbnail']/child::div[@class='pricetag jumbotron']/child::span[@class='nostock']";
            try {
                if (driver.findElement(By.xpath(nostock)).isDisplayed()) {
                    System.out.println("nostock");
                } else {
                    System.out.println("");
                }
            } catch (Exception e) {
                lst.add(childdiv);
            }
        }
    }

    public void Add_Items(int item, CartPage cart){
        if(lst.size()<item){
            System.out.println("items found are less than desired size");
            for(int i=0; i<lst.size(); i++){
                String items=lst.get(i)+"/child::div[@class='thumbnail']/child::div[@class='pricetag jumbotron']/child::a";
                driver.findElement(By.xpath(items)).click();
                cart.Add_Cart_Tshirts();
                driver.navigate().back();
                driver.navigate().back();
            }
        }
    }

    public void Navigate_Back(HomePage home){
        home.Navigate_Apparel();
    }
}
