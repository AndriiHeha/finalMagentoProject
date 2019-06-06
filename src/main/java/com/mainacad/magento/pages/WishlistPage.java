package com.mainacad.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class WishlistPage extends BasePage {

    private static By elementProductWishList = By.xpath("//*[@id=\"wishlist-table\"]/tbody");
    private static By elementItemInProductWishList = By.tagName("tr");
    private static By elementProductName = By.className("product-name");
    private static String productName = "";
    
    //*********Constructor*********
    public WishlistPage() {

        Assert.assertEquals(getDriver().getTitle(), "My Wishlist");
    }

    public WishlistPage checkIfProductAddedToWishList(){
        WebElement productWishList = getDriver().findElement(elementProductWishList);
        List<WebElement> allTrInProductWishList = productWishList.findElements(elementItemInProductWishList);
        for (WebElement element : allTrInProductWishList){
          if (ElectronicsPage.nameOfProduct.equals(element.findElement(elementProductName).getText())){
                productName = element.findElement(elementProductName).getText();
            }
        }
        System.out.println("Product added to Wish List: " + productName);
        Assert.assertEquals(ElectronicsPage.nameOfProduct, productName);
        return new WishlistPage();
    }
}
