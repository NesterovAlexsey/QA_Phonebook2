package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
  @BeforeMethod
  public void ensurePrecondition() {
    if (!isElementPresent(By.cssSelector("[href='/login']"))) {
      driver.findElement(By.xpath("//button[.='Sign Out']")).click();
    }
  }

  @Test
  public void loginPositiveTest() {
    //click on Login link
    click((By.cssSelector("[href='/login']")));
    //enter email field
    type(By.cssSelector("[placeholder='Email']"), "alex2@gmail.com");
    //enter password
    type(By.cssSelector("[placeholder='Password']"), "Word212345$");
    // click on registration button
    click(By.name("login"));
    //assert Sign out button is displayed
    Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
  }
}
