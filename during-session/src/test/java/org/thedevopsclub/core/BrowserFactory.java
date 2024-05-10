package org.thedevopsclub.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class BrowserFactory {

    public static WebDriver createInstance(String browserName, String execType) {
        WebDriver driver=null;

        switch (browserName.trim().toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;

//            case "CHROM_GRID":
//                driver = RemoteWebDriver(URL)
            default:
                Assert.fail("No Such Browser Avaialble.");
        }
        return driver;
    }
}
