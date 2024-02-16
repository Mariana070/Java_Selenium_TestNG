package com.test.bank.test;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BankManagerTest extends BankTestBase{
    @Parameters({"managerFirstName","managerLastName","managerCode","managerExpectedMassager"})
    @Test()
    public void validateAddCustomerFunctionality(String managerFirstName,String managerLastName,String managerCode, String managerExpectedMassager){
        BankLoginPage loginPage=new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver,managerFirstName,managerLastName,managerCode,managerExpectedMassager);
    }

    @Parameters({"firstUserName","lastUserName","postCode","confirmationMessage","managerCustomerName","managerCurrencyDollar","managerAccountMassage"})
    @Test()
    public void validateOpenAccountFunctionality(String firstUserName, String lastUserName,String postCode, String confirmationMessage,
                                                 String managerCustomerName,String managerCurrencyDollar,String managerAccountMassage){

        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver,firstUserName,lastUserName, postCode,confirmationMessage  );
        bankManagerPage.OpenAccountFunctionality(driver,managerCustomerName, managerCurrencyDollar,managerAccountMassage);
    }

    @Parameters({"customerName","CustomerLastName","customerCode","customerMassage","AccountCustomerName","accountCurrency","accountMessage",
            "customerFunName","customerFunLastName","customerFunCode"})
    @Test()
    public void validateCustomerFunctionality(String customerName,String CustomerLastName,String customerCode,String customerMassage,
                                              String AccountCustomerName,String accountCurrency,String accountMessage,
                                              String customerFunName,String customerFunLastName,String customerFunCode){

        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver,customerName,CustomerLastName,customerCode,customerMassage);
        bankManagerPage.OpenAccountFunctionality(driver,AccountCustomerName, accountCurrency,accountMessage);
        bankManagerPage.customerFunctionality(customerFunName,customerFunLastName,customerFunCode);

    }
}
