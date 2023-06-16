package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;

public class CreateAccountTests extends TestBase {
  //precondition: user should be logged out
  @BeforeMethod
  public void ensurePrecondition() {
    if (!isElementPresent(By.cssSelector("[href='/login']"))) {
      driver.findElement(By.xpath("//button[.='Sign Out']")).click();
    }
  }



  //click on Login link
  //enter email field
  //enter password
  // click on login button
  //assert Sign out button is displayed

}
