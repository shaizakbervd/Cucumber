package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public LoginPage login;
    public HomePage home;
    public MenProducts men;
    public CartPage cart;
    public SkinCarePage skin;
    public ApparelPage apparel;
    public TshirtsPage tshirt;
    public ShoesPage shoes;

    WebDriver driver;
    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }

    public LoginPage GetLoginPage(){
        login=new LoginPage(driver);
        return login;
    }

    public HomePage GetHomePage(){
        home=new HomePage(driver);
        return home;
    }

    public MenProducts GetMenProducts(){
        men=new MenProducts(driver);
        return men;
    }

    public CartPage GetCartPage(){
        cart=new CartPage(driver);
        return cart;
    }
    public SkinCarePage GetSkinCarePage(){
        skin=new SkinCarePage(driver);
        return skin;
    }

    public ApparelPage GetApparelPage(){
        apparel=new ApparelPage(driver);
        return apparel;
    }

    public TshirtsPage GetTshirtPage(){
        tshirt=new TshirtsPage(driver);
        return tshirt;
    }

    public ShoesPage GetShoesPage(){
        shoes=new ShoesPage(driver);
        return shoes;
    }

}
