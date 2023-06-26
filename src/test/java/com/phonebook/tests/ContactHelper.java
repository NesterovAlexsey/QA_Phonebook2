package com.phonebook.tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactHelper extends BaseHelper{

  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  public void clickOnSaveButton() {
    click(By.cssSelector(".add_form__2rsm2 button"));
  }

  public void fillAddContactForm(Contact contact) {
    type(By.cssSelector("input:nth-child(1)"), contact.getName());
    type(By.cssSelector("input:nth-child(2)"), contact.getLastname());
    type(By.cssSelector("input:nth-child(3)"), contact.getPhone());
    type(By.cssSelector("input:nth-child(4)"), contact.getEmail());
    type(By.cssSelector("input:nth-child(5)"), contact.getAddress());
    type(By.cssSelector("input:nth-child(6)"), contact.getDesc());
  }

  public void clickOnAddLink() {
    click(By.xpath("//a[.='ADD']"));
  }

  public boolean isContactCreated(String text) {
    List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
    for (WebElement element : contacts) {
      if (element.getText().contains(text))
        return true;
    }
    return false;
  }

  public void openContactForm(String nameOfCard) {
    List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
    for (WebElement element : contacts) {
      if (element.getText().contains(nameOfCard)) {
        element.click();
      }
    }
  }

  public boolean findElementAfterRemove(String nameOfCard) {
    List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
    if (contacts.isEmpty()) {
      return true;
    }
    for (WebElement element : contacts) {
      if (element.getText().contains(nameOfCard)) {
        return false;
      }
    }
    return true;
  }

  public void clickOnRemoveButton() {
    click(By.xpath("//button[contains(text(),'Remove')]"));
  }
}
