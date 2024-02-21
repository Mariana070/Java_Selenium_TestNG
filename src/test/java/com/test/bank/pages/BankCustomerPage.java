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
    private WebElement userSelectButton;
    @FindBy(xpath = "//button[.='Login']")
    private WebElement selectLoginButton;
    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    private WebElement depositButton;
    @FindBy (tagName = "input")
    private WebElement amountConsole;
    @FindBy(xpath = "//button[.='Deposit']")
    private WebElement depositButtonSubmit;
    @FindBy(xpath = "//span[.='Deposit Successful']")
    private WebElement validateMessage;
    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    private WebElement withdrawButton;
    @FindBy(xpath = "//button[.='Withdraw']")
    private WebElement withdrawSubmit;
    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    private WebElement transactionsButton;
    @FindBy(xpath = "//strong[contains(text(),' Welcome ')]")
    private WebElement header;
    @FindBy(xpath = "//span[.='Transaction successful']")
    private WebElement successMessage;
    @FindBy(xpath = "//div[@class='center'//strong[2]")
    private WebElement customerBalance;
    @FindBy (xpath = "//tr[@id='anchor0']//td[2]")
    private WebElement credit;
    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    private WebElement debit;



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
