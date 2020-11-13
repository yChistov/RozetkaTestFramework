package com.rozetka.tests;

import com.rozetka.core.BaseTest;
import com.rozetka.data.RozetkaData;
import com.rozetka.pages.RozetkaLoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;

@Listeners(com.rozetka.utils.ListenerTest.class)
public class RozetkaLoginTest extends BaseTest {

  RozetkaLoginPage rbMainPage;

  @Test(dataProviderClass = RozetkaData.class, dataProvider = "login")
  public void loginTest(String email, String pass, String result) {
    rbMainPage = PageFactory.initElements(getDriver(), RozetkaLoginPage.class);
    // login
    rbMainPage.loadPage();
    rbMainPage.login(email, pass);
    assertNotEquals(result, rbMainPage.getUserName());
  }

  @Test
  public void loginTestWithoutDataProvider() {
    rbMainPage = PageFactory.initElements(getDriver(), RozetkaLoginPage.class);
    // login
    rbMainPage.loadPage();
    rbMainPage.login("email@gmail.com", "trololo");
    assertNotEquals("result", rbMainPage.getUserName());
  }
}
