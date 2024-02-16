package com.test.saucedemo.SauceDemoTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

public class AllData {
    //    public AllData(WebDriver driver){
//        PageFactory.initElements(driver,this);
//    }
    @DataProvider(name = "positiveLogin")
    public Object[][] getData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"},
                {"problem_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"},
                {"performance_glitch_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"}
        };
    }

    @DataProvider(name = "negativeLogin")
    public Object[][] getDataNegative() {
        return new Object[][]{
                {"wrongUserName", "wrongPassword", "Epic sadface: Username and password do not match any user in this service"},
                {"", "wrongPassword", "Epic sadface: Username is required"},
                {"wrongUserName", "", "Epic sadface: Password is required"},
                {"", "", "Epic sadface: Username is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @DataProvider(name = "productDetails")
    public Object[][] getDataProductDetails() {
        return new Object[][]{
                {"Sauce Labs Backpack","Sauce Labs Backpack","Sly Pack", "$29.99"},
                {"Sauce Labs Bike Light","Sauce Labs Bike Light", "lighting modes", "$9.99"},
                {"Sauce Labs Bolt T-Shirt","Sauce Labs Bolt T-Shirt","American Apparel","$15.99"},
                {"Sauce Labs Fleece Jacket","Sauce Labs Fleece Jacket","jacket capable","$49.99"},
                {"Sauce Labs Onesie","Sauce Labs Onesie","Rib snap","$7.99"},
                {"Test.allTheThings() T-Shirt (Red)","Test.allTheThings() T-Shirt (Red)","Sauce Labs t-shirt","$15.99"}
        };
    }
}
