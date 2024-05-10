package com.devopsclub.stepdefs;

import com.devopsclub.contexts.ScnContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CommonStepDefs {

    Scenario scenario;
    ScnContext scnContext;

    public CommonStepDefs(ScnContext scnContext){
        this.scnContext = scnContext;
    }
    @Before
    public void setUp(Scenario s){
        scnContext.setScenario(s);
    }

    @After
    public void tearDown(Scenario s){
        scnContext.quitDriver();
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        scnContext.invokeDriver();
        scnContext.navigateBrowser(scnContext.getProperties().getProperty("appURL"));
    }

}
