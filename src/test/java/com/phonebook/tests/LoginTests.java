package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
  @BeforeMethod
  public void ensurePrecondition() {
    if (!isLoginLinkPresent()) {
      clickOnSignOutButton();
    }
  }

  @Test
  public void loginPositiveTest() {
    clickOnLoginLink();
    fillLoginRegistrationForm(new User().setEmail("alex2@gmail.com").setPassword("Word212345$"));
    clickOnLoginButton();

    Assert.assertTrue(isSignOutButtonPresent());
  }
  @Test
  public void loginNegativeWithoutPasswordTest() {
    clickOnLoginLink();
    fillLoginRegistrationForm(new User().setEmail("alex2@gmail.com"));
    clickOnLoginButton();

    Assert.assertTrue(isAlertPresent());
  }
}
