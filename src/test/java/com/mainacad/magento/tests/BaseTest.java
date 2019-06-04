package com.mainacad.magento.tests;

import com.mainacad.magento.pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        //Create a Chrome driver. All test classes use this.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //Maximize Window
        driver.manage().window().maximize();
        driver.get("http://magento.mainacad.com/");

        BasePage.setDriver(driver);
    }
/*
    @AfterMethod(alwaysRun = true)
    public void teardown() {
        if (BasePage.getDriver() != null) {
            BasePage.getDriver().close();
        }
    }
*/
}