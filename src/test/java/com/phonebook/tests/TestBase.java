package com.phonebook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

  protected static ApplicationManager app = new ApplicationManager();

  //@BeforeMethod
  @BeforeSuite
  public void setUp(){
    app.init();
  }

  //@AfterMethod(enabled = false)
  @AfterSuite
  public void tearDown() {
    app.stop();
  }

}
