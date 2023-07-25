package StepDefinitions;

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MenProducts;
import Utils.TestContextSetup;
import io.cucumber.java.en.*;

public class Scenario1StepDefinition {

    TestContextSetup tcs;
    public LoginPage login;
    public HomePage home;
    public MenProducts men;
    public CartPage cart;

    public Scenario1StepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
        login=tcs.pageobjectmanager.GetLoginPage();
        home=tcs.pageobjectmanager.GetHomePage();
        men=tcs.pageobjectmanager.GetMenProducts();
        cart=tcs.pageobjectmanager.GetCartPage();
    }

    @Given("User is on Login Page")
    public void user_is_on_login_page() {
        tcs.generic.DriverW(login.getLoginpg());
        login.VerifyLoginPage();
    }
    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String usr, String pwd) {
        login.EnterUsername(usr);
        login.EnterPassword(pwd);
    }
    @When("User tries to Login")
    public void user_tries_to_login() {
        login.ClickLoginButton();
    }
    @Then("User is on the Landing page")
    public void user_is_on_the_landing_page() {
        tcs.generic.DriverW(home.getHomepg());
        home.Verify_HomePage();
    }
    @When("User selects MEN products")
    public void user_selects_men_products() {
        home.Navigate_Product_Page();
        tcs.generic.DriverW(men.getProdpg());
        men.Verify_ProdPage();
    }
    @When("User selects latest {string} product")
    public void user_selects_latest_dove_product(String prod) {
        men.Locate_Dove_Product(prod);
    }
    @When("Add it to the cart")
    public void add_it_to_the_cart() {
        men.Get_Dove_Product();
    }
    @Then("verify the selected product has price {string} and quantity is {string}")
    public void verify_the_selected_product_has_price_and_quantity_is(String string, String string2) {
        cart.Verify_Price(string);
        cart.Verify_Qty(string2);
    }
}
