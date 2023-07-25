package StepDefinitions;

import PageObjects.*;
import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Scenario2StepDefinition {


    TestContextSetup tcs;
    public LoginPage login;
    public HomePage home;
    public ApparelPage apparel;
    public TshirtsPage tshirt;
    public CartPage cart;
    public ShoesPage shoes;

    public Scenario2StepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
        login=tcs.pageobjectmanager.GetLoginPage();
        home=tcs.pageobjectmanager.GetHomePage();
        apparel=tcs.pageobjectmanager.GetApparelPage();
        tshirt=tcs.pageobjectmanager.GetTshirtPage();
        cart=tcs.pageobjectmanager.GetCartPage();
        shoes=tcs.pageobjectmanager.GetShoesPage();
    }

    @When("User navigates to Apparel page")
    public void user_navigates_to_apparel_page() {
        home.Navigate_Apparel();
    }
    @When("Then navigates to tshirts page")
    public void then_navigates_to_tshirts_page() {
        apparel.Navigate_Tshirts();
    }
    @When("User sort elements from {string}")
    public void user_sort_elements_from_low_to_high(String filter) {
        tshirt.Sort_Items(filter);
    }
    @When("Selects top {int} lowest t-shirts and add it to cart")
    public void selects_top_lowest_the_t_shirts_and_add_it_to_cart(Integer int1) {
        tshirt.Get_TshirtsItems();
        tshirt.Add_Items(int1, cart);
    }

    @When("Go back to Apparels section")
    public void go_back_to_apparels_section() {
        tshirt.Navigate_Back(home);
    }
    @When("Navigate to Shoes Page")
    public void navigate_to_shoes_page() {
        apparel.Navigate_Shoes();
    }
    @When("Add highest price product in cart")
    public void add_highest_price_product_in_cart() {
        shoes.Add_highest_product(tshirt);
    }
    @When("Select quantity {string} and proceed")
    public void select_quantity_and_proceed(String string) {
        shoes.Set_Shoes_Quantity_Proceed(string);
    }
    @Then("Verify the {string} items in cart")
    public void verify_the_items_in_cart(String string) {
        cart.Verify_products(string);
    }
}
