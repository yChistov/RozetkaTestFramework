package com.rozetka.core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("headless", "false"); // You can set this property elsewhere
        String headless = System.getProperty("headless");

        ChromeDriverManager.chromedriver();
        if ("true".equals(headless)) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else {
            driver = new ChromeDriver();
        }
    }

    @AfterClass
    public void tearDown() {
        if (null != driver) {
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
