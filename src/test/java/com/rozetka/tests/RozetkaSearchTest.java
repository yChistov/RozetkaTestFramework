package com.rozetka.tests;

import com.rozetka.core.BaseTest;
import com.rozetka.data.RozetkaData;
import com.rozetka.pages.RozetkaCheckoutPage;
import com.rozetka.pages.RozetkaSearchPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.rozetka.utils.ListenerTest.class)
public class RozetkaSearchTest extends BaseTest {

    RozetkaSearchPage rSearchPage;
    RozetkaCheckoutPage rCheckoutPage;

    @Test(dataProviderClass = RozetkaData.class, dataProvider = "search")
    public void searchTest(String item, String status) {
        rSearchPage = PageFactory.initElements(getDriver(), RozetkaSearchPage.class);
        rCheckoutPage = PageFactory.initElements(getDriver(), RozetkaCheckoutPage.class);
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
