package com.mainacad.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoginPage extends BasePage {
    //*********Web Elements*********
    private static By userLoginName = By.id("email");
    private static By userPassword = By.id("pass");
    private static By loginButton = By.name("send");
    private static By myDashBoard = By.className("page-title");
    private static By helloUser = By.className("hello");

    //*********Constructor*********
    public LoginPage() {
        Assert.assertEquals("Customer Login", driver.getTitle());
    }

    //*********Page Methods*********
    public LoginPage userLogin(String userLogin, String userPass) {
        driver.findElement(userLoginName).sendKeys(userLogin);
        driver.findElement(userPassword).sendKeys(userPass);
        driver.findElement(loginButton).click();
        return this;
    }

    public LoginPage checkIfUserLogedIn(String firstName, String lastName) {
        driver.findElement(myDashBoard).isDisplayed();
        driver.findElement(helloUser).isDisplayed();
        Assert.assertEquals("Hello, " + firstName + " " + lastName + "!", driver.findElement(helloUser).getText());
        return this;
    }


}
