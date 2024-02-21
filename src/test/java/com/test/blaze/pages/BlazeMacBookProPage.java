package com.test.blaze.page;

import com.Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BlazeMacBookProPage {
    public BlazeMacBookProPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h2")
    private WebElement header;
    @FindBy(xpath = "//h3")
    private WebElement price;
    @FindBy(xpath = "//div[@id='myTabContent']")
    private WebElement descriptions;
    @FindBy(xpath = "//a[.='Add to cart']")
    private WebElement addToCardButton;
    public void laptopInformation(String expectedHeader,String expectedPrice,String expectedDescriptions){
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        Assert.assertEquals(BrowserUtils.getText(price),expectedPrice);
        Assert.assertEquals(BrowserUtils.getText(descriptions),expectedDescriptions.trim());
    }
    public void clickAddToCart(WebDriver driver,String expectedAlertMessage){
        addToCardButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),expectedAlertMessage);
        alert.accept();
    }

}

