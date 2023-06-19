package com.phonebook.tests;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

  WebDriver driver;

  @BeforeMethod
  public void setUp(){
    System.err.close(); //system mistake disappear
    driver = new ChromeDriver();
    driver.get("https://telranedu.web.app");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  public boolean isHomeComponentPresent() {
    return driver.findElements(By.cssSelector("div:nth-child(2)>div>div")).size() > 0;
  }

  public boolean isElementPresent(By locator) {
    return driver.findElements(locator).size() > 0;
  }

  public boolean isHomeComponentPresent1() {
    try {
      driver.findElement(By.cssSelector("div:nth-child(2)>div>div"));
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public boolean isElementPresent1(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  @AfterMethod(enabled = false)
  public void tearDown() {
    driver.quit();
  }

  public void type(By locator, String text) {
    driver.findElement(locator).click();
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  public void click(By locator) {
    driver.findElement(locator).click();
  }

  public boolean isAlertPresent() {
    Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
        .until(ExpectedConditions.alertIsPresent());

    if (alert == null) {
      return false;
    } else {
      driver.switchTo().alert();
      alert.accept();
      return true;
    }
  }
}
