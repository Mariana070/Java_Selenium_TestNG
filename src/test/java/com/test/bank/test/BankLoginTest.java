package com.test.bank.test;

import com.test.bank.pages.BankLoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class BankLoginTest  extends BankTestBase{
    @Parameters("expectedHeader")
    @Test
    public void validateLoginPageComponents(String expectedHeader){
        BankLoginPage bankLoginPage= new BankLoginPage(driver);
        bankLoginPage.LoginPageComponentsValidation(expectedHeader);

    }


}
