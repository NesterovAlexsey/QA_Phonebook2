package com.phonebook.tests;

import com.phonebook.model.Contact;
import com.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }

    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginRegistrationForm(new User().setEmail("alex2@gmail.com").setPassword("Word212345$"));
    app.getUser().clickOnLoginButton();

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
  }

//  @Test // первый метод, дз, проверка удаления конкретного элемента
//      public void isContactFormDeleted() {
//      app.getContact().openContactForm("Alex");
//      app.getContact().clickOnRemoveButton();
//      Assert.assertTrue(app.getContact().findElementAfterRemove("Alex"));
//  }

  @Test //проверка работы функции удаления в принципе
  public void removeContactTest() {
    int sizeBefore = app.getContact().sizeOfContacts();

    app.getContact().openContactForm("Alex");
    app.getContact().clickOnRemoveButton();
    app.getContact().pause(2000);

    int sizeAfter = app.getContact().sizeOfContacts();

    Assert.assertEquals(sizeAfter, sizeBefore-1);
  }
}
