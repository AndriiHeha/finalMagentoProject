package com.mainacad.magento.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ElectronicsPage extends BasePage {
    //*********Web Elements*********
    private static By elementListAll = By.className("list");
    private static By elementDropDownShow = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/select");
    private static By elementProductList = By.cssSelector("#products-list");
    private static By allElementsInProductList = By.tagName("li");
    private static By elementItemCounter = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/p/strong");




    //*********Constructor*********
    public ElectronicsPage() {
        Assert.assertEquals("Electronics - Home & Decor", driver.getTitle());
    }

    public ElectronicsPage clickShowAsList(){
        driver.findElement(elementListAll).click();
        return this;
    }
    public ElectronicsPage select25RecordstoShow(){
        driver.findElement(elementDropDownShow).click();
        Select selectLanguageAuto = new Select(driver.findElement(elementDropDownShow));
        selectLanguageAuto.selectByVisibleText("25");
        return this;
    }
    public ElectronicsPage shownProductList(){
        WebElement productList = driver.findElement(elementProductList);
        List<WebElement> allLiElementsinTheList = productList.findElements(allElementsInProductList);

        String productRecordsAmount = Integer.toString(allLiElementsinTheList.size());
        String itemCounter = driver.findElement(elementItemCounter).getText();

        if(itemCounter.contains(" ")) {
            itemCounter = itemCounter.substring(0, itemCounter.indexOf(" "));
        }
        Assert.assertEquals(productRecordsAmount,itemCounter);

        System.out.println("itemCounter = " + itemCounter);
        System.out.println("ProductrRecords = " + productRecordsAmount);

        return this;
    }

}
