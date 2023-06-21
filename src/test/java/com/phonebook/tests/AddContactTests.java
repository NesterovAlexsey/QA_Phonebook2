package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginRegistrationForm(new User().setEmail("alex2@gmail.com").setPassword("Word212345$"));
    app.getUser().clickOnLoginButton();
  }

  @Test
  public void addContactPositiveTest() {
    app.getContact().clickOnAddLink();
    app.getContact().fillAddContactForm(
        new Contact()
            .setName("Alex")
            .setLastname("Nestor")
            .setPhone("1234567890")
            .setEmail("weiseguy@gm.com")
            .setAddress("Paris")
            .setDesc("must visit that guy")
    );
    app.getContact().clickOnSaveButton();

    Assert.assertTrue(app.getContact().isContactCreated("Alex"));
  }

  @AfterMethod
  public void deleteContactForm() {
    app.getContact().openContactForm("Alex");
    app.getContact().clickOnRemoveButton();
  }
}
