package com.test.blaze.test;

import com.test.blaze.page.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BlazeCartTest extends BlazeTestBase {
    @Parameters({"choice","laptopBrand","expectedAlertMessage","expectedTitle","expectedLaptopPrice"})
    @Test
    public void validateCartItem(String choice, String laptopBrand, String expectedAlertMessage, String expectedTitle, String expectedLaptopPrice) throws InterruptedException {
        com.test.blaze.page.BlazeHomePage blazeHomePage = new com.test.blaze.page.BlazeHomePage(driver);
        blazeHomePage.choseCategory(choice);
        com.test.blaze.page.BlazeLaptopsPage blazeLaptopsPage = new com.test.blaze.page.BlazeLaptopsPage(driver);
        blazeLaptopsPage.choseLaptopBrand(laptopBrand);
        com.test.blaze.page.BlazeMacBookProPage blazeMacBookProPage = new com.test.blaze.page.BlazeMacBookProPage(driver);
        blazeMacBookProPage.clickAddToCart(driver, expectedAlertMessage);
        blazeHomePage.clickCartButton();
        com.test.blaze.page.BlazeCartPage blazeCartPage = new com.test.blaze.page.BlazeCartPage(driver);
        blazeCartPage.getInfoFromCart(expectedTitle, expectedLaptopPrice);
        blazeCartPage.clickPlaceOrderButton();

    }
}