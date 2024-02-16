package com.test.saucedemo.SauceDemoTests;

import com.test.saucedemo.SauceDemoPage.SauceDemoLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceLoginTest extends SauceDemoBaseTest{
    @Test(dataProvider="positiveLogin", dataProviderClass = AllData.class)
    public void validateSuccessfulLogin(String userName,String password,String url){
        SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage(driver);
        sauceDemoLoginPage.Login(userName,password);
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
    @Test(dataProvider="negativeLogin", dataProviderClass = AllData.class)
    public void validateNegativeLogin(String userName,String password,String expectedMessage){
        SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage(driver);
        sauceDemoLoginPage.Login(userName,password);
        Assert.assertEquals(sauceDemoLoginPage.errorMessage(),expectedMessage);
    }
}
