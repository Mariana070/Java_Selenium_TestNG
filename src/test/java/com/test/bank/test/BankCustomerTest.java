package com.test.bank.test;

import com.test.bank.pages.BankCustomerPage;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BankCustomerTest extends BankTestBase{
    @Parameters({"firstName","lastName","code","CustomerExpectedMessage","BankName","currencyDollar","expectedAccountMessage","customerName",
            "customerLastname","customerCode","loginName","loginExpectedMessage","depositAmount","depositExpectedMessage","amount","expectedWithdrawMessage"})
    @Test
    public void validateCustomerLoginTransactions(String firstName,String lastName, String code,String CustomerExpectedMessage,String BankName,
                                                  String currencyDollar,String expectedAccountMessage,
                                                  String customerName,String customerLastname,String customerCode,
                                                  String loginName,String loginExpectedMessage,
                                                  String depositAmount,String depositExpectedMessage,
                                                  String amount,String expectedWithdrawMessage) throws InterruptedException {
        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver,firstName,lastName,code,CustomerExpectedMessage);
        bankManagerPage.OpenAccountFunctionality(driver,BankName, currencyDollar,expectedAccountMessage);
        bankManagerPage.customerFunctionality( customerName,customerLastname,customerCode);
        bankManagerPage.clickHomeButton();
        loginPage.clickCustomerLoginButton();
        BankCustomerPage bankCustomerPage=new BankCustomerPage(driver);
        bankCustomerPage.loginFunctionality(loginName,loginExpectedMessage);
        bankCustomerPage.depositFunctionality(depositAmount,depositExpectedMessage);
        bankCustomerPage.withdrawFunctionality(amount,expectedWithdrawMessage);


    }

}

