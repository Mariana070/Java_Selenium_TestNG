package com.test.blaze.test;

import com.test.blaze.page.BlazeHomePage;
import com.test.blaze.page.BlazeLaptopsPage;
import com.test.blaze.page.BlazeMacBookProPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BlazeMacBookProTest extends BlazeTestBase{
    @Parameters({"choice","laptopBrand","expectedTitle","expectedLaptopPrice","expectedDescriptions","expectedAlertMessage"})

    @Test
    public void validateMacBookProInfo(String choice,String laptopBrand,String expectedTitle,String expectedLaptopPrice,
                                       String expectedDescriptions, String expectedAlertMessage)
            throws InterruptedException {
        BlazeHomePage blazeHomePage=new BlazeHomePage(driver);
        blazeHomePage.choseCategory(choice);
        BlazeLaptopsPage blazeLaptopsPage=new BlazeLaptopsPage(driver);
        blazeLaptopsPage.choseLaptopBrand(laptopBrand);
        BlazeMacBookProPage blazeMacBookProPage =new BlazeMacBookProPage(driver);
        blazeMacBookProPage.laptopInformation(expectedTitle,expectedLaptopPrice,expectedDescriptions);
        blazeMacBookProPage.clickAddToCart(driver,expectedAlertMessage);

    }



}

