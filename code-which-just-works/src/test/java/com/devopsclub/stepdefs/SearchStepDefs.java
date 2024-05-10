package com.devopsclub.stepdefs;

import com.devopsclub.contexts.ScnContext;
import com.devopsclub.po.CommonPageObjects;
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

    @When("I search for {string}")
    public void i_search_for(String product) {
        commonPageObjects.searchProduct(product);
    }

    @Then("I should see a list of products that contain the word {string}")
    public void i_should_see_a_list_of_products_that_contain_the_word(String productName) {
        commonPageObjects.checkIfSearchIsSuccessfull(productName);
    }
}
