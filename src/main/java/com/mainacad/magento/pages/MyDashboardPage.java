package com.mainacad.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MyDashboardPage extends BasePage {
    //*********Web Elements*********
    private static By myDashBoard = By.className("page-title");
    private static By helloUser = By.className("hello");
    private static By elementHomeDecor = By.xpath("//*[@id=\"nav\"]/ol/li[4]/a");
    private static By elementElectronics = By.xpath("//a[@href='http://magento.mainacad.com/english/home-decor/electronics.html']");

    //*********Constructor*********
    public MyDashboardPage() {

        Assert.assertEquals(getDriver().getTitle(), "My Account");
    }

    public MyDashboardPage checkNavigationOnMyDashboard(String firstName, String lastName) {
        getDriver().findElement(myDashBoard).isDisplayed();
        getDriver().findElement(helloUser).isDisplayed();
        Assert.assertEquals("Hello, " + firstName + " " + lastName + "!", getDriver().findElement(helloUser).getText());
        return this;
    }

    public HomeDecorPage goToHomeDecorPage(){
        getDriver().findElement(elementHomeDecor).click();
        return new HomeDecorPage();
    }

}
