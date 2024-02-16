package com.test.blaze.page;



import com.Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BlazeLaptopsPage {
    public BlazeLaptopsPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//a[@class='hrefch']")
    List<WebElement> allLaptops;


    public void choseLaptopBrand(String brand) throws InterruptedException {
        for(WebElement laptop: allLaptops){
            if(BrowserUtils.getText(laptop).contains(brand)){
                laptop.click();
                break;
            }
        }

    }




}

