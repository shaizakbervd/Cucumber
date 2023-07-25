package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class ShoesPage {

    public WebDriver driver;
    private static final Logger log = LogManager.getLogger(ShoesPage.class);
    List<String> lst = new ArrayList<>();
    private By items= By.xpath("//a[@title='Add to Cart']");
    private By textbox=By.xpath("//*[@id=\"product_quantity\"]");
    private By Add=By.xpath("//*[@id=\"product\"]/fieldset/div[5]/ul/li/a");

    public ShoesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void Add_highest_product(TshirtsPage tshirt){
        tshirt.Sort_Items("Price High > Low");
        driver.findElement(items).click();
    }

    public void Set_Shoes_Quantity_Proceed(String quant){
        driver.findElement(textbox).clear();
        driver.findElement(textbox).sendKeys(quant);
        driver.findElement(Add).click();
    }
}
