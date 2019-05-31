package com.mainacad.magento.tests;

import com.mainacad.magento.pages.*;
import com.mainacad.magento.tests.BaseTest;
import org.testng.annotations.Test;

public class Tests extends BaseTest {

    private static String firstName = "Andrii";
    private static String lastName = "Heha";
    private static String emailAddress = "andriiHeha@test.com";
    private static String userPassword = "111111";
    /*
    @Test (priority = 1)
    //***********Go to login page, login and check if user loged in**********
    public void goToLoginPage() throws InterruptedException {
        new HomePage().goToLoginPage()
                .userLogin(emailAddress,userPassword)
                .checkIfUserLogedIn(firstName, lastName)
                .setLanguageAutomation();
    }
    */
    @Test(priority = 1)
    public void setLanguageAutomation(){
        new HomePage().setLanguageAutomation()
                      .goToHomeDecorPage();

    }
    @Test(priority = 2)
    public void goToElectronicsPage(){
        new HomeDecorPage().goToElectronicsPage();
    }
    @Test(priority = 3)
    public void clickShowAsList(){
        new ElectronicsPage().clickShowAsList()
                            .select25RecordstoShow()
                            .shownProductList();
    }

}
