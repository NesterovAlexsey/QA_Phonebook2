package com.phonebook.tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {
    if (!isElementPresent(By.cssSelector("[href='/login']"))) {
      driver.findElement(By.xpath("//button[.='Sign Out']")).click();
    }
    click((By.cssSelector("[href='/login']")));
    type(By.cssSelector("[placeholder='Email']"), "alex2@gmail.com");
    type(By.cssSelector("[placeholder='Password']"), "Word212345$");
    click(By.name("login"));
  }

  @Test
  public void addContactPositiveTest() {
    click(By.xpath("//a[.='ADD']"));

    type(By.cssSelector("input:nth-child(1)"), "Alex");
    type(By.cssSelector("input:nth-child(2)"), "Nestor");
    type(By.cssSelector("input:nth-child(3)"), "1234567890");
    type(By.cssSelector("input:nth-child(4)"), "weiseguy@gm.com");
    type(By.cssSelector("input:nth-child(5)"), "Paris");
    type(By.cssSelector("input:nth-child(6)"), "must visit that guy");

    click(By.cssSelector(".add_form__2rsm2 button"));

    Assert.assertTrue(isContactCreated("Alex"));
  }

  public boolean isContactCreated(String text) {
    List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
    for (WebElement element : contacts) {
      if (element.getText().contains(text))
        return true;
    }
    return false;
  }
}
