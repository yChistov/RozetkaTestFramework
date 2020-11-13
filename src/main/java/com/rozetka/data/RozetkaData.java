package com.rozetka.data;

import org.testng.annotations.DataProvider;

public class RozetkaData {

  @DataProvider(name = "login")
  public static Object[][] login() {
    return new Object[][] {
      {"kaluja@ukr.net", "ghjuhfvbcn", "Ярослав Чистов"},
    };
  }

  @DataProvider(name = "search")
  public static Object[][] search() {
    return new Object[][] {
      {"Apple iPhone 11 Pro Max 256GB", "Корзина пуста"},
      //                {"Samsung Galaxy S20 Ultra"},
    };
  }
}
