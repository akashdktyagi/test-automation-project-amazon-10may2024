package com.devopsclub.runner;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"classpath:features"},
        glue = {"com.devopsclub.stepdefs"},
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        tags = "@smoke"
)
public class RunTest extends AbstractTestNGCucumberTests{

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}