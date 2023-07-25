package StepDefinitions;

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MenProducts;
import Utils.TestContextSetup;
import io.cucumber.java.en.*;

public class Scenario4StepDefinition {

    TestContextSetup tcs;
    public LoginPage login;
    public HomePage home;
    public MenProducts men;
    public CartPage cart;

    public Scenario4StepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
        login=tcs.pageobjectmanager.GetLoginPage();
        home=tcs.pageobjectmanager.GetHomePage();
        men=tcs.pageobjectmanager.GetMenProducts();
        cart=tcs.pageobjectmanager.GetCartPage();
    }

    @When("User selects MEN products only")
    public void user_selects_men_products_only() {
        home.Navigate_Men_Product_Page();
    }


    @When("User selects product whose name ends with {string}")
    public void user_selects_product_whose_name_ends_with(String string) {
        men.Select_end_M_products(string);
    }

    @When("Add items to the cart")
    public void add_items_to_the_cart() {
        tcs.generic.DriverW(cart.getAdd_cart());
        cart.Add_Cart();
    }

    @Then("verify the selected product has ending name with {string}")
    public void verify_the_selected_product_has_ending_name_with(String string) {
        cart.Verify_M_Products(string);
    }
}
