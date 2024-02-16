package com.test.saucedemo.SauceDemoTests;
import com.Utils.ConfigReader;
import com.test.saucedemo.SauceDemoPage.SauceDemoLoginPage;
import com.test.saucedemo.SauceDemoPage.SauceMainPage;
import org.testng.annotations.Test;

public class SauceMainTest extends SauceDemoBaseTest {
    @Test(dataProvider = "productDetails",dataProviderClass = AllData.class)
    public void validateProductFunctionality(String item,String expectedHeader,String expectedDescr, String expectedPrice) throws InterruptedException {
        SauceDemoLoginPage sauceDemoLoginPage=new SauceDemoLoginPage(driver);
        sauceDemoLoginPage.loginSuccessfully(ConfigReader.readProperty("QA_saucedemo_userName"),
                ConfigReader.readProperty("QA_saucedemo_password"));
        SauceMainPage sauceMainPage = new SauceMainPage(driver);
        sauceMainPage.chooseItem(item);
        sauceMainPage.validateProductInformation(expectedHeader,expectedDescr,expectedPrice);
    }
}
