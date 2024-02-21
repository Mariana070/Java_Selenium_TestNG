package com.test.bank.pages;

import com.Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.Arrays;
import java.util.List;

public class BankManagerPage {

    public BankManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    private WebElement  addCustomerButton;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    private WebElement code;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitAddCustomerButton;
    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    private WebElement openAccountButton;
    @FindBy(css = "#userSelect")
    private WebElement customerName;
    @FindBy(css = "#currency")
    private WebElement currency;
    @FindBy(xpath = "//button[.='Process']")
    private WebElement processButton;
    @FindBy(xpath ="//button[contains(text(),'Customers')]")
    private WebElement customerButton;
    @FindBy(tagName  ="input")
    private WebElement searchBox;
    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement> allInformation;
    @FindBy(xpath = "//button[@class='btn home']")
    private WebElement homeButton;

    public void addCustomerFunctionality(WebDriver driver,String firstName,String lastName,String code,String expectedMessage){
        addCustomerButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.code.sendKeys(code);
        submitAddCustomerButton.submit();
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }
    public void OpenAccountFunctionality(WebDriver driver,String name,String currency,String expectedMessage){
        openAccountButton.click();
        BrowserUtils.selectBy(customerName,name,"text");
        BrowserUtils.selectBy(this.currency,currency,"value");
        processButton.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().trim().contains(expectedMessage));
        alert.accept();
    }
    public void customerFunctionality(String customerName,String lastName,String code){
        customerButton.click();
        searchBox.sendKeys(customerName);
        List<String> expectedNames= Arrays.asList(customerName,lastName,code);
        for (int i = 0; i < allInformation.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedNames.get(i));

        }
    }
    public void clickHomeButton(){
        homeButton.click();
    }



}

