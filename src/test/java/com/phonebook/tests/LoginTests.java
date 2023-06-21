package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.isLoginLinkPresent()) {
      app.clickOnSignOutButton();
    }
  }

  @Test
  public void loginPositiveTest() {
    app.clickOnLoginLink();
    app.fillLoginRegistrationForm(new User().setEmail("alex2@gmail.com").setPassword("Word212345$"));
    app.clickOnLoginButton();

    Assert.assertTrue(app.isSignOutButtonPresent());
  }
  @Test
  public void loginNegativeWithoutPasswordTest() {
    app.clickOnLoginLink();
    app.fillLoginRegistrationForm(new User().setEmail("alex2@gmail.com"));
    app.clickOnLoginButton();

    Assert.assertTrue(app.isAlertPresent());
  }
}
