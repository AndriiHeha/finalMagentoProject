package com.mainacad.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage extends BasePage {

    //*********Web Elements*********
    private static By accountButtonBy = By.xpath("//a[@href='#header-account']");
    private static By loginBy = By.linkText("Log In");

    private static By languageAutomation = By.id("select-language");
    private static By elementHomeDecor = By.xpath("//*[@id=\"nav\"]/ol/li[4]/a");

    //*********Constructor*********
    public HomePage() {

        Assert.assertEquals(getDriver().getTitle(), "Madison Island");
    }
    //*********Page Methods*********
    //*********** Set Automation Language*******
    public HomePage setLanguageAutomation(String automationOption){
        getDriver().findElement(languageAutomation).click();
        Select selectLanguageAuto = new Select(getDriver().findElement(languageAutomation));
        selectLanguageAuto.selectByVisibleText(automationOption);
        return this;
    }

   //*********** Go To Home Decor Page *************
    public HomeDecorPage goToHomeDecorPage(){
        getDriver().findElement(elementHomeDecor).click();
        return new HomeDecorPage();
    }

    //Go To Login Page
    public LoginPage goToLoginPage() {
        getDriver().findElement(accountButtonBy).click();
        getDriver().findElement(loginBy).click();
        return new LoginPage();
    }



}
