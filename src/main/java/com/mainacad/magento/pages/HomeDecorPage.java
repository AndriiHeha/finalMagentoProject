package com.mainacad.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomeDecorPage extends BasePage {
    //*********Web Elements*********
    private static By elementElectronics = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/ul/li[3]/a/img");

    private static By elementListAll = By.className("list");
    private static By dropDownShow = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/select");
    private static By loginButton = By.name("send");
    private static By myDashBoard = By.className("page-title");
    private static By helloUser = By.className("hello");
    private static By successRegistrationMsg = By.className("success-msg");

    //*********Constructor*********
    public HomeDecorPage() {
        Assert.assertEquals("Home & Decor", driver.getTitle());
    }
    //*********** Go To Electronics Page *************
    public ElectronicsPage goToElectronicsPage() {
        driver.findElement(elementElectronics).click();
        return new ElectronicsPage();
    }
}
