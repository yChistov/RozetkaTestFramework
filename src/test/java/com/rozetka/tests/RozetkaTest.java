package com.rozetka.tests;

import com.rozetka.data.RozetkaData;
import com.rozetka.pages.RozetkaCheckoutPage;
import com.rozetka.pages.RozetkaLoginPage;
import com.rozetka.pages.RozetkaSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;

@Listeners(com.rozetka.utils.ListenerTest.class)
public class RozetkaTest {

    protected WebDriver driver;
    RozetkaLoginPage rbMainPage;
    RozetkaSearchPage rSearchPage;
    RozetkaCheckoutPage rCheckoutPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        rbMainPage = PageFactory.initElements(driver, RozetkaLoginPage.class);
        rSearchPage = PageFactory.initElements(driver, RozetkaSearchPage.class);
        rCheckoutPage = PageFactory.initElements(driver, RozetkaCheckoutPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @Test(dataProviderClass = RozetkaData.class, dataProvider = "login")
    public void loginTest(String email, String pass, String result) {
        //login
        rbMainPage.loadPage();
        rbMainPage.login(email, pass);
        assertNotEquals(result, rbMainPage.getUserName());
    }

    @Test(dataProviderClass = RozetkaData.class, dataProvider = "search")
    public void searchTest(String item, String status) {
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
