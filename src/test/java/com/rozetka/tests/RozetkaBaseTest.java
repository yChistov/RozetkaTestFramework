package com.rozetka.tests;

import com.rozetka.core.BaseTest;
import com.rozetka.data.RozetkaData;
import com.rozetka.pages.RozetkaCheckoutPage;
import com.rozetka.pages.RozetkaLoginPage;
import com.rozetka.pages.RozetkaSearchPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;

@Listeners(com.rozetka.utils.ListenerTest.class)
public class RozetkaBaseTest extends BaseTest {

    @Test(dataProviderClass = RozetkaData.class, dataProvider = "login")
    public void loginTest(String email, String pass, String result) {
        RozetkaLoginPage rbMainPage = PageFactory.initElements(getDriver(), RozetkaLoginPage.class);
        //login
        rbMainPage.loadPage();
        rbMainPage.login(email, pass);
        assertNotEquals(result, rbMainPage.getUserName());
    }

    @Test(dataProviderClass = RozetkaData.class, dataProvider = "search")
    public void searchTest(String item, String status) {
        RozetkaSearchPage rSearchPage = PageFactory.initElements(getDriver(), RozetkaSearchPage.class);
        RozetkaCheckoutPage rCheckoutPage = PageFactory.initElements(getDriver(), RozetkaCheckoutPage.class);
        //search
        rSearchPage.loadPage();
        rSearchPage.setSearchText(item);
        //add to card
        rSearchPage.addToCardItem(item);
        //delete item
        rCheckoutPage.loadPage();
        rCheckoutPage.deleteItemFromCard(status);
    }
}
