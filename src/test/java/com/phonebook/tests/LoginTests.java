package com.phonebook.tests;

import com.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
  }

  @Test
  public void loginPositiveTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginRegistrationForm(new User().setEmail("alex2@gmail.com").setPassword("Word212345$"));
    app.getUser().clickOnLoginButton();

    Assert.assertTrue(app.getUser().isSignOutButtonPresent());
  }
  @Test
  public void loginNegativeWithoutPasswordTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginRegistrationForm(new User().setEmail("alex2@gmail.com"));
    app.getUser().clickOnLoginButton();

    Assert.assertTrue(app.getUser().isAlertPresent());
  }
}
