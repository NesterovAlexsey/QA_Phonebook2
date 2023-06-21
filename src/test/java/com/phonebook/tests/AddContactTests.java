package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.isLoginLinkPresent()) {
      app.clickOnSignOutButton();
    }
    app.clickOnLoginLink();
    app.fillLoginRegistrationForm(new User().setEmail("alex2@gmail.com").setPassword("Word212345$"));
    app.clickOnLoginButton();
  }

  @Test
  public void addContactPositiveTest() {
    app.clickOnAddLink();
    app.fillAddContactForm(
        new Contact()
            .setName("Alex")
            .setLastname("Nestor")
            .setPhone("1234567890")
            .setEmail("weiseguy@gm.com")
            .setAddress("Paris")
            .setDesc("must visit that guy")
    );
    app.clickOnSaveButton();

    Assert.assertTrue(app.isContactCreated("Alex"));
  }

  @AfterMethod
  public void deleteContactForm() {
    app.openContactForm("Alex");
    app.clickOnRemoveButton();
  }
}
