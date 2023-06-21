package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

  //precondition: user should be logged out
  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.isLoginLinkPresent()) {
      app.clickOnSignOutButton();
    }
  }

  @Test
  public void existedUserRegistrationNegativeTest() {
    app.clickOnLoginLink();
    app.fillLoginRegistrationForm(new User().setEmail("alex2@gmail.com").setPassword("Word212345$"));
    app.clickOnRegistrationButton();

    Assert.assertTrue(app.isAlertPresent());
  }

}
