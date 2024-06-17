package com.devopsclub.core;

import com.devopsclub.contexts.ScnContext;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.HasCasting;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

@Log4j2
public class BrowserFactory {
    public static WebDriver createInstance(String browserName) throws MalformedURLException {
        WebDriver driver=null;
        ScnContext scnContext = new ScnContext();
        Properties properties = scnContext.getProperties();
        switch (browserName.trim().toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome_grid":
                URL hubUrl = new URL(properties.getProperty("grid_url"));
                ChromeOptions options = new ChromeOptions();
                driver = new RemoteWebDriver(hubUrl, options);
                break;
            default:
                Assert.fail("No Such Browser Avaialble.");
        }
        log.debug("Browser created successfully. browserName: " + browserName);
        return driver;
    }
}
