package com.test.bank.pages;

import com.Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankCustomerPage {
    public BankCustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#userSelect")
    WebElement userSelectButton;
    @FindBy(xpath = "//button[.='Login']")
    WebElement selectLoginButton;
    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;
    @FindBy (tagName = "input")
    WebElement amountConsole;
    @FindBy(xpath = "//button[.='Deposit']")
    WebElement depositButtonSubmit;
    @FindBy(xpath = "//span[.='Deposit Successful']")
    WebElement validateMessage;
    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawButton;
    @FindBy(xpath = "//button[.='Withdraw']")
    WebElement withdrawSubmit;
    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionsButton;
    @FindBy(xpath = "//strong[contains(text(),' Welcome ')]")
    WebElement header;
    @FindBy(xpath = "//span[.='Transaction successful']")
    WebElement successMessage;
    @FindBy(xpath = "//div[@class='center'//strong[2]")
    WebElement customerBalance;
    @FindBy (xpath = "//tr[@id='anchor0']//td[2]")
    WebElement credit;
    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement debit;



    public void loginFunctionality(String name,String expectedMessage) {
        BrowserUtils.selectBy(userSelectButton,name,"text");
        selectLoginButton.click();
        Assert.assertEquals(BrowserUtils.getText(header),expectedMessage);
    }
    public void depositFunctionality(String depositAmount,String expectedMessage){
        depositButton.click();
        amountConsole.sendKeys(depositAmount);
        depositButtonSubmit.click();
        Assert.assertEquals(BrowserUtils.getText(validateMessage),expectedMessage);
    }


    public  void withdrawFunctionality(String amount,String expectedWithdrawMessage) throws InterruptedException {
        withdrawButton.click();
        Thread.sleep(1000);
        amountConsole.sendKeys(amount);
        withdrawSubmit.click();
        Assert.assertEquals(BrowserUtils.getText(successMessage),expectedWithdrawMessage);
        transactionsButton.click();
    }

}
