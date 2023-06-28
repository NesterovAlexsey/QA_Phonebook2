package com.phonebook.fw;

import com.phonebook.model.Contact;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;

public class DataProviders {
  @DataProvider
  public Iterator<Object[]> addContactFromCsvFile() throws IOException {

    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/users.csv")));

    String line = reader.readLine();

    while (line != null) {
      String[] split = line.split(",");

      list.add(new Object[]{new Contact()
          .setName(split[0])
          .setLastname(split[1])
          .setPhone(split[2])
          .setEmail(split[3])
          .setAddress(split[4])
          .setDesc(split[5])});

      line = reader.readLine();
    }
    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> addContactsIncorrectPhone() throws IOException {

    List<Object[]> list = new ArrayList<>();
    BufferedReader reader =
        new BufferedReader(
            new FileReader(
                new File("src/test/resources/usersIncorrectPhones.csv")
            )
        );

    String line = reader.readLine();

    while (line != null) {
      String[] split = line.split(",");

      list.add(new Object[]{new Contact()
          .setName(split[0])
          .setLastname(split[1])
          .setPhone(split[2])
          .setEmail(split[3])
          .setAddress(split[4])
          .setDesc(split[5])});

      line = reader.readLine();
    }
    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> addContact() {

    List<Object[]> list = new ArrayList<>();
    list.add(new Object[]{"Oliver", "Kan", "1234567890", "frend@com.dmw", "frankfurt", "football"});
    list.add(new Object[]{"Simon", "Kan", "1234567890", "frend@com.dmw", "frankfurt", "football"});
    list.add(new Object[]{"Fred", "Kan", "1234567890", "frend@com.dmw", "frankfurt", "football"});

    return list.iterator();
  }


}
