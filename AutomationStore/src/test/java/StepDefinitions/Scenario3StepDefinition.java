package StepDefinitions;

import PageObjects.*;
import Utils.TestContextSetup;
import io.cucumber.java.en.*;

public class Scenario3StepDefinition {

    TestContextSetup tcs;
    public HomePage home;
    public SkinCarePage skin;
    public CartPage cart;
    int items;

    public Scenario3StepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
        home=tcs.pageobjectmanager.GetHomePage();
        skin=tcs.pageobjectmanager.GetSkinCarePage();
        cart=tcs.pageobjectmanager.GetCartPage();
    }

    @When("User navigates to skin care section")
    public void user_navigates_to_skin_care_section() {
        home.Navigate_SkinCare_Page();
    }
    @When("checks how many items are on Sale")
    public void checks_how_many_items_are_on() {
        skin.Get_Sale_Items();
    }
    @When("checks how many items are Out of Stock")
    public void checks_how_many_items_are() {
        skin.Get_Out_of_Stock();
    }
    @When("Add the {string} items in cart")
    public void add_the_items_in_cart(String string) {
        items=skin.Add_items();
    }
    @Then("verify the selected items count")
    public void verify_the_selected_items_count_are() throws InterruptedException {
        cart.Verify_sale_items(items);
    }
}
