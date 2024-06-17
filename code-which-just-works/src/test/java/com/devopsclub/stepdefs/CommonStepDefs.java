package com.devopsclub.stepdefs;

import com.devopsclub.contexts.ScnContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import lombok.extern.log4j.Log4j2;
import java.net.MalformedURLException;
import java.util.Properties;

@Log4j2
public class CommonStepDefs {

    Scenario scenario;
    ScnContext scnContext;
    Properties properties;

    public CommonStepDefs(ScnContext scnContext){
        this.scnContext = scnContext;
        this.properties = scnContext.getProperties();
    }

    @Before(order = 1)
    public void setUp(Scenario s){
        this.scenario = s;
        this.scnContext.setScenario(s);
    }

    @Before(order = 2)
    public void invokeBrowserBeforeEachStep() throws MalformedURLException {
        scnContext.invokeDriver();
    }

    @After
    public void tearDownAndTakeScreenShotIfFailed(Scenario s){
        if (s.isFailed() && properties.getProperty("screen_shot_strategy").equalsIgnoreCase("on_failure")){
            scnContext.takeScreenshotAndAttachWithReport();
            log.debug("Screenshot taken for the failed scenario: "+s.getName());
        }
        scnContext.quitDriver();
        log.debug("Scenario: "+s.getName()+" is completed. Browser Closed");
    }

    @AfterStep
    public void shouldTakeScreenShotAfterEachStep(Scenario scenario){
        if (properties.getProperty("screen_shot_strategy").equalsIgnoreCase("after_each_step")){
            scnContext.takeScreenshotAndAttachWithReport();
            log.debug("Screenshot taken after  step");
        }
    }

    @AfterStep
    public void pauseAfterEachStep() throws InterruptedException {
        Thread.sleep(Long.parseLong(properties.getProperty("pause_after_each_step_in_seconds")));
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() throws MalformedURLException {
        scnContext.navigateBrowser(scnContext.getProperties().getProperty("app_url"));
        log.debug("Browser opened and navigated to the url: "+scnContext.getProperties().getProperty("app_url"));
    }


}
