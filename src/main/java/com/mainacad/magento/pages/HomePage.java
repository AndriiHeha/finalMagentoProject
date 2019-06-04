package com.mainacad.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage extends BasePage {

    //*********Web Elements*********
    private static By accountButtonBy = By.xpath("//*[@id=\"header\"]/div/div[2]/a[3]/span[2]");
    private static By loginBy = By.linkText("Log In");

    private static By languageAutomation = By.id("select-language");
    private static By elementHomeDecor = By.xpath("//*[@id=\"nav\"]/ol/li[4]/a");

    //*********Constructor*********
    public HomePage() {

        Assert.assertEquals(driver.getTitle(), "Madison Island");
    }
    //*********Page Methods*********
    //*********** Set Automation Language*******
    public HomePage setLanguageAutomation(String automationOption){
        driver.findElement(languageAutomation).click();
        Select selectLanguageAuto = new Select(driver.findElement(languageAutomation));
        selectLanguageAuto.selectByVisibleText(automationOption);
        return this;
    }
    //*********** Go To Home Decor Page *************
    public HomeDecorPage goToHomeDecorPage(){
        driver.findElement(elementHomeDecor).click();
        return new HomeDecorPage();
    }

/*
    //Go To Login Page
    public LoginPage goToLoginPage() throws InterruptedException {
        WebElement elementAccountButton = driver.findElement(accountButtonBy);
        BasePage.highlightElement(elementAccountButton);
        elementAccountButton.click();
        driver.findElement(loginBy).click();
        return new LoginPage();
    }
*/
}
