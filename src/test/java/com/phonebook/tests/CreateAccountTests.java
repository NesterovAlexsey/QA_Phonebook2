package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

  //precondition: user should be logged out
  @BeforeMethod
  public void ensurePrecondition() {
    if (!isElementPresent(By.cssSelector("[href='/login']"))) {
      driver.findElement(By.xpath("//button[.='Sign Out']")).click();
    }
  }

  @Test
  public void newUserRegistrationPositiveTest() {
    //click on Login link
    click((By.cssSelector("[href='/login']")));
    //enter email field
    type();
    //enter password
    driver.findElement(By.cssSelector("[placeholder='Password']")).click();
    driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
    driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Word212345$");
    // click on registration button
    driver.findElement(By.name("registration")).click();
    //assert Sign out button is displayed
    Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
  }

  public void type() {
    driver.findElement(By.cssSelector("[placeholder='Email']")).click();
    driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
    driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("alex2@gmail.com");
  }

  public void click(By locator) {
    driver.findElement(locator);
  }
}
