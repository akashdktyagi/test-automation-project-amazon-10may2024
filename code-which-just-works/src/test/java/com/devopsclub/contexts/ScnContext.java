package com.devopsclub.contexts;

import com.devopsclub.core.BrowserFactory;
import io.cucumber.java.Scenario;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

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

    public void invokeDriver() {
        this.driver = browserFactory.createInstance("chrome", "local");
        this.driver.manage().window().maximize();
    }

    public void navigateBrowser(String url) {
        this.driver.get(url);
    }

    public void quitDriver() {
        this.driver.quit();
    }

    public void readConfig() {
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
