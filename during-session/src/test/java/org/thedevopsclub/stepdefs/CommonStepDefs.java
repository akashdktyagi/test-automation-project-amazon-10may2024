package org.thedevopsclub.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.thedevopsclub.contexts.ScnContext;
import org.thedevopsclub.core.BrowserFactory;


public class CommonStepDefs {

    ScnContext scnContext;

    public CommonStepDefs(ScnContext scnContext){
        this.scnContext = scnContext;
    }

    @Before
    public void setUp() {
        scnContext.invokeDriver("chrome");
        System.out.println("Driver invoked");
    }

    @After
    public void tearDown() {
//        scnContext.quitDriver();
    }

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        String url = scnContext.getMyProperties().getProperty("sit.appUrl");
        scnContext.navigateBrowser(url);
    }


}
