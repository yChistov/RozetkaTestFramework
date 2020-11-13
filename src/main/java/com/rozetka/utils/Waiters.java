package com.rozetka.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waiters {

  private WebDriver driver;

  private WebDriverWait wait;

  public Waiters(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, 10);
  }

  // Element presence
  public WebElement waitForPresenceOfElement(By locator) {
    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  public WebElement waitForPresenceOfElement(String cssSelector) {
    return waitForPresenceOfElement(By.cssSelector(cssSelector));
  }

  public List<WebElement> waitForPresenceOfAllElements(By locator) {
    return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
  }

  public List<WebElement> waitForPresenceOfAllElements(String cssSelector) {
    return waitForPresenceOfAllElements(By.cssSelector(cssSelector));
  }
}
