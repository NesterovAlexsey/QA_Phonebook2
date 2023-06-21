package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
  }

  @Test
  public void existedUserRegistrationNegativeTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginRegistrationForm(new User().setEmail("alex2@gmail.com").setPassword("Word212345$"));
    app.getUser().clickOnRegistrationButton();

    Assert.assertTrue(app.getUser().isAlertPresent());
  }

}
