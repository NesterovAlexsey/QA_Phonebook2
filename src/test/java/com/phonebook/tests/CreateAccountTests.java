package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

  //precondition: user should be logged out
  @BeforeMethod
  public void ensurePrecondition() {
    if (!isLoginLinkPresent()) {
      driver.findElement(By.xpath("//button[.='Sign Out']")).click();
    }
  }

  public boolean isLoginLinkPresent() {
    return isElementPresent(By.cssSelector("[href='/login']"));
  }

  @Test
  public void existedUserRegistrationNegativeTest() {
    //click on Login link
    click((By.cssSelector("[href='/login']")));
    //enter email field
    type(By.cssSelector("[placeholder='Email']"), "alex2@gmail.com");
    //enter password
    type(By.cssSelector("[placeholder='Password']"), "Word212345$");
    // click on registration button
    click(By.name("registration"));
    //assert Sign out button is displayed
    Assert.assertTrue(isAlertPresent());
  }

}
