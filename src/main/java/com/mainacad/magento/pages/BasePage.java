package com.mainacad.magento.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BasePage {
    private static WebDriver driver;
    private static WebElement highlitedElem;

    public static WebDriver getDriver() {
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('fixedban').style.display = 'none';");
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static void highlightElement(WebElement element) throws InterruptedException {
        unhighlightElement();
        highlitedElem = element;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: red; border: 3px solid red;");
    }

    public static void unhighlightElement() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", highlitedElem, "");
        } catch (Exception e) {
        }
    }
}