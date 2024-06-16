package com.devopsclub.stepdefs;

import com.devopsclub.contexts.ScnContext;
import com.devopsclub.po.CommonPageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class GoogleSearchStepDefs {

    ScnContext scnContext;

    CommonPageObjects commonPageObjects;

    public GoogleSearchStepDefs(ScnContext scnContext){
        this.scnContext = scnContext;
    }

    @Given("I open Google")
    public void i_open_google() {
        scnContext.navigateBrowser("https://www.google.com");
    }

    @When("I search for {string}")
    public void i_search_for(String string) {
        WebDriver driver = scnContext.getDriver();
        driver.findElement(By.name("q")).sendKeys(string);
        driver.findElement(By.name("btnK")).submit();
//
//        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        webDriverWait.until(x -> driver.getTitle().toLowerCase().contains(string));
    }

    @Then("the page title should start with {string}")
    public void the_page_title_should_start_with(String string) {
        String title = scnContext.getDriver().getTitle();
        Assertions.assertThat(title).contains(string);
    }

}
