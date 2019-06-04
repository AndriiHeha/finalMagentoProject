package com.mainacad.magento.tests;

import com.mainacad.magento.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests extends BaseTest {

    private static String firstName = "Andrii";
    private static String lastName = "Heha";
    private static String emailAddress = "andriiHeha@test.com";
    private static String userPassword = "111111";

    private static final int SHOW_TWENTY_FIVE_ITEMS_ON_PAGE = 25;
    private static final int SHOW_FIVE_ITEMS_ON_PAGE = 5;
    private static final int LIMIT_PRICE = 1000;
    private static String SORT_BY_PRICE = "Price";
    private static String AUTOMATION_OPTION = "Automation";

    private static ElectronicsPage electronicsPage;


    //***********Test Case 1. Check Items counter:*************
    @BeforeMethod(alwaysRun = true, dependsOnMethods = "setup")
    public void setLanguageAutomation() {
        electronicsPage = new HomePage()
                .setLanguageAutomation(AUTOMATION_OPTION)
                .goToHomeDecorPage()
                .goToElectronicsPage();

    }

    @Test(priority = 1)
    public void goToElectronicsPageAndClickAndCheckAmountOfProducts() {
        electronicsPage.clickShowAsList()
                .selectTwentyFiveItemsToShow(SHOW_TWENTY_FIVE_ITEMS_ON_PAGE)
                .showProductList()
                .checkAmountOfProducts();
    }

    //***********Test Case 2. Check “SHOW” select ************
    @Test(priority = 2)
    public void testCaseTwoCheckShowSelect() {
        electronicsPage.testCaseTwoCheckShowSelect(SHOW_FIVE_ITEMS_ON_PAGE);
    }

    @Test(priority = 3)
    public void testCaseThreeCheckSortBy(){
        new ElectronicsPage().testCaseThreeCheckSortBy(SHOW_TWENTY_FIVE_ITEMS_ON_PAGE, SORT_BY_PRICE);

    }
    @Test(priority = 4)
    public void testCaseFourCheckPriceFilter(){
        new ElectronicsPage().testCaseFourCheckPriceFilter(SHOW_TWENTY_FIVE_ITEMS_ON_PAGE,LIMIT_PRICE);

    }
/*
    @Test (priority = 5)
    //***********Go to login page, login and check if user loged in**********
    public void goToLoginPage() throws InterruptedException {
        new HomePage().goToLoginPage()
                .userLogin(emailAddress,userPassword)
                .checkIfUserLogedIn(firstName, lastName);
                //.setLanguageAutomation();
    }
*/

}
