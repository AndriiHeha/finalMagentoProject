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
    private static By elementProductList = By.id("products-list");
    private static By allElementsInProductList = By.className("product-image");
    private static By elementItemCounter = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/p/strong");
    private static By elementNextPagesButton = By.xpath("//*[@class='next i-next']");
    private static By listSizeSelection = By.xpath("//select[@title='Results per page'][1]");

    private static By elementSortBy = By.xpath("//select[@title='Sort By']");
    private static By elementRegularProductPrice = By.xpath("//span[@class='regular-price']/span[@class='price']");

    private static By elementShopByPrice = By.partialLinkText("$0.00 - $999.99");


    private static By elementFromProductPrice = By.xpath("//p[@class='price-from']/span[@class='price']");


    private static String productRecordsAmount;
    private static int productRecordsAmountInt;

    //*********Constructor*********
    public ElectronicsPage() {
        Assert.assertEquals(driver.getTitle(), "Electronics - Home & Decor");
    }

    //******Page Methods********
    public ElectronicsPage setNumberOfProducts(int numberOfProducts) {
        Select productSelect = new Select(driver.findElement(listSizeSelection));
        productSelect.selectByVisibleText(String.valueOf(numberOfProducts));
        return this;
    }

    // ********Amount of product counter******
    private int countNumberOfProducts() {
        return driver.findElement(elementProductList).findElements(allElementsInProductList).size();
    }

    public ElectronicsPage clickShowAsList() {
        driver.findElement(elementListAll).click();
        return this;
    }
    //******check price when Sort by is Price***********
    public ElectronicsPage checkPriceSortby() {
        WebElement productList = driver.findElement(elementProductList);
        List<WebElement> allPriceElementsOnTheList = productList.findElements(elementRegularProductPrice);
        int prevPrice = Integer.MIN_VALUE;
        for (WebElement element : allPriceElementsOnTheList) {
            String priceWithOutComma = element.getText().replaceAll(",", "");
            int priceAmount = Integer.parseInt(priceWithOutComma.substring(1, priceWithOutComma.length() - 3));

            if (priceAmount >= prevPrice) {
               // System.out.println("  priceAmount = " + priceAmount);
            } else {
                System.out.println("NOT SORTED : priceAmount = " + priceAmount);
                break;
            }
            prevPrice = priceAmount;
        }
        return this;
    }



    //******** Select 25 items to show on the page*************
    public ElectronicsPage selectTwentyFiveItemsToShow(int showTwentyFiveItemsOnPage) {
        driver.findElement(elementDropDownShow).click();
        Select selectLanguageAuto = new Select(driver.findElement(elementDropDownShow));
        selectLanguageAuto.selectByVisibleText(String.valueOf(showTwentyFiveItemsOnPage));
        return this;
    }

    //******** Amount of Products is shown on the page*************
    public ElectronicsPage showProductList() {
        WebElement productList = driver.findElement(elementProductList);
        List<WebElement> allLiElementsinTheList = productList.findElements(allElementsInProductList);
        productRecordsAmount = Integer.toString(allLiElementsinTheList.size());
        productRecordsAmountInt = allLiElementsinTheList.size();

        return this;
    }

    //**********Check amount of products on page when 25 items is selected*********
    public ElectronicsPage checkAmountOfProducts() {
        String itemCounter = driver.findElement(elementItemCounter).getText();
        if (itemCounter.contains(" ")) {
            itemCounter = itemCounter.substring(0, itemCounter.indexOf(" "));
        }
        Assert.assertEquals(productRecordsAmount, itemCounter);
        return this;
    }

    //**********Test Case 2 CheckShowSelect***************
    public ElectronicsPage testCaseTwoCheckShowSelect(int expectedAmount) {
        clickShowAsList();
        //********set to show 5 items on page ***********
        setNumberOfProducts(expectedAmount);
        //*******click on  pages and check if there are five items on it********
        while (driver.findElements(elementNextPagesButton).size() > 0) {
            Assert.assertEquals(countNumberOfProducts(), expectedAmount);
            driver.findElement(elementNextPagesButton).click();
        }
        Assert.assertTrue(countNumberOfProducts() <= expectedAmount);
        return this;
    }

    //**********Test Case 3 CheckSortBy***************
    public ElectronicsPage testCaseThreeCheckSortBy(int numberOfProductsToSet, String sortByPrice) {
        clickShowAsList();
        setNumberOfProducts(numberOfProductsToSet);

        Select selectSortByPrice = new Select(driver.findElement(elementSortBy));
        selectSortByPrice.selectByVisibleText(sortByPrice);
        Assert.assertEquals(showProductList(), checkAmountOfProducts());
        checkPriceSortby();
        return this;


    }
    //********** Test Case 4 Check Filter Price**********
    public ElectronicsPage testCaseFourCheckPriceFilter(int expectedAmount, int limitPrice){
        clickShowAsList();
        //********set to show 25 items on page ***********
        setNumberOfProducts(expectedAmount);
        driver.findElement(elementShopByPrice).click();
        //******check price of product less then 1000***********
        WebElement productList = driver.findElement(elementProductList);
        List<WebElement> allPriceElementsOnTheList = productList.findElements(elementRegularProductPrice);
            for (WebElement element : allPriceElementsOnTheList) {
                String priceWithOutComma = element.getText().replaceAll(",", "");
                int priceAmount = Integer.parseInt(priceWithOutComma.substring(1, priceWithOutComma.length() - 3));

                if (priceAmount < limitPrice) {
                    //System.out.println("  priceAmount = " + priceAmount);
                } else {
                    System.out.println("PRICE MORE THEN 1000 : priceAmount = " + priceAmount);
                    break;
                }
            }
            return this;
        }

}


