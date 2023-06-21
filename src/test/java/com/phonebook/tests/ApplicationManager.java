package com.phonebook.tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {

  WebDriver driver;

  public UserHelper getUser() {
    return user;
  }

  public ContactHelper getContact() {
    return contact;
  }

  public HomePageHelper getHomePage() {
    return homePage;
  }

  UserHelper user;
  ContactHelper contact;
  HomePageHelper homePage;
  public void init() {
    System.err.close();
    driver = new ChromeDriver();
    driver.get("https://telranedu.web.app");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    user = new UserHelper(driver);
    contact = new ContactHelper(driver);
    homePage = new HomePageHelper(driver);
  }

  public void stop() {
    driver.quit();
  }

}
