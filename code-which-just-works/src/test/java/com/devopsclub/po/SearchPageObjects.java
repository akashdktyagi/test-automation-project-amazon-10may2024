package com.devopsclub.po;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageObjects {
    
    WebDriver driver;

    @FindBy(xpath = "//button[contains(@id, 'a-autoid-1-announce')]")
    public WebElement addToCartButton;

    public SearchPageObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }
    
}
