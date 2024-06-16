package com.devopsclub.stepdefs;

import com.devopsclub.contexts.ScnContext;
import com.devopsclub.po.CommonPageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SearchStepDefs {

    ScnContext scnContext;
    CommonPageObjects commonPageObjects;

    public SearchStepDefs(ScnContext scnContext){
        this.scnContext = scnContext;
        commonPageObjects = new CommonPageObjects(scnContext.getDriver());
    }

    @Given("I am on a search page for product {string}")
    public void i_am_on_a_search_page_for_product(String productName) {
        i_search_for(productName);
        i_should_see_a_list_of_products_that_contain_the_word(productName);
    }

    @When("I search for {string} in top search bar")
    public void i_search_for(String product) {
        commonPageObjects.searchProduct(product);
        log.info("Searching for the product: " + product);
    }

    @Then("I should see a list of products that contain the word {string}")
    public void i_should_see_a_list_of_products_that_contain_the_word(String productName) {
        commonPageObjects.checkIfSearchIsSuccessfull(productName);
    }

    @When("I select the search category as {string}")
    public void i_select_the_search_category_as(String string) {
        commonPageObjects.selectCategory(string);
    }
    @Then("I should see a list of products that contain the word {string} and are from the category {string}")
    public void i_should_see_a_list_of_products_that_contain_the_word_and_are_from_the_category(String brandName, String brandName2) {
        commonPageObjects.checkIfSearchIsSuccessfull(brandName);
    }


}
