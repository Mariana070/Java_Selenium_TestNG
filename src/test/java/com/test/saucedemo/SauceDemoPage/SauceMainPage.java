package com.test.saucedemo.SauceDemoPage;


import com.Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SauceMainPage {
    public SauceMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".inventory_item_name")
    List<WebElement> nameOfProducts;
    @FindBy(css = ".inventory_details_name")
    private WebElement nameOfEachProduct;
    @FindBy(css = ".inventory_details_desc")
    private WebElement description;
    @FindBy(xpath = "//div[contains(@class,'details_price')]")
    private WebElement price;
    @FindBy(css = "#back-to-products")
    private WebElement backButton;


    public void chooseItem(String item) {
        for (WebElement title : nameOfProducts) {
            if (BrowserUtils.getText(title).equals(item)) {
                title.click();
                break;
            }
        }
    }

    public void validateProductInformation(String expectedHeader, String expectedDescription, String expectedPrice) {
        Assert.assertEquals(BrowserUtils.getText(nameOfEachProduct), expectedHeader);
        Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDescription));
        Assert.assertTrue(BrowserUtils.getText(price).contains(expectedPrice));
    }
}