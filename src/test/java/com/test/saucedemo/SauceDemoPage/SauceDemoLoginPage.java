package com.test.saucedemo.SauceDemoPage;


import com.Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SauceDemoLoginPage {
    public SauceDemoLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#user-name")
    private WebElement userName;
    @FindBy (css = "#password")
    private WebElement password;
    @FindBy(css = "#login-button")
    private WebElement loginButton;
    @FindBy(xpath = "//h3")
    private WebElement errorMessage;

    public void Login(String userName,String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
    }
    public String errorMessage(){
        return BrowserUtils.getText(errorMessage);
    }
    public void loginSuccessfully(String userName,String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
    }
}
