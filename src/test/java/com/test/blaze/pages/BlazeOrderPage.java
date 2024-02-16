package com.test.blaze.page;

import com.Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlazeOrderPage {
    public BlazeOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#name")
    WebElement name;
    @FindBy(css = "#country")
    WebElement country;
    @FindBy(css = "#city")
    WebElement city;
    @FindBy(css = "#card")
    WebElement card;
    @FindBy(css = "#month")
    WebElement month;
    @FindBy(css = "#year")
    WebElement years;
    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;
    @FindBy(xpath = "//h2[contains(text(),'Thank you for your purchase!')]")
    WebElement validateMessage;
    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public void orderFunctionality(String name,String country,String city,String creditCard,String month,String years, String expectedMessage){
        this.name.sendKeys(name);
        this.country.sendKeys(country);
        this.city.sendKeys(city);
        this.card.sendKeys(creditCard);
        this.month.sendKeys(month);
        this.years.sendKeys(years);
        purchaseButton.click();
        Assert.assertEquals(BrowserUtils.getText(validateMessage),expectedMessage);
        okButton.click();
    }

}

