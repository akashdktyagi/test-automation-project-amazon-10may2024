package com.devopsclub.stepdefs;

import com.devopsclub.contexts.ScnContext;
import com.devopsclub.po.SearchPageObjects;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Properties;

public class AddToCartStepDefs {

    ScnContext scnContext;
    Properties properties;

    SearchPageObjects searchPageObjects;

    public AddToCartStepDefs(ScnContext scnContext) {
        this.scnContext = scnContext;
        this.properties = scnContext.getProperties();
        searchPageObjects = new SearchPageObjects(scnContext.getDriver());
    }

    @When("I add top two products in the cart")
    public void i_add_top_two_products_in_the_cart() {
        searchPageObjects.clickAddToCartButton();
    }

    @Then("Cart icon on the top right corner is updated with the count as {int}")
    public void cart_icon_on_the_top_right_corner_is_updated_with_the_count_as(Integer int1) {

    }

    @Then("total amount of the two product is displayed in the side bar")
    public void total_amount_of_the_two_product_is_displayed_in_the_side_bar() {

    }

}
