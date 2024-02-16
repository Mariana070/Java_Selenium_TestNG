package com.test.blaze.test;

import com.test.blaze.page.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BlazeOrderTest extends BlazeTestBase{
    @Parameters({"choice","laptopBrand","expectedAlertMessage","name","country","city","creditCard","month", "years","expectedMessage","url"})
    @Test
    public void validateOrderFunctionality(String choice, String laptopBrand, String expectedAlertMessage, String name, String country,
                                           String city, String creditCard, String month,String years, String expectedMessage,String url) throws InterruptedException {
        com.test.blaze.page.BlazeHomePage blazeHomePage = new com.test.blaze.page.BlazeHomePage(driver);
        blazeHomePage.choseCategory(choice);
        com.test.blaze.page.BlazeLaptopsPage blazeLaptopsPage = new com.test.blaze.page.BlazeLaptopsPage(driver);
        blazeLaptopsPage.choseLaptopBrand(laptopBrand);
        com.test.blaze.page.BlazeMacBookProPage blazeMacBookProPage = new com.test.blaze.page.BlazeMacBookProPage(driver);
        blazeMacBookProPage.clickAddToCart(driver, expectedAlertMessage);
        blazeHomePage.clickCartButton();
        com.test.blaze.page.BlazeCartPage blazeCartPage = new com.test.blaze.page.BlazeCartPage(driver);
        blazeCartPage.clickPlaceOrderButton();
        com.test.blaze.page.BlazeOrderPage blazeOrderPage = new com.test.blaze.page.BlazeOrderPage(driver);
        blazeOrderPage.orderFunctionality(name, country,city,creditCard,month,years,expectedMessage);
        Assert.assertEquals(driver.getCurrentUrl().trim(), url);
    }


}
