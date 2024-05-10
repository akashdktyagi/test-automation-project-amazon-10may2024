package org.thedevopsclub.contexts;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.thedevopsclub.core.BrowserFactory;

import java.util.Properties;

@Data
@Log4j2
public class ScnContext {
    @Getter
    WebDriver driver;

    @Getter
    Properties myProperties = new Properties();

    public ScnContext() {
        readConfig();
    }

    public void invokeDriver(String browser) {
        driver = BrowserFactory.createInstance(browser, "");
        driver.manage().window().maximize();
        log.debug("Chrome browser Opened.");
    }

    public void navigateBrowser(String url) {
        driver.get(url);
        log.debug("browser navigated: " + url);
    }

    public void quitDriver() {
        driver.quit();
        log.debug("Driver quit success");
    }

    public void readConfig() {
        try {
            myProperties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


