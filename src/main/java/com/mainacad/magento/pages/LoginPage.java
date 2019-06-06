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
        Assert.assertEquals(getDriver().getTitle(), "Customer Login");
    }

    //*********Page Methods*********
    public LoginPage userLogin(String userLogin, String userPass) {
        getDriver().findElement(userLoginName).sendKeys(userLogin);
        getDriver().findElement(userPassword).sendKeys(userPass);
        getDriver().findElement(loginButton).click();
        return this;
    }

    public MyDashboardPage checkIfUserLogedIn(String firstName, String lastName) {
        getDriver().findElement(myDashBoard).isDisplayed();
        getDriver().findElement(helloUser).isDisplayed();
        Assert.assertEquals("Hello, " + firstName + " " + lastName + "!", getDriver().findElement(helloUser).getText());
        return new MyDashboardPage();
    }


}
