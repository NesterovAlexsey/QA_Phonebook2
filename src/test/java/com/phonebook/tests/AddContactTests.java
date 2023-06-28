package com.phonebook.tests;

import com.phonebook.fw.DataProviders;
import com.phonebook.model.Contact;
import com.phonebook.model.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginRegistrationForm(
        new User().setEmail("alex2@gmail.com").setPassword("Word212345$"));
    app.getUser().clickOnLoginButton();
  }

  @Test(enabled = false)
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

  @Test(enabled = false, dataProvider = "addContact",dataProviderClass = DataProviders.class)
  public void addContactPositiveFromDataProviderTest(
      String name, String lastName, String phone, String email, String address,
      String description) {
    app.getContact().clickOnAddLink();
    app.getContact().fillAddContactForm(
        new Contact()
            .setName(name)
            .setLastname(lastName)
            .setPhone(phone)
            .setEmail(email)
            .setAddress(address)
            .setDesc(description)
    );
    app.getContact().clickOnSaveButton();

    Assert.assertTrue(app.getContact().isContactCreated(name));
  }

  @Test(dataProvider = "addContactFromCsvFile",dataProviderClass = DataProviders.class)
  public void addContactPositiveFromCsvTest(Contact contact) {
    app.getContact().clickOnAddLink();

    app.getContact().fillAddContactForm(contact);

    app.getContact().clickOnSaveButton();
  }

  @AfterMethod(enabled = false)
  public void deleteContactForm() {
    app.getContact().openContactForm("Alex");
    app.getContact().clickOnRemoveButton();
  }

  @AfterMethod
  public void cleanContactFrom() {
    app.getContact().cleanAllContactFrom();
  }
}

