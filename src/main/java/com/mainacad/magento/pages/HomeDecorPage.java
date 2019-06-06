package com.mainacad.magento.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HomeDecorPage extends BasePage {
    //*********Web Elements*********
    private static By elementElectronics = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/ul/li[3]/a/img");

    //*********Constructor*********
    public HomeDecorPage() {
        Assert.assertEquals(getDriver().getTitle(), "Home & Decor");
    }
    //*********** Go To Electronics Page *************
    public ElectronicsPage goToElectronicsPage() {
        getDriver().findElement(elementElectronics).click();
        return new ElectronicsPage();
    }
}
