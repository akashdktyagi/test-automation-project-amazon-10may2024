package com.devopsclub.contexts;

import com.devopsclub.core.BrowserFactory;
import io.cucumber.java.Scenario;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.Properties;

@Log4j2
public class ScnContext {
    @Getter
    WebDriver driver;
    BrowserFactory browserFactory= new BrowserFactory();;

    @Getter
    Properties properties = new Properties();

    @Setter
    @Getter
    Scenario scenario;

    public ScnContext() {
        readConfig();
    }

    public void invokeDriver() throws MalformedURLException {
        this.driver = browserFactory.createInstance(properties.getProperty("browser_name"));
        this.driver.manage().window().maximize();
        log.info("Chrome browser Opened.");
    }

    public void navigateBrowser(String url) {
        this.driver.get(url);
        log.info("browser navigated: " + url);
    }

    public void quitDriver() {
        this.driver.quit();
        log.info("Driver quit success");
    }

    public void readConfig() {
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            log.debug("Config file read successfully");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to read config file");
        }
    }

    public void takeScreenshotAndAttachWithReport() {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
            log.info("Screenshot taken and attached to report");
        } catch (Exception e) {
            log.error("Failed to take screenshot");
            e.printStackTrace();
            Assert.fail("Failed to take screenshot");

        }
    }

}
