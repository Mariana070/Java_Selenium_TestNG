package com.test.saucedemo.SauceDemoTests;
import com.Utils.BrowserUtils;
import com.Utils.ConfigReader;
import com.Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SauceDemoBaseTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("QA_saucedemo_url"));
    }
    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver ,"sauceDemo");
        }
        //driver.quit();
    }
}
