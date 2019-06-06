package com.mainacad.magento.tests;

import com.mainacad.magento.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {

    private static String firstName = "Andrii";
    private static String lastName = "Heha";
    private static String emailAddress = "andriiHeha@test.com";
    private static String userPassword = "111111";

    private static String AUTOMATION_OPTION = "Automation";
    private static final int SHOW_TWENTY_FIVE_ITEMS_ON_PAGE = 25;

    private static final int SHOW_FIVE_ITEMS_ON_PAGE = 5;
    private static final int LIMIT_PRICE = 1000;
    private static String SORT_BY_PRICE = "Price";


    //***********Go to login page, login and check if user loged in**********
    @BeforeMethod(alwaysRun = true, dependsOnMethods = "setup")

    //***********Go to login page, login and check if user loged in**********
    public void goToLoginPage() {
        new HomePage().setLanguageAutomation(AUTOMATION_OPTION)
                .goToLoginPage()
                .userLogin(emailAddress, userPassword)
                .checkIfUserLogedIn(firstName, lastName);

    }
    //***********Check if user loged in**********
    @Test(priority = 1)
    public void checkIfUserOnMyDashboard() {
        new MyDashboardPage().checkNavigationOnMyDashboard(firstName, lastName);

    }

    @Test(priority = 2)
    public void goToHomeDecorAndElectronicts() {
        new MyDashboardPage().goToHomeDecorPage();
        new HomeDecorPage().goToElectronicsPage()
                .clickShowAsList()
                .selectTwentyFiveItemsToShow(SHOW_TWENTY_FIVE_ITEMS_ON_PAGE)
                .testCaseFiveAddToWishListItemsRandom();
        new WishlistPage().checkIfProductAddedToWishList();
    }
}
