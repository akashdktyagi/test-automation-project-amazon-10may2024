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


}
