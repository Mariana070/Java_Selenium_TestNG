package com.test.bank.pages;

import com.Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankLoginPage {
    public BankLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);//it does same logic of driver.findElement
    }
    @FindBy(css=".mainHeading")
    private WebElement header;
    @FindBy(xpath = "//button[.='Customer Login']")
    private WebElement customerLoging;
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    private WebElement managerLogin;


    public void LoginPageComponentsValidation(String expectedHeader){
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertTrue(customerLoging.isDisplayed()&&customerLoging.isEnabled());
        Assert.assertTrue(managerLogin.isDisplayed()&&managerLogin.isEnabled());
    }
    public void clickManagerButton(){
        managerLogin.click();
    }
    public  void clickCustomerLoginButton(){
        customerLoging.click();
    }


}
