package com.test.blaze.page;

import com.Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BlazeCartPage {

    public BlazeCartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//td")
    List<WebElement> productInfo;
    @FindBy(xpath = "//button[contains(text(),'Place Order')]")
    private WebElement placeOrderButton;

    public void getInfoFromCart(String expectedTitle, String expectedPrice){
        List<String> expectedInfo= Arrays.asList("",expectedTitle,expectedPrice,"");
        for (int i = 1; i < productInfo.size()-1; i++) {
            Assert.assertEquals(BrowserUtils.getText(productInfo.get(i)),expectedInfo.get(i));
        }
    }
    public void clickPlaceOrderButton(){

        placeOrderButton.click();
    }
}
