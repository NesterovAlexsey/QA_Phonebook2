package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {
    if (!isLoginLinkPresent()) {
      clickOnSignOutButton();
    }
    clickOnLoginLink();
    fillLoginRegistrationForm(new User().setEmail("alex2@gmail.com").setPassword("Word212345$"));
    clickOnLoginButton();
  }

  @Test
  public void addContactPositiveTest() {
    clickOnAddLink();
    fillAddContactForm(
        new Contact()
            .setName("Alex")
            .setLastname("Nestor")
            .setPhone("1234567890")
            .setEmail("weiseguy@gm.com")
            .setAddress("Paris")
            .setDesc("must visit that guy")
    );
    clickOnSaveButton();

    Assert.assertTrue(isContactCreated("Alex"));
  }

}
