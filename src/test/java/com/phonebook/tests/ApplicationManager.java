package com.phonebook.tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {

  String browser;
  WebDriver driver;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

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

    if (browser.equalsIgnoreCase("chrome")) {
      driver = new ChromeDriver();
    } else if (browser.equalsIgnoreCase("firefox")) {
      driver = new FirefoxDriver();
    } else if (browser.equalsIgnoreCase("edge")) {
      driver = new EdgeDriver();
    }

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
